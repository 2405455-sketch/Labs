package Lab9;

import java.io.*;
import java.util.Scanner;

public class FileDetails {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();
        int characters = 0;
        int words = 0;
        int lines = 0;
        boolean isWord = false;

        try {
            FileReader fr = new FileReader(fileName);
            int ch;
            while ((ch = fr.read()) != -1) {
                characters++;
                if (ch == '\n') {
                    lines++;
                }
                if (!Character.isWhitespace((char) ch)) {
                    if (!isWord) {
                        words++;
                        isWord = true;
                    }
                } else {
                    isWord = false;
                }
            }
            fr.close();

            if (characters > 0) {
                lines++;
            }

            System.out.println("No. of characters - " + characters);
            System.out.println("No. of lines - " + lines);
            System.out.println("No. of words - " + words);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}