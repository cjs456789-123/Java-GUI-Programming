package EventExam;

import javax.swing.JFrame;
public class EventExam {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PrimaryPanel primary = new PrimaryPanel();
        frame.getContentPane().add(primary);

        frame.pack();
        frame.setVisible(true);
    }

}
