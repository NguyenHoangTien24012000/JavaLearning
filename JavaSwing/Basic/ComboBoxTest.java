package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxTest extends JFrame implements ActionListener {
    JComboBox jComboBox;
    public ComboBoxTest(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        String[] arr = {"Tien", "Thuong", "Son"};
        jComboBox = new JComboBox<>(arr);
        jComboBox.addActionListener(this);

        this.add(jComboBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jComboBox){
            System.out.println(jComboBox.getSelectedItem());
        }
    }
}
