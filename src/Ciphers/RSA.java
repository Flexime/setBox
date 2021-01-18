package Ciphers;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private BigInteger n, d, e;

    public RSA(int bitlen)
    {
        SecureRandom r = new SecureRandom();
        // p and q generated randomly
        BigInteger p = new BigInteger(bitlen / 2, 100, r); // certainty BigInt prime exists
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); //(p-1)x(q-1) phi(n)
        e = new BigInteger("3"); // choose
        while(m.gcd(e).intValue() > 1) e = e.add(new BigInteger("2")); // de = % m = 1   1<e<phi(n)
        d = e.modInverse(m); // e x = 1 (mod m )
        System.out.println("p: "  + p);
        System.out.println("q: "+ q);
        System.out.println("\n e : " + e );
        System.out.println("\n Public keys  n: " + n );
        System.out.println("\n Secret key d:  " + d );


    }


    public  BigInteger encrypt(BigInteger message)
    {
        return message.modPow(e, n);// C = m^e (mod n)
    }

    public BigInteger decrypt(BigInteger message)
    {
        return message.modPow(d, n); // P = C^d (mod n)
    }

    public static void main(String[] args) {
        // bitlen 2^x
        RSA rsa = new RSA(256);
        //prepare plain text
        String msg = "Wolf2";
        BigInteger plaintext = new BigInteger(msg.getBytes());
        //encryption
        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Ciphertext: " +ciphertext);

        //decryption
        plaintext =rsa.decrypt(ciphertext);
        String msg2 =new String(plaintext.toByteArray());
        System.out.println("PLaintext: " +msg2);

    }
}