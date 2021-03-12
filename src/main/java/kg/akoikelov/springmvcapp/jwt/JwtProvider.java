package kg.akoikelov.springmvcapp.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtProvider {

  @Value("${jwt.secret}")
  private String jwtSecret;

  @Value("${jwt.expireDays}")
  private int jwtExpireDays;

  public String generateToken(String login) {
    Date date =
        Date.from(
            LocalDate.now()
                .plusDays(this.jwtExpireDays)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());
    return Jwts.builder()
        .setSubject(login)
        .setExpiration(date)
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
      return true;
    } catch (Exception sEx) {
      sEx.printStackTrace();
    }
    return false;
  }

  public String getLoginFromToken(String token) {
    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
}
