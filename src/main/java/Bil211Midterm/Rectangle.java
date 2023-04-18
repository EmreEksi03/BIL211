package Bil211Midterm;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Rectangle implements MyShape {
    public int x;
    public int y;
    public int width;
    public int height;
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

    public Rectangle(int x, int y, int width, int height, Color currentColor) {
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

        return isInsideOf(mouseX, mouseY);
    }

    boolean isInsideOf(int mouseX, int mouseY) {
        return (mouseX >= Math.min(x,(x + width)) && mouseX <= Math.max(x,(x + width))) && (mouseY >= Math.min(y,(y + height)) && mouseY <= Math.max(y,(y + height)));
    }

    @Override
    public void draw(Graphics g) {
        Color current = g.getColor();
        g.setColor(currentColor);
        g.fillRect(x,y,width,height);
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
    /*
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0, 0, 50, 50);
        boolean insideOf = rectangle.isInsideOf(10, 10);
        System.out.println(insideOf);
        insideOf = rectangle.isInsideOf(20, 20);
        System.out.println(insideOf);
        insideOf = rectangle.isInsideOf(30, 30);
        System.out.println(insideOf);
        insideOf = rectangle.isInsideOf(30, 40);
        System.out.println(insideOf);
        insideOf = rectangle.isInsideOf(60, 60);
        System.out.println(insideOf);
    }
    */
}
