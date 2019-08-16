package edu.eci.arsw.math;

///  <summary>

import edu.eci.arsw.threads.PiThread;
import java.util.ArrayList;

///  An implementation of the Bailey-Borwein-Plouffe formula for calculating hexadecimal
///  digits of pi.
///  https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula
///  *** Translated from C# code: https://github.com/mmoroney/DigitsOfPi ***
///  </summary>
public class PiDigits {

    public static int DigitsPerSum = 8;
    public static double Epsilon = 1e-17;
    public static byte[] digits;
    
    /**
     * Returns a range of hexadecimal digits of pi.
     * @param start The starting location of the range.
     * @param count The number of digits to return
     * @param n
     * @return An array containing the hexadecimal digits.
     */
    public static byte[]  getDigits(int start, int count,int n) throws InterruptedException {
        ArrayList<PiThread> threads=new ArrayList<>();
        digits = new byte[count];
        if (start < 0) {
            throw new RuntimeException("Invalid Interval");
        }

        if (count < 0) {
            throw new RuntimeException("Invalid Interval");
        }
        int cabeza=start;
        for(int i=0;i<n;i++){
            System.out.println(cabeza+" "+(cabeza+(count/n)-1));  
            threads.add(new PiThread(cabeza,2,start));
            cabeza=cabeza+(count/n);
           
        }
        
        for(PiThread t: threads){
           t.start();
        }
        for(PiThread t: threads){
           t.join();
        }
        return digits;

    }

    /// <summary>
    /// Returns the sum of 16^(n - k)/(8 * k + m) from 0 to k.
    /// </summary>
    /// <param name="m"></param>
    /// <param name="n"></param>
    /// <returns></returns>
    public static double sum(int m, int n) {
        double sum = 0;
        int d = m;
        int power = n;

        while (true) {
            double term;

            if (power > 0) {
                term = (double) hexExponentModulo(power, d) / d;
            } else {
                term = Math.pow(16, power) / d;
                if (term < Epsilon) {
                    break;
                }
            }

            sum += term;
            power--;
            d += 8;
        }

        return sum;
    }

    /// <summary>
    /// Return 16^p mod m.
    /// </summary>
    /// <param name="p"></param>
    /// <param name="m"></param>
    /// <returns></returns>
    public static int hexExponentModulo(int p, int m) {
        int power = 1;
        while (power * 2 <= p) {
            power *= 2;
        }

        int result = 1;

        while (power > 0) {
            if (p >= power) {
                result *= 16;
                result %= m;
                p -= power;
            }

            power /= 2;

            if (power > 0) {
                result *= result;
                result %= m;
            }
        }

        return result;
    }

}
