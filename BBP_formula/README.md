# Part I - Introduction to Java Threads

Completamos la clase CountThread para que reciba dos numeros A y B, Y en el ciclo del hilo imprima los numeros entre ellos.
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/picture_1.1 "CountThread")

Se completa la clase CountMainThreads para que imprima tres intervalos: [0..99], [99..199], [200..299] para despues comparar la diferencia entre los metodos start() y run()
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/picture_1.2 "CountThreadsMain")

##metodo start()
Observamos que con el metodo start el orden de los numeros esta mal. 
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/picture_start "start")

##metodo run()
Observamos que con el metodo run los numeros salen en el orden esperado. 
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/picture_run "Run")

Esto pasa porque cuando se utiliza el metodo run() directamente se ejecuta las instrucciones que esten en este metodo pero en el mismo hilo, o en el mismo proceso
en cambio cuando se usa start() se crea otro subproceso y este automaticamente llama el metodo run(). 

# Part II - BBP Formula Exercise

Creamos la clase PiThread la cual calcula un intervalo de digitos de pi. 
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/picture_2.1 "PiThread")

Modificamos el metodo getDigits para que reciba el parametro N correspondiente al numero de hilos. 
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/picture_2.2 "getDigits")

Se modifico la prueba inicial para que incluya el nuevo parametro N numero de hilos. Se probo con 1,2,3 hilos. Una prueba para cada uno. 
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/picture_2.3 "test")

# Part III - BBP Formula Exercise

Al utilizar un solo hilo el programa nunca termina de calcular el millon de digitos. hPor lo tanto se tomaran 80000 digitos para poder realizar el la prueba.

## Un solo hilo 
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/onethread_threads "onethread_threads")
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/onethread_memory "onethread_memory")

## Tantos hilos como nucleos de procesamiento(8)
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/available_threads "available_threads")
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/available_memory "available_memory")

## Tantos hilos como el doble de nucleos de procesamiento(16)
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/double_threads "double_threads")
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/double_memory "double_memory")
	
## 200 hilos 
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/200_threads "200_threads")
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/200_memory "200_memory")
	
## 500 hilos
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/500_threads "500_threads")
![alt text](https://github.com/diego2097/lab1-arsw/tree/master/BBP_formula/img/500_memory "500_memory")
	

## Tiempos de ejecucion 

Un solo hilo: 517.624 segundos 
Tantos hilos como nucleos: 149.386 segundos
Tantos hilos como el doble de nucleos: 60.504 segundos 
200 hilos: 51.626 segundos 
500 hilos: 53.219 segundos 



1. la diferencia es bastante minima, pero la razon por la que no se cumple la ley de Amdahls puede ser por la memoria que consume una mayor cantidad de hilos. ya que se debe guardar el estado de cada hilo.  

2. Al utilizar el doble de hilos, el tiempo de ejecucion es significativamente menor. 89 segundos menor. se puede deber a que el costo en memoria no es tan alto al aumentar al doble la cantidad de hilos. 

3. 
 
