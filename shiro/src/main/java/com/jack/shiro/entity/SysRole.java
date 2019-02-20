package com.jack.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author : peng
 * @Description : 角色
 * @Date : 2019-02-20 11:38
 */
@Getter
@Setter
@Entity
public class SysRole implements Serializable {
    /**
     *主键ID
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     *角色表示 - 唯一性
     */
    private String role;
    /**
     *角色描述 - UI界面描述
     */
    private String description;
    /**
     *是否可用 - 不可用时将不会添加给用户
     */
    private Boolean available = Boolean.TRUE;

    /**
     *角色对应多个用户
     * Many2Many
     */
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
    private List<UserInfo> userInfoList;
    /**
     *角色对应多个权限  用户、角色、权限、三者之间都是Many2Many的关系
     */
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> sysPermissionList;



    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
