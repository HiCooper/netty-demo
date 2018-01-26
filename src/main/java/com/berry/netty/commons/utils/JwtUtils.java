package com.berry.netty.commons.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

/**
 * @author Berry_Cooper
 * @date 2017/12/24.
 */
public class JwtUtils {

    /**
     * Create and Sign a Token
     *
     * @param openid
     * @return
     */
    public static String createAndSignToken(String openid) {
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create()
                    .withSubject(openid)
                    .withIssuer("auth0")
                    .sign(algorithm);

        } catch (UnsupportedEncodingException | JWTVerificationException exception) {
            //UTF-8 encoding not supported
            exception.printStackTrace();
        }
        return token;
    }

    /**
     * Verify a Token
     *
     * @param token
     * @return
     */
    public static String verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (UnsupportedEncodingException | JWTVerificationException exception) {
            //UTF-8 encoding not supported
            exception.printStackTrace();
        }
        assert jwt != null;
        return jwt.getSubject();
    }
}
