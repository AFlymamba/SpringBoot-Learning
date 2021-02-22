package com.springboot.rbac.interceptor;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.springboot.rbac.common.annotation.AdminAnnotation;
import com.springboot.rbac.common.util.ApplicationContextHolder;
import com.springboot.rbac.entity.Permission;
import com.springboot.rbac.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * SpringMVC 全局拦截器
 *
 * @author huangyin
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final PermissionService permissionService = ApplicationContextHolder.getBean("permissionService");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // TODO 校验 jwt 是否正确，是否在有效期内，后续加入

        Long userId = 2L;
        boolean permissionStatus = this.checkPermission(handler, request, userId);
        if (!permissionStatus) {
            JSONObject contentJson = JSONUtil.createObj().putOnce("statusCode", HttpStatus.FORBIDDEN.value())
                    .putOnce("message", "当前用户没有权限访问！");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write(contentJson.toString());
            return false;
        }
        return true;
    }

    /**
     * 检查当前请求用户对请求资源是否有权限
     *
     * @param handler Object
     * @param request HttpServletRequest
     * @param userId  用户 id
     * @return 是否有权限
     */
    private boolean checkPermission(final Object handler, final HttpServletRequest request, final Long userId) {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        try {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            // 获取当前请求资源地址，相对地址
            String requestUri = request.getRequestURI();

            // 获取请求的当前方法是否有权限注解
            AdminAnnotation adminAnnotation = AnnotationUtil.getAnnotation(method, AdminAnnotation.class);
            if (null == adminAnnotation) {
                return true;
            }
            // 查询当前用户的角色
            List<Permission> permissions = permissionService.getByUserId(userId);
            for (Permission permission : permissions) {
                if (permission.getValue().equals(requestUri)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("拦截器校验当前用户对当前请求是否有权限出现异常，异常信息为：[{}]", e.getMessage());
        }
        return false;
    }
}
