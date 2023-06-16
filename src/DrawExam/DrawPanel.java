package DrawExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private ArrayList<DrawData> _ptList; // Point를 여러 개 저장할 수 있는 ArrayList
    // private Point _ptDot; // 점
    private int        _dotSize;    // 점의 크기
    private Color      _selectedColor;
    private JTextField _txtDotSize;
    private JButton    _btnColor;


    public DrawPanel() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.white);
        // 객체를 통해서 반드시 listener를 add 해야함
        addMouseListener(new DrawListener()); // 무명객체로 add함

        _txtDotSize = new JTextField(10);
        _txtDotSize.setText("10");
        add(_txtDotSize);

        _btnColor = new JButton("Color Chooser");
        _btnColor.addActionListener(new ButtonListener());
        add(_btnColor);

        _selectedColor = Color.black;   // new Color(0,0,0) 과 같음

        _dotSize = 10;
        // _ptDot = new Point();
        _ptList = new ArrayList<DrawData>();
    }// DrawPanel(); Constructor

    public void setDotSize(int size) { _dotSize = size; }
    public int getDotSize() { return _dotSize; } //JPanel에 int가 이미 있으므로 충돌이 나서 오류 발생(_size -> dotSize, 이름이 예약어와 겹치지 않도록 수정)

    public void paintComponent(Graphics page) {
        super.paintComponent(page);

        //page.fillOval(_ptDot.x-_dotSize/2, _ptDot.y-_dotSize/2, _dotSize, _dotSize); // _dotSize/2를 뺀 이유: 커서의 끝부분이 중앙으로 오도록 계산
        /*
        for (int i=0; i<_ptList.size(); i++) {
            Point pt = _ptList.get(i);
            page.fillOval(pt.x-_dotSize/2, pt.y-_dotSize/2, _dotSize, _dotSize);
        }*/

        // for문 간략히 사용 가능
        for (DrawData data: _ptList) {
            // page.fillOval(pt.x-_dotSize/2, pt.y-_dotSize/2, _dotSize, _dotSize);
            page.setColor(data.color);
            page.fillOval(data.ptDot.x-data.dotSize/2, data.ptDot.y-data.dotSize/2, data.dotSize, data.dotSize);
        }
    }// paintComponent()

    // 1. Listener class
    private class DrawListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //_ptDot = e.getPoint();  // 이벤트가 발생한 좌표를 _ptDot으로 할당
            // _ptDot.x = e.getX();    // 이벤트가 발생한 x좌표를 _ptDot.x으로 할당
            // _ptDot.y = e.getY();    // 이벤트가 발생한 y좌표를 _ptDot.y으로 할당
            //_ptList.add(e.getPoint()); // _ptList에 클릭할 때마다 좌표 값이 추가됨
            _ptList.add(new DrawData(e.getPoint(), _selectedColor, Integer.parseInt(_txtDotSize.getText())));
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    } // DrawListener class

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            if (obj == _btnColor) {
                // 선택한 색상 저장
                _selectedColor = JColorChooser.showDialog(_btnColor, "Color Chooser", _selectedColor);

            }// if

        } // actionPerformed()
    } // ButtonListener class


}// DrawPanel class
