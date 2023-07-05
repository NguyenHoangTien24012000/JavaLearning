package JavaSwing.NewWindowTest;

import javax.swing.*;
import java.awt.*;

public class NewWindow {
    JFrame jFrame = new JFrame("New Window");
    JLabel jLabel = new JLabel("Hello");
    NewWindow(){
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

        jLabel.setBounds(100,50, 100,100);
        jLabel.setBackground(Color.red);
        jLabel.setOpaque(true);

        jFrame.add(jLabel);
    }
}
