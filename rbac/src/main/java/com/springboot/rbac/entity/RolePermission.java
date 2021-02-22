package com.springboot.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限表
 *
 * @author huangyin
 */
@Data
@TableName("role_permission")
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 7438962227955848023L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色 id
     */
    private Long roleId;

    /**
     * 权限 id
     */
    private Long permissionId;
}
