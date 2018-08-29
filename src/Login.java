import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField textUserLogin;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton clearButton;
    private JPanel mainPanel;

    public Login() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, textUserLogin.getText());
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textUserLogin.setText("");
                passwordField.setText("");
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
