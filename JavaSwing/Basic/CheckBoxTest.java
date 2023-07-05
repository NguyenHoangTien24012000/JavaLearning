package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxTest extends JFrame implements ActionListener {
    JCheckBox jCheckBox;
    JButton jButton;

    public CheckBoxTest() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(600, 600);
        this.setVisible(true);

        jCheckBox = new JCheckBox();
        jCheckBox.setText("Ban la nguoi yeu thuong");
        jCheckBox.setFocusable(false);
        jCheckBox.setSize(new Dimension(300,50));

        jButton = new JButton("Submit");
        jButton.addActionListener(this);

        this.add(jCheckBox);
        this.add(jButton);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton){
            System.out.println(jCheckBox);
        }
    }
}
