package BIl211HW2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame{
    public Game() throws HeadlessException {
        super();
        setSize(500, 520);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(new JLabel("  sdfsdf"));
    }

    public class Enemy extends Thread {
        public void setLabel(JLabel label) {
            this.label = label;
        }
        public void setGameNotFinished(boolean gameNotFinished) {
            this.gameNotFinished = gameNotFinished;
        }

        public JLabel getLabel() {
            return label;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isGameNotFinished() {
            return gameNotFinished;
        }

        private JLabel label;
        private int x;
        private int y;
        private boolean gameNotFinished;
        public Enemy(Game g) {
            x = (int) (Math.random()*49)*10;
            y = (int) (Math.random()*49)*10;
            label = new JLabel(".");
            label.setBounds(x,y,10,10);
            label.setBackground(Color.BLACK);
            g.getContentPane().add(label);
            gameNotFinished = true;
        }


        public void move(){
            int rand = getRand(4);
            if (rand==0){
                x-=10;
                x = Math.abs(x);
                label.setLocation(x,y);
            }
            else if (rand==1){
                x+=10;
                label.setLocation(x,y);
            }
            else if (rand==2){
                y-=10;
                y = Math.abs(y);
                label.setLocation(x,y);
            }
            else if (rand==3){
                y+=10;
                label.setLocation(x,y);
            }
        }
        public void run() {
            while (gameNotFinished){
                move();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static int getRand(int x) {
        int rand = (int) (Math.random()* x);
        return rand;
    }

    public class Friend extends Enemy {

        public Friend(Game g) {
            super(g);
            getLabel().setBackground(Color.GREEN);
        }
    }

    public class AirCraft extends Thread implements KeyListener {
        private boolean gameNotFinished;
        private JLabel label;
        private int x, y;
        private void setLabel(JLabel label) {
            this.label = label;
        }
        public void setGameNotFinished(boolean gameNotFinished) {
            this.gameNotFinished = gameNotFinished;
        }
        public AirCraft(Game g) {
            x = 250;
            y = 250;
            label = new JLabel("Aircraft");
            label.setBounds(x,y,100,100);
            label.setBackground(Color.RED);
            label.addKeyListener(this);
            g.getContentPane().add(label);
            gameNotFinished = true;
        }
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case(37):
                    if (x!=0 && gameNotFinished) {
                        x -= 10;
                        label.setLocation(x, y);
                    }
                    break;
                case(38):
                    if (y!=0 && gameNotFinished) {
                        y -= 10;
                        label.setLocation(x, y);
                    }
                    break;
                case(39):
                    if (x!=490 && gameNotFinished) {
                        x += 10;
                        label.setLocation(x, y);
                    }
                    break;
                case(40):
                    if (y != 490 && gameNotFinished) {
                        y += 10;
                        label.setLocation(x, y);
                    }
                    break;
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {}
        @Override
        public void keyTyped(KeyEvent e) {}
    }
}
