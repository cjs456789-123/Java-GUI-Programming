package UpDownGame;

import java.awt.Color;

import javax.swing.JLabel;

public class MarkLabel extends JLabel implements Runnable{

    Thread myThread;
    int nFinish;

    public MarkLabel() {
        myThread = new Thread(this);
        nFinish = 0;
    }

    public void start() {
        if (myThread != null)
            myThread.start();
    }

    public void stop() { myThread.stop(); }

    public void setFinish(int num) { nFinish = num; }

    @Override
    public void run() {
        for (int i=0; i<=nFinish; i++) {
            setText(""+i);
            try {
                myThread.sleep(100);
            } catch(Exception e) {}
        } // for

        for (int i=0; i<10; i++) {
            int r,g,b;
            r = (int)(Math.random()*256);
            g = (int)(Math.random()*256);
            b = (int)(Math.random()*256);
            setForeground(new Color(r,g,b));

            setVisible(false);
            try {
                myThread.sleep(100);
            } catch(Exception e) {}
            setVisible(true);
            try{
                myThread.sleep(100);
            } catch(Exception e) {}
        }

    }

} // MarkLabel class
