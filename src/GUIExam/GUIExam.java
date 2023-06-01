package GUIExam;

import javax.swing.*;
import java.awt.*;
public class GUIExam extends JPanel{
    private JLabel Lbl;

    public GUIExam() {
        setBackground(Color.pink);
        setPreferredSize(new Dimension(400, 300));

        Lbl = new JLabel("GUI Example!!");
        Lbl.setFont(new Font("Verdana", Font.BOLD, 16));
        Lbl.setForeground(Color.yellow);
        add(Lbl);
    }

    @Override
    public void paintComponent(Graphics page) {
        // TODO Auto-generated method stub
        super.paintComponent(page);

        page.setColor(Color.red);
        page.drawRect(100, 100, 200, 100);
    }


} // GUIExam class
