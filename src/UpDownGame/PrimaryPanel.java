package UpDownGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimaryPanel extends JPanel{

    JPanel leftPanel, rightPanel;
    JLabel lblTitle, /*lblMark,*/ lblHint;
    JButton btnRandom, btnInput;
    JTextField txtInput;
    int nRandom, nInput;
    // 2. Declaration of listener object
    GameListener gameL;
    GameMouseListener gameML;

    // ---------------------------------
    JLabel lblRange, lblCount;
    int nMin, nMax, nCount;
    // ---------------------------------

    MarkLabel lblMark;  // 매우 중요!

    public PrimaryPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(630, 420));
        setLayout(null);

        // 2. Creating of listener object
        gameL = new GameListener();
        gameML = new GameMouseListener();


        leftPanel = new JPanel();
        leftPanel.setBounds(10, 10, 300, 400);
        leftPanel.setBackground(Color.white);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.cyan));
        leftPanel.setLayout(null);
        add(leftPanel);

        lblTitle = new JLabel("UP-DOWN-GAME");
        lblTitle.setBounds(10, 10, 280, 60);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 26));
        leftPanel.add(lblTitle);

        //lblMark = new JLabel("?");
        lblMark = new MarkLabel();
        lblMark.setBounds(10, 90, 280, 240);
        lblMark.setHorizontalAlignment(SwingConstants.CENTER);
        lblMark.setFont(new Font("Verdana", Font.BOLD, 120));
        lblMark.setVisible(false); // 일단 숨겨둠
        leftPanel.add(lblMark);

        lblHint = new JLabel("RIGHT!!");
        lblHint.setBounds(10, 330, 280, 60);
        lblHint.setHorizontalAlignment(SwingConstants.CENTER);
        lblHint.setFont(new Font("Verdana", Font.BOLD, 24));
        lblHint.setVisible(false); // 일단 숨겨둠
        leftPanel.add(lblHint);

        rightPanel = new JPanel();
        rightPanel.setBounds(320, 10, 300, 400);
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.pink));
        rightPanel.setLayout(null);
        add(rightPanel);

        nRandom = nInput = 0;
        Font fntButton = new Font("Verdana", Font.PLAIN, 16);

        btnRandom = new JButton("GENERATES..");
        btnRandom.setBounds(20, 40, 260, 40);
        btnRandom.setBackground(new Color(250, 250, 250));
        btnRandom.setFont(fntButton);
        // btnRandom.setFocusable(false); //프레임워크 포커스 변경
        // 3. Add the object to the component
        btnRandom.addActionListener(gameL);
        btnRandom.addMouseListener(gameML);
        rightPanel.add(btnRandom);

        txtInput = new JTextField();
        txtInput.setBounds(20, 90, 125, 40);
        txtInput.setFont(fntButton);
        // 3. Add
        txtInput.addActionListener(gameL);
        txtInput.setEnabled(false);
        rightPanel.add(txtInput);

        btnInput = new JButton("INPUT");
        btnInput.setBounds(155, 90, 125, 40);
        btnInput.setBackground(new Color(250, 250, 250));
        btnInput.setFont(fntButton);
        // 3. Add
        btnInput.addActionListener(gameL);
        btnInput.addMouseListener(gameML);
        btnInput.setEnabled(false);
        rightPanel.add(btnInput);

        // ---------------------------------
        nMin = 1;
        nMax = 100;
        nCount = 0;

        lblRange = new JLabel("(" + nMin + " ~ " + nMax + ")");
        lblRange.setBounds(20, 150, 260, 40);
        lblRange.setFont(fntButton);
        lblRange.setVisible(false);
        rightPanel.add(lblRange);

        lblCount = new JLabel("COUNT: " + nCount);
        lblCount.setBounds(20, 200, 260, 40);
        lblCount.setFont(fntButton);
        lblCount.setVisible(false);
        rightPanel.add(lblCount);
        // ---------------------------------


    } // Constructor

    // 1. Listener class
    private class GameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            // 4. Event handling
            Object obj = event.getSource();

            if (obj == btnRandom) {
                nRandom = (int)(Math.random()*100)+1; // 1~100
                lblMark.setText("?");
                lblMark.setVisible(true);

                btnRandom.setEnabled(false);
                txtInput.setEnabled(true);
                btnInput.setEnabled(true);

                // ---------------------------------
                lblRange.setVisible(true);
                lblCount.setVisible(true);
                // ---------------------------------

            } else if (obj == txtInput || obj == btnInput) {
                nInput = Integer.parseInt(txtInput.getText());
                if (nRandom < nInput) {
                    lblHint.setText("DOWN");
                    nMax = nInput;
                } else if (nRandom > nInput) {
                    lblHint.setText("UP");
                    nMin = nInput;
                } else { // nRandom == nInput
                    lblHint.setText("RIGHT!!");


                    lblMark.setFinish(nRandom);
                    lblMark.start();

                    int result;
                    result = JOptionPane.showConfirmDialog(lblRange, "CONTINUE?");
                    if (result == JOptionPane.YES_OPTION) {
                        // init Game
                    } else if (result == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }

                } // if..else
                lblHint.setVisible(true);
                txtInput.setText("");

                // ---------------------------------
                nCount++;
                lblRange.setText("(" + nMin + " ~ " + nMax + ")");
                lblCount.setText("COUNT : " + nCount);
                // ---------------------------------
            } // if..else if


        } // actionPerformed()


    } // GameListener class

    private class GameMouseListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton btn = (JButton)e.getSource();
            btn.setForeground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton btn = (JButton)e.getSource();
            btn.setForeground(Color.black);
        }

    } // GameMouseListener class

} // PrimaryPanel class
