package Lab9;
//Q3
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryCompare {

    public static void main(String[] args) {

        String file1 = "1";
        String file2 = "2";

        FileInputStream fis1;
        FileInputStream fis2;
        try{
            fis1 = new FileInputStream(file1);
            fis2 = new FileInputStream(file2);

            int byte1, byte2;
            int pos=0;
            boolean areEqual = true;

            while (true) {

                byte1 = fis1.read();
                byte2 = fis2.read();

                if (byte1 == -1 && byte2 == -1) {
                    break;
                }

                if (byte1 != byte2) {
                    System.out.println("Files differ at byte position: " + pos);
                    areEqual = false;
                    break;
                }

                pos++;
            }

            if (areEqual) {
                System.out.println("Two files are equal");
            }

        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}