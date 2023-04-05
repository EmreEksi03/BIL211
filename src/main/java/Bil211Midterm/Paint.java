package Bil211Midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paint extends JFrame implements MouseMotionListener, ActionListener, MouseListener {
    public static void main(String[] args) {
        Paint paint = new Paint();
    }

    JFrame myFrame = new JFrame("Paint");
    boolean drawingRectangle = true;
    Color color = Color.RED;
    int prevX,prevY,endX,endY;
    public Paint() {
        myFrame.setSize(700,500);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.addMouseListener(this);
        myFrame.addMouseMotionListener(this);
        myFrame.setLayout(new BorderLayout());

        myFrame.setVisible(true);
    }
    public void paintRectangle(Graphics g){
        int x = Math.min(prevX, endX);
        int y = Math.min(prevY, endY);
        int width = Math.abs(prevX - endX);
        int height = Math.abs(prevY - endY);
        g.fillRect(x, y, width, height);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if (!drawingRectangle) {
            Graphics graphics = myFrame.getGraphics();
            graphics.setColor(color);
            prevX = e.getX();
            prevY = e.getY();
            graphics.drawLine(prevX, prevY, e.getX(), e.getY());
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        prevX = e.getX();
        prevY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        Graphics graphics = myFrame.getGraphics();
        graphics.setColor(color);
        paintRectangle(graphics);
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
