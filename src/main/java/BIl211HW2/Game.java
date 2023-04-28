package BIl211HW2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Game extends JFrame implements KeyListener, MouseListener {
    int numberOfEnemies = 0;
    ArrayList<Bullet> enemyBullets = new ArrayList<>();
    ArrayList<Bullet> friendlyBullets = new ArrayList<>();
    ArrayList<Bullet> airCraftBullets = new ArrayList<>();
    private AirCraft airCraft = null;
    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
        airCraft.bullets = airCraftBullets;
        add(airCraft.jPanel);
    }
    private boolean gameNotFinished;
    public void gameLost(){
        JLabel label = new JLabel();
        label.setText("Game Over!");
        label.setBounds(0,0,80,100);
        JFrame frame = new JFrame();
        frame.setBounds(100,100,100,100);
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(this.getDefaultCloseOperation());
    }
    public void gameWon(){
        JLabel label = new JLabel();
        label.setText("You Won!");
        label.setBounds(0,0,80,100);
        JFrame frame = new JFrame();
        frame.setBounds(100,100,100,100);
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(this.getDefaultCloseOperation());
        add(frame);
    }
    public Game() throws HeadlessException {
        super();
        setSize(500, 500);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(this);
        addMouseListener(this);
        setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        airCraft.moveAircraft(e.getKeyCode());
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        airCraft.shoot();
        for (int i = 0; i < airCraft.bullets.size(); i++) {
            add(airCraft.bullets.get(i).panel);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    public class Enemy extends Thread {
        Game g;
        public ArrayList<Bullet> bullets;
        public JPanel getjPanel() {
            return jPanel;
        }
        public int getX() {
            return x;
        }
        private final JPanel jPanel;
        private int x;
        private int y;
        public Enemy(Game g) {
            numberOfEnemies++;
            this.g = g;
            bullets = g.enemyBullets;
            x = (int) (Math.random()*49)*10;
            y = (int) (Math.random()*49)*10;
            jPanel = new JPanel();
            jPanel.setBounds(x,y,10,10);
            jPanel.setBackground(Color.BLACK);
            g.getContentPane().add(jPanel);
            gameNotFinished = true;
        }


        public void move(){
            int rand = getRand();
            if (rand==0){
                x-=10;
                x = Math.abs(x);
                jPanel.setLocation(x,y);
            }
            else if (rand==1){
                if (x<=490) {
                    x += 10;
                }
                jPanel.setLocation(x,y);
            }
            else if (rand==2){
                y-=10;
                y = Math.abs(y);
                jPanel.setLocation(x,y);
            }
            else if (rand==3){
                if (y<=490) {
                    y += 10;
                }
                jPanel.setLocation(x,y);
            }
        }
        public void shoot(){
            Bullet bullet1 = new Bullet(x, y, 1);
            g.add(bullet1.panel);
            Bullet bullet2 = new Bullet(x, y, 2);
            g.add(bullet2.panel);
            bullets.add(bullet1);
            bullets.add(bullet2);
        }
        public boolean isInsideOf(Bullet bullet){
            return isInside(bullet, x, y);
        }

        public static boolean isInside(Bullet bullet, int x, int y) {
            return  (bullet.x<= x +10 && bullet.x>= x && bullet.y<= y +10 && bullet.y>= y) || (bullet.x+5<= x +10 && bullet.x+5>= x && bullet.y+5<= y +10 && bullet.y+5>= y);
        }

        public void gotShot(){
            checkIfShot(friendlyBullets);
            checkIfShot(airCraftBullets);
        }

        private void checkIfShot(ArrayList<Bullet> airCraftBullets) {
            for (int i = 0; i < airCraftBullets.size(); i++) {
                if (isInsideOf(airCraftBullets.get(i))){
                    g.remove(this.jPanel);
                    g.remove(bullets.get(i).panel);
                    x = 1000;
                    y = 1000;
                    numberOfEnemies--;
                }
            }
        }

        int times = 0;
        @Override
        public void run() {
            while (gameNotFinished){
                if (times == 9) {
                    move();
                    shoot();
                    times = 0;
                }
                for (Bullet bullet : bullets) {
                    bullet.move();
                }
                gotShot();
                g.airCraft.gotShot();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                times ++;
            }
        }
    }

    private static int getRand() {
        int rand;
        rand = (int) (Math.random()* 4);
        return rand;
    }

    public class Friend extends Enemy {
        public Friend(Game g) {
            super(g);
            getjPanel().setBackground(Color.GREEN);
            bullets = g.friendlyBullets;
            numberOfEnemies--;
        }
        @Override
        public void gotShot(){
            for (int i = 0; i < enemyBullets.size(); i++) {
                if (isInsideOf(enemyBullets.get(i))){
                    g.remove(this.getjPanel());
                    g.remove(bullets.get(i).panel);
                }
            }
        }
    }

    public class AirCraft extends Thread{
        private ArrayList<Bullet> bullets;
        public boolean gameNotFinished;
        int x = 250,y = 250;
        public JPanel jPanel;
        public AirCraft() {
            jPanel = new JPanel();
            jPanel.setBounds(x,y,10,10);
            jPanel.setBackground(Color.RED);
            gameNotFinished = true;
        }

        public void moveAircraft(int key){
            switch (key) {
                case (65) -> {
                    if (x != 0 && gameNotFinished) {
                        x -= 3;
                        jPanel.setLocation(x, y);
                    }
                }
                case (87) -> {
                    if (y != 0 && gameNotFinished) {
                        y -= 3;
                        jPanel.setLocation(x, y);
                    }
                }
                case (68) -> {
                    if (x != 490 && gameNotFinished) {
                        x += 3;
                        jPanel.setLocation(x, y);
                    }
                }
                case (83) -> {
                    if (y != 490 && gameNotFinished) {
                        y += 3;
                        jPanel.setLocation(x, y);
                    }
                }
            }
        }
        public boolean isInsideOf(Bullet bullet){
            return Enemy.isInside(bullet, x, y);
        }
        public void gotShot(){
            for (Bullet enemyBullet : enemyBullets) {
                if (isInsideOf(enemyBullet)) {
                    gameNotFinished = false;
                    gameLost();
                }
            }
        }
        public void shoot(){
            Bullet bullet1 = new Bullet(x, y, 1);
            Bullet bullet2 = new Bullet(x, y, 2);
            bullets.add(bullet1);
            bullets.add(bullet2);
        }
        @Override
        public void run() {
            while (gameNotFinished) {
                for (Bullet bullet : bullets) {
                    bullet.move();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (numberOfEnemies == 0){
                    gameWon();
                }
            }
        }
    }
    public static class Bullet{
        int index;
        int x;
        int y;
        JPanel panel = new JPanel();
        public Bullet(int x,int y,int index) {
            this.index = index;
            this.x = x;
            this.y = y;
            panel.setBounds(x,y,5,5);
            panel.setBackground(Color.ORANGE);
        }
        public void move(){
            if (index % 2 == 0) {
                x += 10;
                panel.setLocation(x, y);
            }
            else {
                x-=10;
                panel.setLocation(x,y);
            }
        }
    }
}
