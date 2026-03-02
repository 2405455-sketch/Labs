import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RGBColor extends JFrame implements ActionListener {

    JComboBox<Integer> r, g, b;
    JButton show;
    JPanel panel;

    public RGBColor() {
        setTitle("My Frame");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);

        Integer values[] = new Integer[256];
        for (int i = 0; i < 256; i++) values[i] = i;

        JLabel lr = new JLabel("Red");
        JLabel lg = new JLabel("Green");
        JLabel lb = new JLabel("Blue");

        lr.setForeground(Color.RED);
        lg.setForeground(Color.GREEN);
        lb.setForeground(Color.CYAN);

        r = new JComboBox<>(values);
        g = new JComboBox<>(values);
        b = new JComboBox<>(values);

        show = new JButton("Show Output");
        show.addActionListener(this);

        panel.add(lr); panel.add(r);
        panel.add(lg); panel.add(g);
        panel.add(lb); panel.add(b);
        panel.add(show);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int rv = (int) r.getSelectedItem();
        int gv = (int) g.getSelectedItem();
        int bv = (int) b.getSelectedItem();
        panel.setBackground(new Color(rv, gv, bv));
    }

    public static void main(String[] args) {
        new RGBColor();
    }
}