package EventExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    // 이벤트를 다루는 패키지

import static javax.swing.text.StyleConstants.setBackground;

public class PrimaryPanel extends JPanel{
    private int nCount;
    private JLabel LblCount;    // JPanel에서 상속받은 클래스
    private JButton btnIncrement, btnDecrement;   // JPanel에서 상속받은 클래스

    // 2. declaration of listener object
    private ButtonListener buttonL;

    public PrimaryPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(400, 300));
        setLayout(null);

        // 2. creating of listener object
        buttonL = new ButtonListener();


        nCount = 0;

        LblCount = new JLabel("COUNT: " + nCount);
        LblCount.setBounds(50, 20, 200, 50);
        LblCount.setFont(new Font("Verdana", Font.BOLD, 20));
        LblCount.setForeground(Color.gray);
        add(LblCount);

        btnIncrement = new JButton("INCREMENT");
        btnIncrement.setBounds(50, 80, 150, 40);
        btnIncrement.setForeground(Color.blue);
        btnIncrement.setBackground(Color.lightGray);
        btnIncrement.setFont(new Font("Verdana", Font.PLAIN, 14));

        // 3. add the listener object to the component
        btnIncrement.addActionListener(buttonL);

        add(btnIncrement);


        btnDecrement = new JButton("DECREMENT");
        btnDecrement.setBounds(225, 80, 150, 40);
        btnDecrement.setForeground(Color.blue);
        btnDecrement.setBackground(Color.lightGray);
        btnDecrement.setFont(new Font("Verdana", Font.PLAIN, 14));

        // 3. add the listener object to the component
        btnDecrement.addActionListener(buttonL);

        add(btnDecrement);

    } // Constructor

    // Inner Class로 구현하기
    // 1. Listener class
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) {

            Object obj = event.getSource();

            if (obj == btnIncrement) nCount++;
            else if (obj == btnDecrement) nCount--;
            LblCount.setText("COUNT: " + nCount);

            if (nCount == 0) LblCount.setForeground(Color.black);
            else if (nCount > 0) LblCount.setForeground(Color.blue);
            else LblCount.setForeground(Color.red);

        } // actionPerformed()


    } // ButtonListener class




} // PrimaryPanel class
