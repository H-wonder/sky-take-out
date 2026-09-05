package com.sky;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * 验证密码 MD5 加密的正确性
 * （对应 EmployeeServiceImpl 中登录密码比对时的 TODO 需求）
 */
public class PasswordMd5Test {

    @Test
    public void md5Test() {
        String password = "123456";
        // DigestUtils.md5DigestAsHex 是 Spring 提供的 MD5 工具，返回 32 位十六进制小写字符串
        //String md5 = DigestUtils.md5DigestAsHex(password.getBytes());

        String md5=DigestUtils.md5DigestAsHex(password.getBytes());

        System.out.println("密码 " + password + " 的 MD5 = " + md5);

        // 该值是 linux `echo -n "123456" | md5sum` 验证过的标准值，测试通过即代表 MD5 算法正确
        Assertions.assertEquals("e10adc3949ba59abbe56e057f20f883e", md5);
    }
}