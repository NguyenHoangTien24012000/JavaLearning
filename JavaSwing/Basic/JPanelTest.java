package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;

public class JPanelTest {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(750, 750);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
//        jFrame.pack();

        JPanel jPanel1 = new JPanel();
        jPanel1.setBackground(Color.red);
        jPanel1.setBounds(0,0, 250, 250);

        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.blue);
        jPanel2.setBounds(250, 0 , 250,250);

        JPanel jPanel3 = new JPanel();
        jPanel3.setBackground(Color.GREEN);
        jPanel3.setBounds(0,250, 500, 250);

        Label label = new Label();
        label.setText("Test");
        label.setBackground(Color.gray);
        label.setBounds(0, 50, 100, 100);

        jFrame.add(jPanel1);
        jFrame.add(jPanel2);
        jFrame.add(jPanel3);
        jPanel3.add(label);
    }
}
