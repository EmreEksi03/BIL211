package Bil211Midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintBrush extends JPanel implements MouseMotionListener, ActionListener, MouseListener {
    public static void main(String[] args) {
        JFrame f = new JFrame("PaintBrush");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new PaintBrush());
        f.setSize(700, 500);
        f.setVisible(true);
    }


    private boolean drawingRectangle, drawingOval,drawingLine,moving,inside;

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

    public PaintBrush() {
        moveButton.setBounds(140,50,80,40);
        moveButton.setText("Move");
        moveButton.addActionListener(this);
        rectangleButton.setBounds(240,50,80,40);
        rectangleButton.setText("Rect");
        rectangleButton.addActionListener(this);
        ovalButton.setBounds(340,50,80,40);
        ovalButton.setText("Oval");
        ovalButton.addActionListener(this);
        lineButton.setBounds(440,50,80,40);
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
        if (e.getY()<140){
            return;
        }
        if (moving && inside && model.myShapes.get(index).getHeight() + e.getY()>140) {
            model.update(index,e.getX(),e.getY());
        }
        else if (drawingRectangle){
            int width = -(prevX - endX);
            int height = -(prevY - endY);
            endX = e.getX();
            endY = e.getY();
            model.updateLast(width,height);
        }
        else if (drawingOval){
            int width = -(prevX - endX);
            int height = -(prevY - endY);
            endX = e.getX();
            endY = e.getY();
            model.updateLast(width,height);
        }
        else if (drawingLine) {
            model.addLine(new Line(e.getX(),e.getY(),5,5,model.getCurrentColor()));
        }
        repaint();

    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getY()<140){
            return;
        }
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
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.draw(g,getSize().width);
    }
}
