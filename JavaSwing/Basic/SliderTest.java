package JavaSwing.Basic;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderTest implements ChangeListener {
    JFrame jFrame;
    JPanel jPanel;
    JLabel jLabel;
    JSlider jSlider;

    public SliderTest() {
        jFrame = new JFrame();
        jPanel = new JPanel();
        jLabel = new JLabel();
        jSlider = new JSlider(0,100,50);
        jSlider.setPreferredSize(new Dimension(400, 200));
        jSlider.setPaintTicks(false);
        jSlider.setMinorTickSpacing(10);
        jSlider.setPaintTrack(true);
        jSlider.setMajorTickSpacing(25);
        jSlider.setPaintLabels(true);
        jLabel.setText("Value = " + jSlider.getValue());
        jSlider.addChangeListener(this);

        jPanel.add(jSlider);
        jPanel.add(jLabel);
        jFrame.add(jPanel);


        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setLayout(null);
        jFrame.setVisible(true);

    }


    @Override
    public void stateChanged(ChangeEvent e) {
        jLabel.setText("Value = " + jSlider.getValue());
    }
}
