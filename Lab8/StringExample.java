import java.util.Scanner;

public class StringExample {

    String str;

    public static void main(String[] args) {

        StringExample obj = new StringExample();
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a String : ");
        obj.str = sc.nextLine();   // user-entered string

        System.out.println("\n1. Change Case");
        System.out.println("2. Reverse String (without function)");
        System.out.println("3. Reverse String (using pre-defined function)");
        System.out.println("4. Compare two strings");
        System.out.println("5. Insert one string into another");
        System.out.println("6. Convert to Uppercase and Lowercase");
        System.out.println("7. Check character position");
        System.out.println("8. Check palindrome");
        System.out.println("9. Count words, vowels, consonants");

        System.out.print("\nEnter your choice : ");
        int choice = sc.nextInt();
        sc.nextLine();   // consume leftover newline

        switch (choice) {

            case 1:
                obj.changeCase();
                break;

            case 2:
                obj.reverseString(obj.str);
                break;

            case 3:
                System.out.println(obj.revStr(obj.str));
                break;

            case 4:
                System.out.print("Enter second string for comparision : ");
                String s2 = sc.nextLine();
                int diff = Math.abs(obj.str.compareTo(s2));
                System.out.println("The difference between ASCII value is " + diff);
                break;

            case 5:
                System.out.print("Enter the string to be inserted into first string : ");
                String insert = sc.nextLine();
                System.out.println("The string after insertion is : " + obj.str + " " + insert);
                break;

            case 6:
                System.out.println("Uppercase: " + obj.str.toUpperCase());
                System.out.println("Lowercase: " + obj.str.toLowerCase());
                break;

            case 7:
                System.out.print("Enter a character : ");
                char ch = sc.next().charAt(0);
                int pos = obj.str.indexOf(ch);
                if (pos != -1)
                    System.out.println("Position of entered character: " + pos);
                else
                    System.out.println("Entered character is not present");
                break;

            case 8:
                String rev = obj.revStr(obj.str);
                if (obj.str.equals(rev))
                    System.out.println("Entered string is palindrome");
                else
                    System.out.println("Entered string is not a palindrome");
                break;

            case 9:
                int vowels = 0, consonants = 0, words = 0;
                String s = obj.str.toLowerCase();

                String[] w = s.trim().split("\\s+");
                words = w.length;

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c >= 'a' && c <= 'z') {
                        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                            vowels++;
                        else
                            consonants++;
                    }
                }

                System.out.println("No. of words: " + words);
                System.out.println("No. of vowels: " + vowels);
                System.out.println("No. of consonants: " + consonants);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    String changeCase() {
        String result = "";
        // null looks bad

        result = str.toUpperCase();
        System.out.println("The changed string is:" + result);
        return result;
    }

    String reverseString(String str) {
        String result = "";
        int start = 0, end = str.length(), destoffset = 0;
        // initialised destoffset and removed unsafe indexese

        char buf[] = new char[end - start];
        str.getChars(start, end, buf, destoffset);
        System.out.println(buf);

        for (int i = buf.length - 1; i >= 0; i--) {
            // originally i == 0, loop wont start
            result += buf[i];
        }

        System.out.println("The string after reversing is " + result);
        return result;
    }

    String revStr(String str) {
        String result = "";
        StringBuffer sb = new StringBuffer(str);
        result = sb.reverse().toString();
        return result;
    }
}
