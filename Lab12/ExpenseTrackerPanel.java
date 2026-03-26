import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ExpenseTrackerPanel extends JPanel {

    ArrayList<Expense> expenses = new ArrayList<>();

    JTextArea displayArea;
    JLabel totalLabel;

    File file = new File("expenses.txt");

    public ExpenseTrackerPanel(){

        setLayout(new BorderLayout());
        setBackground(new Color(30,30,30));

        JPanel top = new JPanel();
        top.setBackground(new Color(30,30,30));

        JTextField amountField = new JTextField(10);

        String[] categories = {"Food","Transport","Study","Entertainment","Other"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);

        JButton addBtn = new JButton("Add Expense");

        JLabel amountLabel = new JLabel("Amount (₹): ");
        amountLabel.setForeground(Color.WHITE);

        top.add(amountLabel);
        top.add(amountField);
        top.add(categoryBox);
        top.add(addBtn);

        add(top,BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(new Color(45,45,45));
        displayArea.setForeground(Color.WHITE);

        add(new JScrollPane(displayArea),BorderLayout.CENTER);

        totalLabel = new JLabel("Total Spending: ₹0");
        totalLabel.setForeground(Color.WHITE);

        add(totalLabel,BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {

            String text = amountField.getText().trim();

            if(text.isEmpty()){
                JOptionPane.showMessageDialog(this,"Enter an amount");
                return;
            }

            try{

                double amount = Double.parseDouble(text);
                String category = (String)categoryBox.getSelectedItem();

                Expense ex = new Expense(category,amount);
                expenses.add(ex);

                displayArea.append(category + " : ₹" + amount + "\n");

                updateTotal();
                saveExpenses();

                amountField.setText("");

            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid number");
            }

        });

        loadExpenses();
    }

    void updateTotal(){

        double total = 0;

        for(Expense e : expenses){
            total += e.amount;
        }

        totalLabel.setText("Total Spending: ₹" + total);
    }

    void saveExpenses(){

        try(PrintWriter pw = new PrintWriter(file)){

            for(Expense e : expenses){
                pw.println(e.category + "|" + e.amount);
            }

        }catch(Exception ignored){}
    }

    void loadExpenses(){

        if(!file.exists()) return;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            String line;

            while((line = br.readLine()) != null){

                String[] parts = line.split("\\|");

                Expense e = new Expense(parts[0],Double.parseDouble(parts[1]));
                expenses.add(e);

                displayArea.append(e.category + " : ₹" + e.amount + "\n");
            }

            updateTotal();

        }catch(Exception ignored){}
    }
}