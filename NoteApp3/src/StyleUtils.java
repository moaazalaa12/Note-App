import javax.swing.*;
import java.awt.*;

public class StyleUtils {
    public static final Color BACKGROUND_COLOR = new Color(173, 216, 130);
    public static final Color BUTTON_COLOR = new Color(34, 139, 34);
    public static final Color TEXT_COLOR = Color.BLACK;
    public static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 14);
    public static final Font LINK_FONT = new Font("Arial", Font.BOLD, 12);

    public static void styleButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setBackground(BUTTON_COLOR);
        button.setFocusPainted(false);
    }
}