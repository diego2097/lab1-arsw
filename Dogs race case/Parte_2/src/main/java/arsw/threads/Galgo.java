package arsw.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Un galgo que puede correr en un carril
 *
 * @author rlopez
 *
 */
public class Galgo extends Thread {

    private int paso;
    private Carril carril;
    RegistroLlegada regl;
    private boolean pausa;

    public Galgo(Carril carril, String name, RegistroLlegada reg) {
        super(name);
        pausa = false;
        this.carril = carril;
        paso = 0;
        this.regl = reg;
    }

    public void corra() throws InterruptedException {
        while (paso < carril.size()) {
            if (!pausa) {
                Thread.sleep(100);
                carril.setPasoOn(paso++);
                carril.displayPasos(paso);

                if (paso == carril.size()) {
                    synchronized (regl) {
                        carril.finish();
                        int ubicacion = regl.getUltimaPosicionAlcanzada();
                        regl.setUltimaPosicionAlcanzada(ubicacion + 1);
                        System.out.println("El galgo " + this.getName() + " llego en la posicion " + ubicacion);
                        if (ubicacion == 1) {
                            regl.setGanador(this.getName());
                        }
                    }
                }

            } else {
                synchronized (regl) {
                    try {
                        regl.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Galgo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        }
    }

    public void setPausa(boolean p) {
        pausa = p;

    }

    @Override
    public void run() {

        try {
            corra();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    public int getPaso() {
        return paso;
    }

}
