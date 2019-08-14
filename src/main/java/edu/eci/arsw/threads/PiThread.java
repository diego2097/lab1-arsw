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
public class PiThread extends Thread{

    
    public static int A;
    public static int B;
    public static String cadena="";
        
    public PiThread(int a, int b){
        this.A = a;
        this.B = b;
    }
    
    
    
    @Override
    public void run() {
       
    }
    
  
}
