package DrawExam;
import java.awt.Color;
import java.awt.Point;

public class DrawData {

    public Point ptDot;
    public Color color;
    public int   dotSize;

    public DrawData() {
        ptDot = new Point();
        dotSize = 10;
        color = Color.black;
    } // Constructor1
    public DrawData(Point pt, Color c, int size) {
        ptDot = pt;
        color = c;
        dotSize = size;
    } // Constructor2

} // DrawData class
