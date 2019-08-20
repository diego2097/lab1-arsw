# Part I
### 1: 



### 2: 
creando y repartiendo el proceso en 3 threads: 
```java
public static void main(String[] args) throws InterruptedException {
        PrimeFinderThread pft = new PrimeFinderThread(0, 10000000);
        PrimeFinderThread pft2 = new PrimeFinderThread(10000001, 20000000);
        PrimeFinderThread pft3 = new PrimeFinderThread(20000001, 30000000);
        pft.start();
        pft2.start();
        pft3.start();
        }
		
```        
### 3:
la espera de 5 segundos se realizó mediante el metodo currentTimeMillis() de la clase system. realizando la diferencia entre el tiempo en el que se comenzó a ejecutar y el tiempo de ejecución para calcular los 5 segundos, pasado dicho tiempo mostrara un listado de los 
números primos calculados y la cantidad en total.
Para la lectura de la tecla Enter se realizó mediante la clase scaner, al darle Enter el programa finalizara su ejecución.


```java
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
```   

# Part II 
resultados incorrectos: 
```java
	can.winnerDialog(reg.getGanador(),reg.getUltimaPosicionAlcanzada() - 1); 
        System.out.println("El ganador fue:" + reg.getGanador());              
```   
la región critica que encontramos se muestra en la parte inferior se debe a que los hilos cuando se estan ejecutando intentar acceder el mismo atributo reg de la case MainCanodromo dicha region se encuentra en la case Galgo En el metodo Corra():
 
```java
    	if (paso == carril.size()) {						
				carril.finish();
				int ubicacion=regl.getUltimaPosicionAlcanzada();
				regl.setUltimaPosicionAlcanzada(ubicacion+1);
				System.out.println("El galgo "+this.getName()+" llego en la posicion "+ubicacion);
				if (ubicacion==1){
					regl.setGanador(this.getName());
				}
				
			}
```   

# Part III
correccion de resultados: 
```java
    	for (int i = 0; i < can.getNumCarriles(); i++) {
                            try {
                                galgos[i].join();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(MainCanodromo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
```
correccion de region critica identificada en la parte 2:
```java
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
```