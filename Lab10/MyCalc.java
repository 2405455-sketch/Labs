import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCalc extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton add, sub, mul, reset;

    public MyCalc() {
        setTitle("My Calc");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.DARK_GRAY);

        JLabel l1 = new JLabel("Enter First Number:");
        JLabel l2 = new JLabel("Enter Second Number:");
        JLabel l3 = new JLabel("Result:");

        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);

        l1.setBounds(50, 50, 150, 25);
        l2.setBounds(50, 90, 150, 25);
        l3.setBounds(50, 130, 150, 25);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        t1.setBounds(220, 50, 100, 25);
        t2.setBounds(220, 90, 100, 25);
        t3.setBounds(220, 130, 100, 25);

        add = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        reset = new JButton("Reset");

        add.setBounds(350, 40, 100, 25);
        sub.setBounds(350, 70, 100, 25);
        mul.setBounds(350, 100, 100, 25);
        reset.setBounds(350, 130, 100, 25);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        reset.addActionListener(this);

        panel.add(l1); panel.add(l2); panel.add(l3);
        panel.add(t1); panel.add(t2); panel.add(t3);
        panel.add(add); panel.add(sub); panel.add(mul); panel.add(reset);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            t1.setText(""); t2.setText(""); t3.setText("");
            return;
        }

        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());

        if (e.getSource() == add)
            t3.setText(String.valueOf(a + b));
        else if (e.getSource() == sub)
            t3.setText(String.valueOf(a - b));
        else if (e.getSource() == mul)
            t3.setText(String.valueOf(a * b));
    }

    public static void main(String[] args) {
        new MyCalc();
    }
}