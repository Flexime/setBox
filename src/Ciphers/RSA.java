package Ciphers;

/**
 * Encryption
 * Public key (5,14)
 * private key (d,14)
 * find d
 *
 *
 *
 *
 * 1 p =2, q  7 prime
 * 2 N = pxq =14
 * 3 fi(n) =(p-1)x(q-1) =6
 * 4choose e: 5
 * 4.1 1<e<fi(n) //2 3 4 5
 * 4.2 e coprime fi(n), N || gcd fi((n,e) = 1;
 *
 * 5choose d:
 * 5.1 de mod fi(n) =1;
 *
 * // 5d mod 6 =1; //d {1,2,3,4,5,6,7,8.... }
 * { 5,10,15.20, 25,30 .... } mod 6 =>
 * {5,4,3,2,1,0,,0,5,4,3,2,1,0 }
 *  d= 11
 *
 *
 *  encryption(5,14)
 *  Text: V / 2 pos
 *
 *   2^5 mod 14 = 32 mod 14 = 4;
 *
 *   B=>D
 *
 *decription (11,14)
 * text D/pos 4
 *
 * 4^11 mod 14 = 4 million. mid 14 =2
 *
 *
 *
 *D->B;
 *
 */

public class RSA {

    public static void main(String[] args) {



    }


}
