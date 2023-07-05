package JavaSwing.Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerTest extends JFrame implements KeyListener {

    JLabel jLabel;
    public KeyListenerTest(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.addKeyListener(this);

        jLabel = new JLabel();
        jLabel.setBounds(0,0, 100, 100);
        jLabel.setBackground(Color.red);
        jLabel.setOpaque(true);

        this.add(jLabel);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'a' -> jLabel.setLocation(jLabel.getX()-1, jLabel.getY());
            case 'w' -> jLabel.setLocation(jLabel.getX(), jLabel.getY() + 1);
            case 's' -> jLabel.setLocation(jLabel.getX(), jLabel.getY() -1);
            case 'd' -> jLabel.setLocation(jLabel.getX() + 1, jLabel.getY() + 1);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You released key char: " + e.getKeyChar() + " " + e.getKeyCode());
    }
}
