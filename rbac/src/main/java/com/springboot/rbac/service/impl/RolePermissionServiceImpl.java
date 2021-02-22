package com.springboot.rbac.service.impl;

import com.springboot.rbac.mapper.RolePermissionMapper;
import com.springboot.rbac.service.RolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色权限关系服务实现类
 *
 * @author huangyin
 */
@Slf4j
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    private final RolePermissionMapper rolePermissionMapper;

    public RolePermissionServiceImpl(
            @Autowired RolePermissionMapper rolePermissionMapper
    ) {
        this.rolePermissionMapper = rolePermissionMapper;
    }
}
