import java.util.Scanner;

public class ProductCipher {

    // Caesar Cipher for substitution
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + shift) % 26 + base);
            }

            result.append(ch); 
        }

        return result.toString();
    }

    public static String columnarTransposition(String text, int numColumns) {
        StringBuilder result = new StringBuilder();
        int numRows = (int) Math.ceil((double) text.length() / numColumns);
        char[][] grid = new char[numRows][numColumns];

        int index = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                if (index < text.length()) {
                    grid[r][c] = text.charAt(index++);
                } else {
                    grid[r][c] = 'X'; 
                }
            }
        }

       
        for (int c = 0; c < numColumns; c++) {
            for (int r = 0; r < numRows; r++) {
                result.append(grid[r][c]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the plaintext:");
        String plaintext = sc.nextLine();
        System.out.println("Enter the shift value for substitution (Caesar Cipher):");
        int shift = sc.nextInt();

        String substitutedText = caesarCipher(plaintext, shift);
        System.out.println("After Substitution (Caesar Cipher): " + substitutedText);

        System.out.println("Enter the number of columns for transposition:");
        int numColumns = sc.nextInt();
        String encryptedText = columnarTransposition(substitutedText, numColumns);
        System.out.println("Final Encrypted Text (Product Cipher): " + encryptedText);

        sc.close();
    }
}
