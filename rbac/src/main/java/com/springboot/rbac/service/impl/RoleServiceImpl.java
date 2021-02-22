package com.springboot.rbac.service.impl;

import com.springboot.rbac.mapper.RoleMapper;
import com.springboot.rbac.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色服务实现类
 *
 * @author huangyin
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;

    public RoleServiceImpl(
            @Autowired RoleMapper roleMapper
    ) {
        this.roleMapper = roleMapper;
    }
}
