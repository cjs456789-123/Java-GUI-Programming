package DrawExam;
import java.awt.*;

public class LineData {

    public Point ptOne, ptTwo;
    public Color selectedColor;
    public int   width;

    public LineData() {
        ptOne = new Point();
        ptTwo = new Point();
        selectedColor = Color.black;
        width = 1;
    }

    public LineData(Point pt1, Point pt2, Color color, int w) {
        ptOne = pt1;
        ptTwo = pt2;
        selectedColor = color;
        width = w;
    }

    public LineData(LineData data) {
        ptOne = data.ptOne;
        ptTwo = data.ptTwo;
        selectedColor = data.selectedColor;
        width = data.width;
    } // LineData 자체를 받아서 저장


} // LineData class
