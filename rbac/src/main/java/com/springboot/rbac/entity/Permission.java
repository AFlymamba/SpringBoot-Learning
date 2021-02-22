package com.springboot.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 权限实体
 *
 * @author huangyin
 */
@Data
@TableName("permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = 864593770063370599L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限内容
     */
    private String value;
}
