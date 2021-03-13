package kg.akoikelov.springmvcapp.rest.serializers;

public class TokenSerializer {

    private String token;

    public TokenSerializer(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
