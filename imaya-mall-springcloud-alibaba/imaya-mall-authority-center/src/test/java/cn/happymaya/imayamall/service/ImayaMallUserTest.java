package cn.happymaya.imayamall.service;

import cn.happymaya.imayamall.dao.ImayaMallUserDao;
import cn.happymaya.imayamall.entity.ImayaMallUser;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>EcommerceUser 相关的测试</h1>
 * */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ImayaMallUserTest {

    @Autowired
    private ImayaMallUserDao imayaMallUserDao;

    @Test
    public void createUserRecord() {

        ImayaMallUser imayaMallUser = new ImayaMallUser();
        imayaMallUser.setUsername("superhsc@foxmail.com");
        imayaMallUser.setPassword(MD5.create().digestHex("12345678"));
        imayaMallUser.setExtraInfo("{}");
        log.info("save user: [{}]",
                JSON.toJSON(imayaMallUserDao.save(imayaMallUser)));

    }

    @Test
    public void selectUserByName() {
        log.info("select user By name: [{}]", JSON.toJSON(imayaMallUserDao.findByUsername("superhsc@foxmail.com")));
    }

    @Test
    public void selectUserByNameAndPassword() {
        log.info("select user By name and password: [{}]", JSON.toJSON(imayaMallUserDao.findByUsernameAndPassword("superhsc@foxmail.com", "25d55ad283aa400af464c76d713c07ad")));
    }
}
