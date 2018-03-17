public class User {
    public ShootStrategy getShootStrategy() {
        return shootStrategy;
    }

    private ShootStrategy shootStrategy;
    private char sign;

    public Point getShootPoint() {
        return shootStrategy.getShootPoint();
    }

    public User(ShootStrategy shootStrategy, char sign) {
        this.shootStrategy = shootStrategy;
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }
}
