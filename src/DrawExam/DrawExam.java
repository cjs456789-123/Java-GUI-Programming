package DrawExam;
import javax.swing.*;

public class DrawExam {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DrawPanel primary = new DrawPanel();
        LinePanel primary = new LinePanel();
        frame.getContentPane().add(primary);

        frame.pack();
        frame.setVisible(true);
    }

}