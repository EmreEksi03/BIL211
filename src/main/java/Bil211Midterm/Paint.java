package Bil211Midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paint extends JFrame implements MouseMotionListener, ActionListener, MouseListener {
    public static void main(String[] args) {
        Paint paint = new Paint();
    }


    private boolean drawingRectangle, drawingOval,drawingLine,moving,inside;

    Color color = Color.RED;
    int prevX,prevY,endX,endY,index;
    JPanel blue = new JPanel();
    JPanel red = new JPanel();
    JPanel green = new JPanel();
    JPanel yellow = new JPanel();
    JPanel orange = new JPanel();
    JPanel purple = new JPanel();
    JPanel black = new JPanel();
    JButton moveButton = new JButton(),rectangleButton = new JButton(),ovalButton = new JButton(),lineButton = new JButton();
    private final Model model;

    public Paint() {
        moveButton.setBounds(0,0,100,50);
        moveButton.setText("Move");
        moveButton.addActionListener(this);
        rectangleButton.setBounds(0,100,100,50);
        rectangleButton.setText("Rect");
        rectangleButton.addActionListener(this);
        ovalButton.setBounds(0,200,100,50);
        ovalButton.setText("Oval");
        ovalButton.addActionListener(this);
        lineButton.setBounds(0,300,100,50);
        lineButton.setText("Line");
        lineButton.addActionListener(this);
        add(moveButton);
        add(rectangleButton);
        add(ovalButton);
        add(lineButton);

        createColor(blue, Color.BLUE, 200);
        createColor(red, Color.RED, 200 + 40);
        createColor(green, Color.GREEN, 200 + 80);
        createColor(yellow, Color.YELLOW, 200 + 120);
        createColor(orange, Color.ORANGE, 200 + 160);
        createColor(purple, Color.MAGENTA, 200 + 200);
        createColor(black, Color.BLACK, 200 + 240);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        addMouseMotionListener(this);
        setLayout(new BorderLayout());
        setSize(700,500);

        setVisible(true);
        model = new Model();
    }

    private void createColor(JPanel colorPanel, final Color color, int xCoord) {
        colorPanel.setBounds(xCoord,20,20,10);
        colorPanel.setBackground(color);
        colorPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model.setCurrentColour(color);
            }
        });
        add(colorPanel);
        colorPanel.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (moving && inside) {
            model.update(index,e.getX(),e.getY());

            repaint();
            model.draw(getGraphics());
        }
        else if (drawingRectangle){
            int width = -(prevX - endX);
            int height = -(prevY - endY);
            endX = e.getX();
            endY = e.getY();
            model.updateLast(width,height);
            repaint();
            model.draw(getGraphics());
            return;
        }
        else if (drawingOval){
            int width = -(prevX - endX);
            int height = -(prevY - endY);
            endX = e.getX();
            endY = e.getY();
            model.updateLast(width,height);
            repaint();
            model.draw(getGraphics());
            return;
        }
        else if (drawingLine) {
            model.addLine(new Line(e.getX(),e.getY(),5,5,model.getCurrentColor()));
            model.draw(getGraphics());
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
        index = model.insideOfModel(e);
        inside = (index!=-1);

        prevX = e.getX();
        prevY = e.getY();
        if (drawingRectangle) {
            model.addRectangle(new Rectangle(prevX, prevY, 0, 0,model.getCurrentColor()));
        }
        else if (drawingOval) {
            model.addOval(new Oval(prevX, prevY, 0, 0,model.getCurrentColor()));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        inside = false;
        model.draw(getGraphics());
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        model.draw(getGraphics());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        model.draw(getGraphics());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == moveButton) {
            drawingRectangle = false;
            drawingOval = false;
            moving = true;
            drawingLine = false;
        }
        if (e.getSource() == rectangleButton) {
            drawingRectangle = true;
            drawingOval = false;
            moving = false;
            drawingLine = false;
        }
        if (e.getSource() == ovalButton) {
            drawingRectangle = false;
            drawingOval = true;
            moving = false;
            drawingLine = false;
        }
        if (e.getSource() == lineButton) {
            drawingRectangle = false;
            drawingOval = false;
            moving = false;
            drawingLine = true;
        }
    }
}
