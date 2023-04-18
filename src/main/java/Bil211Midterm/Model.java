package Bil211Midterm;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<MyShape> myShapes = new ArrayList<>();
    private Color currentColor;

    public void addRectangle(Rectangle rectangle) {
        myShapes.add(rectangle);
    }
    public void addOval(Oval oval) {
        myShapes.add(oval);
    }
    public void addLine(Line line) {
        myShapes.add(line);
    }

    public void draw(Graphics g,int length){
        g.drawLine(0,140,length,140);
        for (int i = 0; i < myShapes.size(); i++) {
            myShapes.get(i).draw(g);
        }
    }
    public int insideOfModel(MouseEvent e){
        for (int i = 0; i < myShapes.size(); i++) {
             if (myShapes.get(i).insideOf(e)){
                 return i;
             }
        }
        return -1;
    }

    public void updateLast(int width, int height) {
        MyShape myShape = myShapes.get(myShapes.size() - 1);
        myShape.updateSize(width,height);
    }

    public void update(int index, int x, int y) {
        MyShape myShape = myShapes.get(index);
        myShape.updateCoordinate(x,y);
    }

    public void setCurrentColour(Color currentColor) {
        this.currentColor = currentColor;
    }

    public Color getCurrentColor() {
        return currentColor;
    }
}
