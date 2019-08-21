/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author luisp
 */
public class PrimeFinderKey {

    private PrimeFinderThread thread1;
    private PrimeFinderThread thread2;
    private PrimeFinderThread thread3;
    private int canidadPrimos;
    private boolean condicion;

    public PrimeFinderKey() {
        thread1 = new PrimeFinderThread(0, 10000000);
        thread2 = new PrimeFinderThread(10000001, 20000000);
        thread3 = new PrimeFinderThread(20000001, 30000000);
        canidadPrimos = 0;
        condicion = true;
    }

    public void calcular() throws InterruptedException {
        long inicio = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        long fin = System.currentTimeMillis();
        System.out.println("ESPERANDO 5 segundos: ");
        while (condicion) {
            fin = System.currentTimeMillis();
            double tiempo = (double) ((fin - inicio) / 1000);
            if (tiempo % 5 == 0 && tiempo != 0) {
                condicion = false;
                thread1.suspend();
                thread2.suspend();
                thread3.suspend();
            }
        }
       
        mostrar();
         System.out.println("PRESIONE LA TELCA ENTER PARA TERMINAR");
        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        do {
            entrada = scanner.nextLine();
            System.out.println(entrada);
        } while (!entrada.equals(""));
        //reanudarCalculos();
        terminar();
        System.exit(0);
    }

    private void reanudarCalculos() {
        thread1.resume();
        thread2.resume();
        thread3.resume();
    }

    private void terminar() {
            thread1.stop();
            thread2.stop();
            thread3.stop();
            System.exit(0);
       
        
    }

    private void mostrar() {
        thread1.getPrimes().forEach((e) -> {
            System.out.println(e);
        });
        thread2.getPrimes().forEach((e) -> {
            System.out.println(e);
        });
        thread3.getPrimes().forEach((e) -> {
            System.out.println(e);
        });
        canidadPrimos += thread1.getPrimes().size() + thread1.getPrimes().size() + thread1.getPrimes().size();
        System.out.println("Numero Total De Primos calculados en 5s es: " + canidadPrimos);
    }
}
