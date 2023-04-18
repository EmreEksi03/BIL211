package BIl211HW2;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    public static void main(String[] args) {
        Board board = new Board();
    }
    public Board(){
        setLayout(new BorderLayout());
        setSize(700,500);
        setVisible(true);
    }
}
