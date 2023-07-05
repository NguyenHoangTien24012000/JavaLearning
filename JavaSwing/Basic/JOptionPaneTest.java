package JavaSwing.Basic;

import javax.swing.*;

public class JOptionPaneTest {
    public static void main(String[] args) {
//        JOptionPane jOptionPane = new JOptionPane();
//        JOptionPane.showMessageDialog(null, "This is some useless info", "Title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is some more info", "Title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Really?", "Title", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "You're computer has a Virus!!!", "Title", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "You're computer error!!!", "Title", JOptionPane.ERROR_MESSAGE);

//        JOptionPane.showConfirmDialog(null, "Bro, do you even code?", "Title", JOptionPane.YES_NO_CANCEL_OPTION);
//        String name = JOptionPane.showInputDialog("What is your name?");
//        System.out.println(name);
        String[] responses = new String[]{"No bro", "yes bro", "thanks"};
        JOptionPane.showOptionDialog(null, "Hello world", "Titel", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
    }
}
