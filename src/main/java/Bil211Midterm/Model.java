package Bil211Midterm;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Shape> shapes = new ArrayList<>();
    private Color currentColor;

    public void addRectangle(Rectangle rectangle) {
        shapes.add(rectangle);
    }
    public void addOval(Oval oval) {
        shapes.add(oval);
    }
    public void addLine(Line line) {
        shapes.add(line);
    }

    public void draw(Graphics g){
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(g);
        }
    }
    public int insideOfModel(MouseEvent e){
        for (int i = 0; i < shapes.size(); i++) {
             if (shapes.get(i).insideOf(e)){
                 return i;
             }
        }
        return -1;
    }

    public void updateLast(int width, int height) {
        Shape shape = shapes.get(shapes.size() - 1);
        shape.updateSize(width,height);
    }

    public void update(int index, int x, int y) {
        Shape shape = shapes.get(index);
        shape.updateCoordinate(x,y);
    }

    public void setCurrentColour(Color currentColor) {
        this.currentColor = currentColor;
    }

    public Color getCurrentColor() {
        return currentColor;
    }
}
