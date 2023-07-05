package JavaSwing.Basic;

import javax.swing.*;

public class ProgressBarTest {
    JFrame jFrame = new JFrame();
    JProgressBar jProgressBar = new JProgressBar();

    public ProgressBarTest() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600,600);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

        jProgressBar.setValue(0);
        jProgressBar.setBounds(0,0, 420, 50 );

        jFrame.add(jProgressBar);
        jProgressBar.setStringPainted(true);

        fill();
    }
    public void fill(){
        int value = 0;
        while (value <= 100){
            jProgressBar.setValue(value);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            value+=1;
        }
        jProgressBar.setString("Done!!!");
    }
}
