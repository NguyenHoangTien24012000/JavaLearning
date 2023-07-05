package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;

public class LayerTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(new Dimension(500, 500));
        jFrame.setLayout(null);


        JLayeredPane jLayeredPane = new JLayeredPane();
        jLayeredPane.setBounds(0, 0, 500, 500);
        jFrame.add(jLayeredPane);

        JLabel jLabel1 = new JLabel();
        jLabel1.setBackground(Color.red);
        jLabel1.setBounds(50,50,200,200);
        jLabel1.setOpaque(true);

        JLabel jLabel2 = new JLabel();
        jLabel2.setBackground(Color.GRAY);
        jLabel2.setBounds(100,100,200,200);
        jLabel2.setOpaque(true);

        JLabel jLabel3 = new JLabel();
        jLabel3.setBackground(Color.GREEN);
        jLabel3.setBounds(150,150,200,200);
        jLabel3.setOpaque(true);

        jLayeredPane.add(jLabel1, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(jLabel2, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(jLabel3, JLayeredPane.DRAG_LAYER);
    }
}
