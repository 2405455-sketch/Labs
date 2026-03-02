import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorList extends JFrame implements ActionListener {

    JList<String> list;
    JButton btn;
    JPanel panel;

    public ColorList() {
        setTitle("Color List");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);

        String colors[] = {"white", "orange", "red", "blue"};
        list = new JList<>(colors);

        btn = new JButton("Click");
        btn.addActionListener(this);

        panel.add(list);
        panel.add(btn);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String c = list.getSelectedValue();
        if (c.equals("white")) panel.setBackground(Color.WHITE);
        if (c.equals("orange")) panel.setBackground(Color.ORANGE);
        if (c.equals("red")) panel.setBackground(Color.RED);
        if (c.equals("blue")) panel.setBackground(Color.BLUE);
    }

    public static void main(String[] args) {
        new ColorList();
    }
}