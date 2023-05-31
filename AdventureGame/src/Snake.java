import java.util.Random;

public class Snake extends Obstacle{
    public Snake() {
        super(4, "Yılan", 0,12 , 0);
        Random random = new Random();
        int snakeDamage = random.nextInt(4) + 3;
        setDamage(snakeDamage);

    }
}
