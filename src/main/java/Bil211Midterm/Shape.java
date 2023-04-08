package Bil211Midterm;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Shape {

    public boolean insideOf(MouseEvent e);
    public void draw(Graphics g);

    void updateCoordinate(int x, int y);

    void updateSize(int width, int height);
}
