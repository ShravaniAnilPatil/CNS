import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class SimpleRSA {

    public static void main(String[] args) {
        Random rand = new Random();
        int bitLength = 512; 

        BigInteger p = BigInteger.probablePrime(bitLength, rand);
        BigInteger q = BigInteger.probablePrime(bitLength, rand);

        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.valueOf(65537);
        BigInteger d = e.modInverse(phi);

        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + d + ", " + n + ")");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message (as a number):");
        BigInteger message = sc.nextBigInteger();

        BigInteger ciphertext = message.modPow(e, n);
        System.out.println("Encrypted message: " + ciphertext);
        BigInteger plaintext = ciphertext.modPow(d, n);
        System.out.println("Decrypted message: " + plaintext);

        sc.close();
    }
}
