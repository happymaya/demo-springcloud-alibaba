package cn.happymaya.imayamall.dao;

import cn.happymaya.imayamall.entity.ImayaMallUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>ImayaMallUser Dao 接口定义</h1>
 * */
public interface ImayaMallUserDao extends JpaRepository<ImayaMallUser, Long> {

    /**
     * <h2>根据用户名查询 EcommerceUser 对象</h2>
     * select * from t_imaya_mall_user where username = ?
     * */
    ImayaMallUser findByUsername(String username);

    /**
     * <h2>根据用户名和密码查询实体对象</h2>
     * select * from t_imaya_mall_user where username = ? and password = ?
     * */
    ImayaMallUser findByUsernameAndPassword(String username, String password);

}
