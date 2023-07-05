package JavaSwing.NewWindowTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
    JButton jButton = new JButton("Click");
    JFrame jFrame = new JFrame("Current");
    LaunchPage(){
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(600,600);
        jFrame.setVisible(true);

        jButton.setBounds(100, 160, 200, 40);
        jButton.setFocusable(false);
        jButton.addActionListener(this);

        jFrame.add(jButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton){
            NewWindow window = new NewWindow();
            jFrame.dispose();
        }
    }
}
