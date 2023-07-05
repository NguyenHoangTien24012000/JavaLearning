package JavaSwing.TextEditorProject;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements ActionListener {
    JTextArea jTextArea;
    JScrollPane jScrollPane;
    JSpinner jSpinner;
    public TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Editor Text");
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);

        jTextArea = new JTextArea();
        jTextArea.setPreferredSize(new Dimension(450, 450));
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));

        jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setPreferredSize(new Dimension(450, 450));
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jSpinner = new JSpinner();
        jSpinner.setPreferredSize(new Dimension(50,25));
        jSpinner.setValue(20);
        jSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jTextArea.setFont(new Font(jTextArea.getFont().getFamily(), Font.ITALIC,(int) jSpinner.getValue()));
            }
        });

        this.add(jSpinner);
        this.add(jScrollPane);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
