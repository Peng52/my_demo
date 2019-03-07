package com.jack.shiro.shiro_test;

import com.jack.shiro.ShiroApplicationTests;
import com.jack.shiro.dao.UpdateUserDao;
import com.jack.shiro.entity.UpdateUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : peng
 * @Description : JPA层测试
 * @Date : 2019-02-20 11:07
 */
public class JpaTest extends ShiroApplicationTests {
    @Autowired
    private UpdateUserDao userDao;

    //Jpa 测试
    @Test
    public void test1(){

    }
    //更新所有字段的值测试
    @Test
    public void test(){
        UpdateUser user = new UpdateUser();
        user.setName("diiiiiii");
        //user.setUserId(1111);
        //userDao.save(user);
        userDao.saveAndFlush(user);

    }
  /*  public static void main(String[] args){
        UpdateUser user = new UpdateUser();
        user.setName("hhhhh");
        userDao.save(user);
    }*/







}
