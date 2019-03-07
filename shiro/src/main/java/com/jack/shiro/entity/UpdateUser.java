package com.jack.shiro.entity;

/**
 * @author : peng
 * @Description : updat语句更新测试
 * @Date : 2019-02-28 11:22
 */

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "update_user")
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser implements Serializable {

    private static final long serialVersionUid = 1L;
    /**
     * User_ID
     */
    @Id
    @GeneratedValue
    /**
     *
     */
    @Column(name = "userId")
    @JSONField(name = "hhhh",ordinal = 2)
    private Integer userId;
    /**
     *
     */
    @Column(name = "name")
    @JSONField(serialize = true,ordinal = 1)
    private String name;





}