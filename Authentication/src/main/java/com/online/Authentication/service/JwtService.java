package com.online.Authentication.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private String jwtSecretKey ="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


    public String generateToken(String username){
        Map<String ,Object> claims = new HashMap<>();
        return createToken(claims,username);
    }
    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

    private String createToken(Map<String, Object> claims, String username) {
       return  Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() *1000*60*30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getSignKey(){
        byte[] bytes = Base64.getDecoder().decode(jwtSecretKey);
        return Keys.hmacShaKeyFor(bytes);
    }


}
