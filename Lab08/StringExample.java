package Lab8;

import java.util.Scanner;

public class StringExample {
    static String result = "";
    static Boolean err = true;

    public static void main(String[] args) {

        // 1st way
        String name = "Rama";

        // 2nd way
        String newname = new String("Gopal");

        // 3rd way
        char[] st = { 'a', 'b', 'c' };
        String str = new String(st);

        Scanner sc = new Scanner(System.in);

        System.out.println("Pick Option\n" +
                "1) Change the case of the string\n" +
                "2) Reverse the string \n" +
                "3) Compare two strings\n" +
                "4) Insert one string into another string\n" +
                "5) Convert the string to upper case and lower case\n" +
                "6) Check whether the character is present in the string and at which position\n" +
                "7) Check whether the string is palindrome or not.\n" +
                "8) Check the number of word, vowel and consonant in the string");

        int i = sc.nextInt();
        sc.nextLine();   // ✅ FIX: consume leftover newline

        System.out.println("Enter String:");
        String s = sc.nextLine();

        switch (i) {
            case 1:
                changeCase(s);
                break;
            case 2:
                revYesFun(s);
                break;
            case 3:
                System.out.println("Enter next String:");
                String s2 = sc.nextLine();
                compareString(s, s2);
                break;
            case 4:
                System.out.println("Enter next String:");
                String s3 = sc.nextLine();
                joinString(s, s3);
                break;
            case 5:
                convertCase(s);
                break;
            case 6:
                System.out.println("Enter character:");
                char ch = sc.next().charAt(0);
                checkCharacter(s, ch);
                break;
            case 7:
                checkPalindrome(s);
                break;
            case 8:
                countAll(s);
                break;
            default:
                System.out.println("Invalid Choice");
                err = false;
                break;
        }

        if (!result.equals(""))
            System.out.println("Result: " + result);
    }

    // i) Change case
    static void changeCase(String str) {
        result = str.toUpperCase();
    }

    // ii a) Reverse without predefined function
    static void revNoFun(String str) {
        result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
    }

    // ii b) Reverse using predefined function
    static void revYesFun(String str) {
        StringBuffer sb = new StringBuffer(str);
        result = sb.reverse().toString();
    }

    // iii) Compare strings
    static void compareString(String str1, String str2) {
        int res = str2.compareTo(str1);
        System.out.println("The difference between ASCII value is: " + res);
    }

    // iv) Insert string
    static void joinString(String s1, String s2) {
        String res = s1 + " " + s2;
        System.out.println("The string after insertion is: " + res);
    }

    // v) Convert upper & lower case
    static void convertCase(String str) {
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
    }

    // vi) Character position
    static void checkCharacter(String str, char ch) {
        int pos = str.indexOf(ch);
        if (pos >= 0)
            System.out.println("Position of entered character: " + pos);
        else
            System.out.println("Entered character is not present");
    }

    // vii) Palindrome
    static void checkPalindrome(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        if (str.equalsIgnoreCase(rev))
            System.out.println("Entered string is palindrome");
        else
            System.out.println("Entered string is not a palindrome");
    }

    // viii) Count words, vowels, consonants
    static void countAll(String str) {
        int words = 0, vowels = 0, consonants = 0;

        String s = str.trim();

        if (!s.isEmpty())
            words = s.split("\\s+").length;

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("No. of words: " + words);
        System.out.println("No. of vowels: " + vowels);
        System.out.println("No. of consonants: " + consonants);
    }
}