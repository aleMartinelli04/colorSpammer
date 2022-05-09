import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class ColorChanger implements Runnable {
    private final JTextField colorCode;

    public ColorChanger(JTextField colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public void run() {
        while (true) {
            Color color = new Color(
                    ThreadLocalRandom.current().nextInt(256),
                    ThreadLocalRandom.current().nextInt(256),
                    ThreadLocalRandom.current().nextInt(256)
            );

            colorCode.setBackground(color);
        }
    }
}
