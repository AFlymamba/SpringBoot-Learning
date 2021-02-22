package com.springboot.rbac.service;

import com.springboot.rbac.entity.Permission;

import java.util.List;

/**
 * 权限服务接口
 *
 * @author huangyin
 */
public interface PermissionService {
    /**
     * 查询当前用户所持有的权限
     *
     * @param userId 用户 id
     * @return 结果集
     */
    List<Permission> getByUserId(Long userId);
}
