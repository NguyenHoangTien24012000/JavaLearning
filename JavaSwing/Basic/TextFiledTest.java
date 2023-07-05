package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFiledTest extends JFrame implements ActionListener {
    JButton jButton;
    JTextField jTextField;
    public TextFiledTest() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);

        jButton = new JButton("Click");
        jButton.addActionListener(this);

        jTextField = new JTextField("Text");
        jTextField.setPreferredSize(new Dimension(250, 40 ));

        this.add(jButton);
        this.add(jTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton){
            System.out.println("Text field value: " + jTextField.getText());
        }
    }
}
