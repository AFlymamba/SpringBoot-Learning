package com.springboot.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.rbac.entity.Permission;

import java.util.List;

/**
 * 权限 mapper
 *
 * @author huangyin
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    /**
     * 查询当前用户所持有的权限
     *
     * @param userId 用户 id
     * @return 持有的权限集
     */
    List<Permission> selectByUserId(final Long userId);
}
