package DrawExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LinePanel extends JPanel {

    private ArrayList<LineData> savedList;   // 저장된 데이터를 그림(결과 경로만, 저장o)
    private LineData            nowData;     // 현재 데이터를 그림(커서 이동 경로, 저장x)
    private LineListener        lineL;
    private boolean             bDrag;      // 현재 드래그 모드인지 아닌지
    private JTextField          txtSize;
    private JButton             btnColor;
    private JCheckBox           chkfill;    // 속이 채워진 사각형 그리기 모드

    public LinePanel() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.white);

        lineL = new LineListener();

        addMouseListener(lineL);
        addMouseMotionListener(lineL);


        nowData = new LineData();
        savedList = new ArrayList<LineData>();

        bDrag = false;

        txtSize = new JTextField(10);
        txtSize.setText("1");
        add(txtSize);

        btnColor = new JButton("Color Chooser");
        btnColor.addActionListener(new ButtonListener());
        add(btnColor);

        chkfill = new JCheckBox("FILL");
        chkfill.setBackground(Color.white);
        add(chkfill);

    } // Constructor

    public void paintComponent (Graphics page) {
        // 권한을 정상적으로 얻어오기 위한 코드
        // 아래 코드가 없다면 선분을 그릴때 잔상이 남음
        super.paintComponent(page);
        Graphics2D page2 = (Graphics2D)page; // (casting) page2가 page를 reference하도록 함, width를 핸들링하는 함수를 Graphics2D가 가짐

        // now mode
        if (bDrag) {
            page2.setStroke(new BasicStroke(nowData.width));    //width값 설정 가능
            page.setColor(nowData.selectedColor);
            // page.drawLine(nowData.ptOne.x, nowData.ptOne.y, nowData.ptTwo.x, nowData.ptTwo.y);
            draw4Rect(page, nowData.ptOne, nowData.ptTwo);
        } // if

        // save mode
        for (LineData data: savedList) {
            page2.setStroke(new BasicStroke(data.width));
            page.setColor(data.selectedColor);
            // page.drawLine(data.ptOne.x, data.ptOne.y, data.ptTwo.x, data.ptTwo.y);
            draw4Rect(page, data.ptOne, data.ptTwo);
        } // for

    } // paintComponent()

    private void draw4Rect(Graphics page, Point pt1, Point pt2) {

        int x, y, width, height;
        x = y = width = height = 0;

        if (pt1.x < pt2.x && pt1.y < pt2.y) {
            x = pt1.x;
            y = pt1.y;
            width = pt2.x - pt1.x;  // 음수x
            height = pt2.y - pt1.y; // 음수x

        } else if (pt1.x < pt2.x && pt1.y > pt2.y) {
            x = pt1.x;
            y = pt2.y;
            width = pt2.x - pt1.x;
            height = pt1.y - pt2.y;

        } else if (pt1.x > pt2.x && pt1.y > pt2.y) {
            x = pt2.x;
            y = pt2.y;
            width = pt1.x - pt2.x;
            height = pt1.y - pt2.y;

        } else if (pt1.x > pt2.x && pt1.y < pt2.y){
            x = pt2.x;
            y = pt1.y;
            width = pt1.x - pt2.x;
            height = pt2.y - pt1.y;

        } // if..else if

        page.drawRect(x, y, width, height);

    } // draw4Rect()




    private class LineListener implements MouseListener, MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {

            nowData.ptOne = e.getPoint();
            nowData.width = Integer.parseInt(txtSize.getText());
            bDrag = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            nowData.ptTwo = e.getPoint();
            savedList.add(new LineData(nowData));
            bDrag = false;
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            nowData.ptTwo = e.getPoint();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseMoved(MouseEvent e) {}
    } // LineListener class

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            nowData.selectedColor = JColorChooser.showDialog(btnColor, "Color Chooser", nowData.selectedColor);
        }
    } // ButtonListener class

}// LinePanel class
