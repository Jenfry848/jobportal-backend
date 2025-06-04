package com.jobportal.jobportal.util;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;

import java.util.Date;

import java.util.UUID;

@Component

public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final long expiration = 86400000; // 1 jour en ms

    public String generateToken(UUID userId, String role) {

        return Jwts.builder()

                .setSubject(userId.toString())

                .claim("role", role)

                .setIssuedAt(new Date())

                .setExpiration(new Date(System.currentTimeMillis() + expiration))

                .signWith(key)

                .compact();

    }

    public String getSecretKeyBase64() {

        return java.util.Base64.getEncoder().encodeToString(key.getEncoded());

    }

}

