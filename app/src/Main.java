import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame");
        frame.setVisible(true);
        frame.setBounds(340, 260, 1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());
        JButton button_1 = new JButton("登陆");
        JButton button_2 = new JButton("注册");
        JTextField textField = new JTextField();
        textField.setVisible(true);
        textField.setBounds(0, 0, 300, 80);
        textField.setFont(new Font("Fira Code Medium", Font.BOLD, 32));

        frame.add(textField);

    }
}