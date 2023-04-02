package uz.pdp.appclickup.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {

    private static final long expireTime = 86400000;
    private static final String  secretKey = "maxfiySoz";
    public String generateToken(String username){
        Date expireDate = new Date(System.currentTimeMillis() + expireTime);
        return Jwts
                .builder()
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .compact();
    }

    public String getEmailFromToken(String token){
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }catch (Exception e){
            return null;
        }
    }
}
