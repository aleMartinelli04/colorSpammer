import javax.swing.*;
import java.awt.*;

public class ColorSpammerFrame extends JFrame {
    private final JTextField colorCode;
    private boolean showColor;

    private Runnable colorChanger;
    private Thread thread;

    public ColorSpammerFrame() {
        super("ColorSpammer 2.0");

        this.showColor = false;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2);

        setLocationRelativeTo(null);

        this.colorCode = new JTextField();

        colorCode.setSize(getSize());
        colorCode.setEditable(false);
        colorCode.setOpaque(false);

        colorCode.setFont(new Font("ARIAL", Font.PLAIN, 40));
        colorCode.setHorizontalAlignment(SwingConstants.CENTER);

        add(colorCode);

        colorCode.addMouseListener(new Listener2dot0(this));
        this.colorChanger = new ColorChanger(this.colorCode);
    }

    public void setText(String text, Color color) {
        int red = color.getRed() > 130 ? (int) (color.getRed() * (1 - 0.5)) : (int) (color.getRed() + (255 - color.getRed()) * 0.5);
        int green = color.getGreen() > 130 ? (int) (color.getGreen() * (1 - 0.5)) : (int) (color.getGreen() + (255 - color.getGreen()) * 0.5);
        int blue = color.getBlue() > 130 ? (int) (color.getBlue() * (1 - 0.5)) : (int) (color.getBlue() + (255 - color.getBlue()) * 0.5);

        colorCode.setForeground(new Color(red, green, blue));
        colorCode.setText(text);
    }

    public boolean hasToShowColor() {
        showColor = !showColor;

        return !showColor;
    }

    public void stop() {
        if (thread == null) {
            return;
        }

        thread.stop();
    }

    public void start() {
        stop();

        colorChanger = new ColorChanger(this.colorCode);
        thread = new Thread(colorChanger);

        thread.start();
    }

    public void resetText() {
        colorCode.setText(null);
    }
}
