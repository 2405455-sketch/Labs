import javax.swing.*;
import java.awt.*;

public class RegistrationForm extends JFrame {

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        JLabel title = new JLabel("User Registration");
        title.setBounds(150, 20, 200, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 80, 100, 25);
        name.setForeground(Color.WHITE);
        panel.add(name);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 80, 200, 25);
        panel.add(nameField);

        JLabel address = new JLabel("Address:");
        address.setBounds(50, 120, 100, 25);
        address.setForeground(Color.WHITE);
        panel.add(address);

        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(150, 120, 200, 60);
        panel.add(addressArea);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(50, 200, 100, 25);
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        male.setBounds(150, 200, 70, 25);
        female.setBounds(230, 200, 80, 25);
        male.setBackground(Color.BLACK);
        female.setBackground(Color.BLACK);
        male.setForeground(Color.WHITE);
        female.setForeground(Color.WHITE);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        panel.add(male);
        panel.add(female);

        JCheckBox terms = new JCheckBox("Accept Terms");
        terms.setBounds(150, 240, 150, 25);
        terms.setBackground(Color.BLACK);
        terms.setForeground(Color.WHITE);
        panel.add(terms);

        JButton submit = new JButton("Submit");
        submit.setBounds(180, 290, 100, 30);
        panel.add(submit);

        ImageIcon icon = new ImageIcon("user.png"); // keep image in same folder
        JLabel img = new JLabel(icon);
        img.setBounds(370, 60, 100, 100);
        panel.add(img);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}