package com.satyam.academia.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTHelper {
    private String SECRET_KEY = "154339e0d43663822d1ba5eba5e6aaa96419d398f778deb4a9fdc93dad8e5bf33264e72fb2411e96d83c44fc0ce19d60278964ff2207e4d02a3bb2c45be7233b3fd555c9d78d1b7bfa0385d08fab0b1838208b358d41f0a2b4451e9c83a6b373734750af484141640ad98988003e8a3b81b8474e53cd3686f4d2a53082eeb6e87459d906c43237602668cdc894ddd3d8b305ef11bdd4e9623b72909dafc9dd35b5a61c5f512d49bb1f7e345e32bb01657933fb99761d0f6c9a5b27e573441a7031aefec142f1949f626080e229f2f22ef9eed301e614ee770b8bf523a022bf58d8cabcf7aada200675758feaea91d740cefbb8beb616428ea4851a42abc467c5";

    // Extract username from the token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract expiration date from the token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extract claims
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Extract all claims
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // Check if token is expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Generate token
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    // Create token with claims
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 1000 * 60)) // Token valid for 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // Validate token
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}
