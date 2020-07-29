
package barberodormilon;

/**
 *
 * @author Pablo Aparicio Estévez
 */
public class ManejadorExcepciones implements Thread.
//manejador de excepciones para toda la aplicación
   UncaughtExceptionHandler{
    //implementa el método uncaughtException()
    @Override
    public void uncaughtException(Thread t, Throwable e){
        System.out.printf("Thread que lanza la excepcion: %s \n", t.getName());
        //muestra en consola el hilo que produce la exceción
        e.printStackTrace();
        //muestra en consola la pila de llamadas
    }
}
