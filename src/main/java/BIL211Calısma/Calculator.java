package BIL211Calısma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];

    JButton addButton,extractButton,divideButton,multiplyButton,equalsButton, negButton;

    JButton decButton ,delButton,clrButton;
    JPanel panel;

    Font myFont = new Font("Elephant",Font.ITALIC,28);

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,520);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        extractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clrButton = new JButton("clr");
        delButton = new JButton("del");
        decButton = new JButton(".");
        negButton = new JButton("(-)");


        funcButtons[0] = addButton;
        funcButtons[1] = extractButton;
        funcButtons[2] = multiplyButton;
        funcButtons[3] = divideButton;
        funcButtons[4] = equalsButton;
        funcButtons[5] = clrButton;
        funcButtons[6] = delButton;
        funcButtons[7] = decButton;
        funcButtons[8] = negButton;

        for (int i = 0; i < funcButtons.length; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(extractButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(multiplyButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == extractButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String str = textField.getText();
            str = str.substring(0,str.length()-1);
            textField.setText(str);
        }
        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
