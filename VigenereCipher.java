import java.util.Scanner;

public class VigenereCipher {

    public static String vigenere(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        int keyLen = key.length();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                int textPos = ch - 'A';
                int keyPos = key.charAt(i % keyLen) - 'A';
                int offset = encrypt ? (textPos + keyPos) % 26 : (textPos - keyPos + 26) % 26;
                result.append((char) (offset + 'A'));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        System.out.println("Enter key:");
        String key = sc.nextLine();

        String encrypted = vigenere(text, key, true);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = vigenere(encrypted, key, false);
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}
