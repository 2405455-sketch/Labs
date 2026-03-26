import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CatAnimation extends JPanel implements Runnable {

    private int x = 50, y = 80;
    private int step = 2;
    private int direction = 0;

    private String[] messages = {"Welcome", "Enjoy", "Thanks", "Visit Again"};
    private int msgIndex = 0;

    private ArrayList<Image> images = new ArrayList<>();

    private int[] sequence = {0, 1, 2, 3, 2, 1};
    private int seqIndex = 0;
    private int imgIndex = 0;

    public CatAnimation() {

        setBackground(new Color(181, 226, 255));

        images.add(new ImageIcon("D:\\JavaProjects\\Labs\\Lab13\\img1.png").getImage());
        images.add(new ImageIcon("D:\\JavaProjects\\Labs\\Lab13\\img2.png").getImage());
        images.add(new ImageIcon("D:\\JavaProjects\\Labs\\Lab13\\img3.png").getImage());
        images.add(new ImageIcon("D:\\JavaProjects\\Labs\\Lab13\\img4.png").getImage());

        new Thread(this).start();

        new Thread(() -> {
            try {
                while (true) {
                    msgIndex = (msgIndex + 1) % messages.length;
                    repaint();
                    Thread.sleep(1200);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void run() {
        try {
            while (true) {

                moveInSquare();

                imgIndex = sequence[seqIndex];
                seqIndex = (seqIndex + 1) % sequence.length;

                repaint();

                Thread.sleep(120);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void moveInSquare() {
        int limit = 300;

        switch (direction) {
            case 0: x += step; if (x >= limit) direction = 1; break;
            case 1: y += step; if (y >= limit) direction = 2; break;
            case 2: x -= step; if (x <= 50) direction = 3; break;
            case 3: y -= step; if (y <= 80) direction = 0; break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(images.get(imgIndex), x, y, 130, 130, this);

        g2.setFont(new Font("Segoe UI", Font.BOLD, 24));
        g2.setColor(new Color(60, 60, 110));

        g2.drawString(messages[msgIndex], 140, 50);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Cat Yarn Animation");

        CatAnimation panel = new CatAnimation();

        frame.add(panel);
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}