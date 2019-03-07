package com.jack.shiro.dao;

import com.jack.shiro.entity.UpdateUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author peng
 * @description update测试
 * @create 2019-02-28 11:27
 */
public interface UpdateUserDao extends JpaRepository<UpdateUser,Integer> {
}
