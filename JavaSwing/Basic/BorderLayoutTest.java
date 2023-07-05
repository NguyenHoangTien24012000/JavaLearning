package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout(10,10));
        jFrame.setSize(700,700);
        jFrame.setVisible(true);

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        JPanel jPanel5 = new JPanel();

        jPanel1.setBackground(Color.blue);
        jPanel2.setBackground(Color.GREEN);
        jPanel3.setBackground(Color.ORANGE);
        jPanel4.setBackground(Color.GRAY);
        jPanel5.setBackground(Color.BLACK);

        jPanel1.setPreferredSize(new Dimension(100, 100));
        jPanel2.setPreferredSize(new Dimension(100, 100));
        jPanel3.setPreferredSize(new Dimension(100, 100));
        jPanel4.setPreferredSize(new Dimension(100, 100));
        jPanel5.setPreferredSize(new Dimension(100, 100));

        jFrame.add(jPanel1, BorderLayout.NORTH);
        jFrame.add(jPanel2, BorderLayout.WEST);
        jFrame.add(jPanel3, BorderLayout.EAST);
        jFrame.add(jPanel4, BorderLayout.SOUTH);
        jFrame.add(jPanel5, BorderLayout.CENTER);



    }
}
