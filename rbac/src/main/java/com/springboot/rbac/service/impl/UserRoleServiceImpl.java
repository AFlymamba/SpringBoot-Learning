package com.springboot.rbac.service.impl;

import com.springboot.rbac.mapper.UserRoleMapper;
import com.springboot.rbac.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户角色关系服务实现类
 *
 * @author huangyin
 */
@Slf4j
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleMapper userRoleMapper;

    public UserRoleServiceImpl(
            @Autowired UserRoleMapper userRoleMapper
    ) {
        this.userRoleMapper = userRoleMapper;
    }
}
