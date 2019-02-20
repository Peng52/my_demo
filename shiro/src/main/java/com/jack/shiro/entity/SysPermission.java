package com.jack.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author : peng
 * @Description : 权限信息
 * @Date : 2019-02-20 11:49
 */
@Setter
@Getter
@Entity
public class SysPermission implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     *资源链接
     */
    private String url;
    
    /**
     * 资源类型
     */
    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;
    /**
     * 权限字符串 menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;
    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 父编号列表
     */
    private String parentIds;
    /**
     *是否可用 - 不可用时将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;
    
    /**
     *一个权限可以对应多个角色
     */
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> sysRoleList;

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                ", sysRoleList=" + sysRoleList +
                '}';
    }
}
