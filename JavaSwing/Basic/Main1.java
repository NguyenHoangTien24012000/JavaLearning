package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;

public class Main1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Test");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
//        jFrame.setResizable(false);
        ImageIcon icon = new ImageIcon("/Users/nguyenhoangtien/Documents/ChallangeJava/src/JavaSwing/Basic/test.png");
        jFrame.setIconImage(icon.getImage());
        jFrame.getContentPane().setBackground(new Color(0,0,0));
    }
}
