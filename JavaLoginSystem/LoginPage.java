package JavaLoginSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    HashMap<String, String> loginInfo = new HashMap<>();
    JFrame jFrame = new JFrame();
    JButton buttonLogin = new JButton("Login");
    JButton buttonReset = new JButton("Reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("UserID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("Enter userId and password");


    public LoginPage(HashMap<String, String> loginInfoOrigin){
        loginInfo = loginInfoOrigin;
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        userIdLabel.setBounds(50, 100, 100, 25);
        userIdLabel.setFont(new Font(null, Font.ITALIC, 15));
        userPasswordLabel.setBounds(50, 150, 100,25);
        userPasswordLabel.setFont(new Font(null, Font.ITALIC, 15));
        messageLabel.setBounds(125, 200, 150, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));

        userIdField.setBounds(150, 100, 200, 25);
        userPasswordField.setBounds(150, 150, 200, 25);

        buttonLogin.setBounds(150, 250, 100, 25);
        buttonLogin.addActionListener(this);

        buttonReset.setBounds(260, 250, 100, 25);
        buttonReset.addActionListener(this);

        jFrame.add(buttonReset);
        jFrame.add(buttonLogin);
        jFrame.add(userIdLabel);
        jFrame.add(userIdField);
        jFrame.add(userPasswordLabel);
        jFrame.add(userPasswordField);
        jFrame.add(messageLabel);
        jFrame.setSize(500, 500);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonReset){
            userIdField.setText("");
            userPasswordField.setText("");
            userIdField.setBorder(null);
            userPasswordField.setBorder(null);
            messageLabel.setText("Enter userId and password");
        }
        if(e.getSource() == buttonLogin){
            System.out.println(userIdField.getText());
            String userId = userIdField.getText();
            System.out.println(userPasswordField.getPassword());
            String userPassword = String.valueOf(userPasswordField.getPassword());
            if(loginInfo.containsKey(userId)){
                userIdField.setBorder(null);
                if(loginInfo.get(userId).equals(userPassword)){
                    messageLabel.setText("Login success!!!");
                    messageLabel.setForeground(Color.green);
                    userPasswordField.setBorder(null);
                    WelcomePage welcomePage = new WelcomePage();
                }else {
                    userPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    messageLabel.setText("Password invalid");
                }
            }else {
                userIdField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                messageLabel.setText("UserID invalid!!");
            }
        }
    }
}
