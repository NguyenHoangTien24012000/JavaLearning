package JavaSwing.Basic;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LabelTest {
    public static void main(String[] args) {
        JLabel jLabel = new JLabel();
        jLabel.setText("Test Text!");
        ImageIcon icon = new ImageIcon("src/JavaSwing/Basic/img.png");
        jLabel.setIcon(icon);
        jLabel.setHorizontalAlignment(JLabel.LEFT);//set content LEFT, RIGHT, CENTER of label
        jLabel.setVerticalAlignment(JLabel.TOP);
        jLabel.setVerticalTextPosition(JLabel.BOTTOM);
        jLabel.setIconTextGap(-50);
        jLabel.setBackground(Color.red);
        jLabel.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.green, 3);
        jLabel.setBorder(border);
        jLabel.setBounds(0,0, 200, 200);

        //
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
//        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jLabel);
        jFrame.pack();
    }
}
