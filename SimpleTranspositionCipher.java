import java.util.Scanner;

public class SimpleTranspositionCipher {
    public static String encrypt(String text, int numColumns) {
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

    public static String decrypt(String text, int numColumns) {
        StringBuilder result = new StringBuilder();
        int numRows = (int) Math.ceil((double) text.length() / numColumns);
        char[][] grid = new char[numRows][numColumns];

        int index = 0;
        for (int c = 0; c < numColumns; c++) {
            for (int r = 0; r < numRows; r++) {
                grid[r][c] = text.charAt(index++);
            }
        }
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                result.append(grid[r][c]);
            }
        }

        return result.toString().replace("X", ""); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the plaintext:");
        String plaintext = sc.nextLine();
        System.out.println("Enter the number of columns for transposition:");
        int numColumns = sc.nextInt();
        String encryptedText = encrypt(plaintext, numColumns);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText, numColumns);
        System.out.println("Decrypted Text: " + decryptedText);

        sc.close();
    }
}
