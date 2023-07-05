package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBarTest extends JFrame implements ActionListener {
    JMenuBar jMenuBar;
    JMenu jMenu1;
    JMenu jMenu2;
    JMenu jMenu3;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    public MenuBarTest(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        jMenuBar = new JMenuBar();

        jMenu1 = new JMenu("File");
        jMenu2 = new JMenu("Edit");
        jMenu3 = new JMenu("Help");

        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setMnemonic(KeyEvent.VK_L);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        jMenu1.add(loadItem);
        jMenu1.add(saveItem);
        jMenu1.add(exitItem);

        this.setJMenuBar(jMenuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadItem){
            System.out.println("load...");
        } else if (e.getSource() == saveItem) {
            System.out.println("save...");
        }else if(e.getSource() == exitItem){
            System.out.println("exit...");
        }
    }
}
