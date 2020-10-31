public class Token {
    private String token;
    private long position;

    public Token() {
    }

    public Token(String token, long position) {
        this.token = token;
        this.position = position;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", position=" + position +
                '}';
    }
}
