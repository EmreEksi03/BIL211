package Bil211Midterm;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Oval implements Shape{
    int x;
    int y;
    int width;
    int height;
    private Color currentColor;

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

    public Oval(int x, int y, int width, int height, Color currentColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.currentColor = currentColor;
    }
    @Override
    public boolean insideOf(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        return ((mouseX>=x && mouseX<=(x+width)) && (mouseY>=y && mouseY<=y+height));
    }

    @Override
    public void draw(Graphics g) {
        Color current = g.getColor();
        g.setColor(currentColor);
        g.fillOval(x,y,width,height);
        g.setColor(current);
    }

    @Override
    public void updateCoordinate(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void updateSize(int width, int height) {
        setWidth(width);
        setHeight(height);

    }
}
