package Bil211Midterm;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Line implements MyShape {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Line(int x, int y, int width, int height, Color currentColor) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        color = currentColor;
    }


    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }


    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean insideOf(MouseEvent e) {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        Color current = g.getColor();
        g.setColor(color);
        g.fillOval(getX(), getY(), 5, 5);
        g.setColor(current);
    }

    @Override
    public void updateCoordinate(int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSize(int width, int height) {
        throw new UnsupportedOperationException();

    }
}
