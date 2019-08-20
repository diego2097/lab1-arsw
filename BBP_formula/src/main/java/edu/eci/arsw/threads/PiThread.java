/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

import static edu.eci.arsw.math.Main.bytesToHex;
import edu.eci.arsw.math.PiDigits;

/**
 *
 * @author 2125509
 */
public  class PiThread extends Thread {

    public  int start;
    public  int count;
    public  int startp;
    public  int startpp;

    public PiThread(int start, int count,int startp) {
        this.startpp = start;
        this.start = start;    
        this.startp = startp;
        this.count = count;
        
    }

    public void run() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            if (i % PiDigits.DigitsPerSum == 0) {
                sum = 4 * PiDigits.sum(1, start)
                        - 2 * PiDigits.sum(4, start)
                        - PiDigits.sum(5, start)
                        - PiDigits.sum(6, start);

                start += PiDigits.DigitsPerSum;
            }

            sum = 16 * (sum - Math.floor(sum));
           
            PiDigits.digits[startpp-startp+i] = (byte) sum;
        }
    }
}
