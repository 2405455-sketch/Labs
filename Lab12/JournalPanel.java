import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class JournalPanel extends JPanel {

    JTextArea entryArea;
    JTextArea historyArea;

    LocalDate currentDate = LocalDate.now();
    int journalCount = 0;

    File file = new File("journal.txt");

    public JournalPanel(){

        setLayout(new BorderLayout());
        setBackground(new Color(30,30,30));

        entryArea = new JTextArea(5,30);

        JButton saveBtn = new JButton("Save Entry");

        JPanel top = new JPanel();
        top.setBackground(new Color(30,30,30));

        top.add(new JLabel("Write Journal"));
        top.add(saveBtn);

        add(top,BorderLayout.NORTH);
        add(new JScrollPane(entryArea),BorderLayout.CENTER);

        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setBackground(new Color(45,45,45));
        historyArea.setForeground(Color.WHITE);

        add(new JScrollPane(historyArea),BorderLayout.SOUTH);

        saveBtn.addActionListener(e -> saveJournal());

        loadJournal();
    }

    void saveJournal(){

        String text = entryArea.getText().trim();
        if(text.isEmpty()) return;

        LocalDate today = LocalDate.now();

        if(!today.equals(currentDate)){
            journalCount = 0;
            currentDate = today;
        }

        journalCount++;

        DateTimeFormatter df =
                DateTimeFormatter.ofPattern("d MMMM yyyy");

        DateTimeFormatter tf =
                DateTimeFormatter.ofPattern("hh:mm a");

        String date = today.format(df);
        String time = LocalTime.now().format(tf);

        String entry =
                "\n"+date+
                        "\nJournal "+journalCount+
                        "\n"+time+
                        "\n"+text+"\n";

        historyArea.append(entry);

        try(FileWriter fw = new FileWriter(file,true)){
            fw.write(entry);
        }catch(Exception ignored){}

        entryArea.setText("");
    }

    void loadJournal(){

        if(!file.exists()) return;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            String line;

            while((line=br.readLine())!=null){
                historyArea.append(line+"\n");
            }

        }catch(Exception ignored){}
    }
}