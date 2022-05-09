import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener2dot0 extends JPanel implements MouseListener {
    private final ColorSpammerFrame colorSpammerFrame;

    public Listener2dot0(ColorSpammerFrame colorSpammerFrame) {
        this.colorSpammerFrame = colorSpammerFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (colorSpammerFrame.hasToShowColor()) {
            colorSpammerFrame.stop();

            Color color = e.getComponent().getBackground();

            String colorString = "RGB(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")";

            colorSpammerFrame.setText(colorString, color);
            return;
        }

        colorSpammerFrame.resetText();
        colorSpammerFrame.start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
