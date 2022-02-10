package business;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Calendar;

public class JWTHandler {
    private static Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);

    public static String generateToken(String username) {
        //generer en token ud fra en hemmelig nøgle. Sæt udløb og brugernavn
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, 240);
        return Jwts.builder()
                .claim("username",username)
                .signWith(SignatureAlgorithm.HS512,key)
                .setExpiration(expiry.getTime())
                .compact();
    }
}
