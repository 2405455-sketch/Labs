package Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    static JTextField display;
    static String data;
    static String val = "";
    static String op = "";
    static String disVal = "";
    static int num1 = 0;

    static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            data = e.getActionCommand();

            try {
                Integer.parseInt(data);
                val += data;
                disVal += data;
            } catch (NumberFormatException ex) {
                if (data.equals("=")) {
                    int num2 = Integer.parseInt(val);
                    int result = 0;
                    switch (op) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/": result = num1 / num2; break;
                        case "%": result = num1 % num2; break;
                    }
                    disVal = String.valueOf(result);
                    val = disVal;
                }
                else {
                    num1 = Integer.parseInt(val);
                    op = data;
                    disVal += data;
                    val = "";
                }
            }
            display.setText(disVal);
        }
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400,300);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.cyan);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        JLabel calcLabel = new JLabel("CALCULATOR");
        calcLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(calcLabel, gbc);

        display = new JTextField();
        display.setSize(1,2);
        gbc.gridx = 2;
        gbc.gridwidth = 2;
        frame.add(display, gbc);
        gbc.gridwidth = 1;

        String[] ch = { "1","2","3","+",
                "4","5","6","-",
                "7","8","9","*",
                "/","0","%","=" };

        for (int i = 0; i < ch.length; i++) {
            JButton calBtn = new JButton(ch[i]);
            calBtn.addActionListener(listener);
            gbc.gridx = i % 4;
            gbc.gridy = (i / 4) + 2;
            frame.add(calBtn, gbc);
        }

        JButton offBtn = new JButton("OFF");
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        frame.add(offBtn, gbc);

        offBtn.addActionListener(e->{
            System.exit(0);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}