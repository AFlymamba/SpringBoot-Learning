package com.springboot.rbac.service.impl;

import com.springboot.rbac.entity.Permission;
import com.springboot.rbac.mapper.PermissionMapper;
import com.springboot.rbac.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限服务实现类
 *
 * @author huangyin
 */
@Slf4j
@Service(value = "permissionService")
public class PermissionServiceImpl implements PermissionService {
    private final PermissionMapper permissionMapper;

    public PermissionServiceImpl(
            @Autowired PermissionMapper permissionMapper
    ) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<Permission> getByUserId(final Long userId) {
        return this.permissionMapper.selectByUserId(userId);
    }
}
