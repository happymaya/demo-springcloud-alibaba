package cn.happymaya.imayamall.service.impl;

import cn.happymaya.imayamall.constant.AuthorityConstant;
import cn.happymaya.imayamall.constant.CommonConstant;
import cn.happymaya.imayamall.dao.ImayaMallUserDao;
import cn.happymaya.imayamall.entity.ImayaMallUser;
import cn.happymaya.imayamall.service.IJWTService;
import cn.happymaya.imayamall.vo.LoginUserInfo;
import cn.happymaya.imayamall.vo.UsernameAndPassword;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * <h1>JWT 相关服务接口实现</h1>
 * */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class JWTServiceImpl implements IJWTService {

    private final ImayaMallUserDao imayaMallUserDao;

    public JWTServiceImpl(ImayaMallUserDao imayaMallUserDao) {
        this.imayaMallUserDao = imayaMallUserDao;
    }

    @Override
    public String generateToken(String username, String password) throws Exception {
        return generateToken(username, password, 0);
    }

    @Override
    public String generateToken(String username, String password, int expire)
            throws Exception {

        // 首先需要验证用户是否能够通过授权校验, 即输入的用户名和密码能否匹配数据表记录
        ImayaMallUser ecommerceUser = imayaMallUserDao.findByUsernameAndPassword(username, password);
        if (null == ecommerceUser) {
            log.error("can not find user: [{}], [{}]", username, password);
            return null;
        }

        // Token 中塞入对象, 即 JWT 中存储的信息, 后端拿到这些信息就可以知道是哪个用户在操作
        LoginUserInfo loginUserInfo = new LoginUserInfo(
                ecommerceUser.getId(), ecommerceUser.getUsername()
        );

        if (expire <= 0) {
            expire = AuthorityConstant.DEFAULT_EXPIRE_DAY;
        }

        // 计算超时时间
        ZonedDateTime zdt = LocalDate.now().plus(expire, ChronoUnit.DAYS)
                .atStartOfDay(ZoneId.systemDefault());
        Date expireDate = Date.from(zdt.toInstant());

        return Jwts.builder()
                // jwt payload --> KV
                .claim(CommonConstant.JWT_USER_INFO_KEY, JSON.toJSONString(loginUserInfo))
                // jwt id
                .setId(UUID.randomUUID().toString())
                // jwt 过期时间
                .setExpiration(expireDate)
                // jwt 签名 --> 加密
                .signWith(getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
//        return Jwts.builder().claim(CommonConstant.JWT_USER_INFO_KEY, JSON.toJSONString(loginUserInfo)).setId(UUID.randomUUID().toString()).setExpiration(expireDate).signWith(getPrivateKey(), SignatureAlgorithm.RS256).compact();
    }

    @Override
    public String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword)
            throws Exception {

        // 先去校验用户名是否存在, 如果存在, 不能重复注册
        ImayaMallUser oldUser = imayaMallUserDao.findByUsername(usernameAndPassword.getUsername());
        if (null != oldUser) {
            log.error("username is registered: [{}]", oldUser.getUsername());
            return null;
        }

        ImayaMallUser imayaMallUser = new ImayaMallUser();
        imayaMallUser.setUsername(usernameAndPassword.getUsername());
        imayaMallUser.setPassword(usernameAndPassword.getPassword());   // MD5 编码以后
        imayaMallUser.setExtraInfo("{}");

        // 注册一个新用户, 写一条记录到数据表中
        imayaMallUser = imayaMallUserDao.save(imayaMallUser);
        log.info("register user success: [{}], [{}]", imayaMallUser.getUsername(),
                imayaMallUser.getId());

        // 生成 token 并返回
        return generateToken(imayaMallUser.getUsername(), imayaMallUser.getPassword());
    }

    /**
     * <h2>根据本地存储的私钥获取到 PrivateKey 对象</h2>
     * */
    private PrivateKey getPrivateKey() throws Exception {

        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                new BASE64Decoder().decodeBuffer(AuthorityConstant.PRIVATE_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(priPKCS8);
    }
}