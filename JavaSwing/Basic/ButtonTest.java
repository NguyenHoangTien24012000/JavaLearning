package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest extends JFrame implements ActionListener {
    JButton button;
    ButtonTest(){
        button = new JButton();
        button.setText("Click");
        button.addActionListener(this);
        button.setFocusable(true);
        button.setBounds(100, 100, 100, 50);
        button.setForeground(Color.blue);
        button.setBackground(Color.GREEN);
        button.setBorder(BorderFactory.createEtchedBorder());
        //JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 800);
        this.setVisible(true);
        this.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("ok ok ----");
            button.setEnabled(false);
        }
    }
}
