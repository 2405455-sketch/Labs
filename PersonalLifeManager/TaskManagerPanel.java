import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class TaskManagerPanel extends JPanel {

    ArrayList<Task> tasks = new ArrayList<>();
    JPanel taskListPanel;
    JTextField taskField;
    JLabel remainingLabel;

    File file = new File("tasks.txt");

    public TaskManagerPanel(){

        setLayout(new BorderLayout());
        setBackground(new Color(30,30,30));

        JPanel top = new JPanel();
        top.setBackground(new Color(30,30,30));

        taskField = new JTextField(20);
        JButton addBtn = new JButton("Add Task");

        top.add(taskField);
        top.add(addBtn);

        add(top,BorderLayout.NORTH);

        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel,BoxLayout.Y_AXIS));
        taskListPanel.setBackground(new Color(45,45,45));

        add(new JScrollPane(taskListPanel),BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setBackground(new Color(30,30,30));

        remainingLabel = new JLabel("Remaining Tasks: 0");
        remainingLabel.setForeground(Color.WHITE);

        JButton deleteBtn = new JButton("Delete Completed");

        bottom.add(remainingLabel);
        bottom.add(deleteBtn);

        add(bottom,BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addTask());
        deleteBtn.addActionListener(e -> deleteCompleted());

        loadTasks();
    }

    void addTask(){

        String text = taskField.getText().trim();
        if(text.isEmpty()) return;

        Task t = new Task(text,false);
        tasks.add(t);

        addCheckBox(t);

        taskField.setText("");
        updateRemaining();
        saveTasks();
    }

    void addCheckBox(Task t){

        JCheckBox box = new JCheckBox(t.text,t.completed);
        box.setBackground(new Color(45,45,45));
        box.setForeground(Color.WHITE);

        box.addActionListener(e -> {
            t.completed = box.isSelected();
            updateRemaining();
            saveTasks();
        });

        taskListPanel.add(box);
        taskListPanel.revalidate();
    }

    void updateRemaining(){

        int count=0;

        for(Task t:tasks){
            if(!t.completed) count++;
        }

        remainingLabel.setText("Remaining Tasks: "+count);
    }

    void deleteCompleted(){

        int confirm = JOptionPane.showConfirmDialog(
                this,"Delete completed tasks?",
                "Confirm",JOptionPane.YES_NO_OPTION);

        if(confirm==JOptionPane.YES_OPTION){

            tasks.removeIf(t -> t.completed);

            taskListPanel.removeAll();

            for(Task t:tasks){
                addCheckBox(t);
            }

            taskListPanel.revalidate();
            taskListPanel.repaint();

            updateRemaining();
            saveTasks();
        }
    }

    void saveTasks(){

        try(PrintWriter pw = new PrintWriter(file)){

            for(Task t:tasks){
                pw.println(t.text+"|"+t.completed);
            }

        }catch(Exception ignored){}
    }

    void loadTasks(){

        if(!file.exists()) return;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            String line;

            while((line=br.readLine())!=null){

                String[] parts = line.split("\\|");

                Task t = new Task(parts[0],Boolean.parseBoolean(parts[1]));
                tasks.add(t);

                addCheckBox(t);
            }

            updateRemaining();

        }catch(Exception ignored){}
    }
}