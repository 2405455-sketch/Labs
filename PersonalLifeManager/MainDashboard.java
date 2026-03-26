import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {

    CardLayout cardLayout;
    JPanel contentPanel;

    public MainDashboard(){

        setTitle("Personal Life Manager");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        Color sidebar = new Color(40,40,40);
        Color text = new Color(220,220,220);

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(3,1,10,10));
        navPanel.setBackground(sidebar);
        navPanel.setPreferredSize(new Dimension(180,600));

        JButton taskBtn = new JButton("Task Manager");
        JButton expenseBtn = new JButton("Expense Tracker");
        JButton journalBtn = new JButton("Mini Journal");

        JButton[] buttons = {taskBtn,expenseBtn,journalBtn};

        for(JButton b:buttons){
            b.setFocusPainted(false);
            b.setBackground(new Color(60,60,60));
            b.setForeground(text);
            navPanel.add(b);
        }

        add(navPanel,BorderLayout.WEST);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(new TaskManagerPanel(),"TASKS");
        contentPanel.add(new ExpenseTrackerPanel(),"EXPENSES");
        contentPanel.add(new JournalPanel(),"JOURNAL");
        add(contentPanel,BorderLayout.CENTER);

        taskBtn.addActionListener(e -> cardLayout.show(contentPanel,"TASKS"));
        expenseBtn.addActionListener(e -> cardLayout.show(contentPanel,"EXPENSES"));
        journalBtn.addActionListener(e -> cardLayout.show(contentPanel,"JOURNAL"));

        setVisible(true);
    }

    public static void main(String[] args){
        new MainDashboard();
    }
}