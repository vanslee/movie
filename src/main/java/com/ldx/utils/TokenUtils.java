package com.ldx.utils;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtils {
    /**
     * 生成Token
     * @return
     */
    public static String getToken(String userId,String sign) {// 以password作为签名
        return JWT.create().withAudience(userId) //将user id 保存到token里面,作为载荷
                .withExpiresAt(DateUtil.offsetMinute(new Date(),15)) //使用hutool里的util设置两小时过期
                .sign(Algorithm.HMAC256(sign)); // 以password 作为 token的密钥
         }
}
