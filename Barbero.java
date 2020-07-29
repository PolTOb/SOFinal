package barberodormilon;

public class Barbero extends Thread{
    //hilo extendido con referencia a Barberia
    private final Barberia barberia;
    
    //Constructor de la clase barbero
    public Barbero(Barberia barberia){
        super ("Barbero"); //le ponemos nombre barbero al hilo
        this.barberia=barberia; //Iniciamos la barberia
    }

    @Override
    public void run(){
        //iniciamos un bucle infinito poniendo a true el bucle while
        while(true){

            try {
                //al ejecutarse el hilo del barbero atiende a un cliente y este sale de la barberia
                barberia.salirCliente();
                    /*probamos a ejecutar una condicion if comprobando que el numero de clientes sea mayor a 0,
                    recordamos que solo van a entrar un total de 20 clientes, cuando llegue a 0 no entrara mas a esta condicion, 
                    esto se hace así porque al tener los hilos dormidos no alargar mucho la ejecucion del proceso */
                    if (Barberia.numClientes>0){
                        //si en numero de clientes que ha entrado en la barberia es mayor a 0 , entra otro cliente, llamamos al metodo llegaCliente, 
                        //que esta sincronizado por usarse tambien desde la clase cliente
                        barberia.llegaCliente();
                        //decrementamos en 1 el numero de clientes
                        sleep(1000);
                    }              
            //si se interrumpe el hilo dormido lanza el error
            } catch (InterruptedException ex) {
                System.out.println("Error: El hilo dormido se ha interrumpido");
                Barberia_grafico.logTextArea1.append("Error: El hilo dormido se ha interrumpido");
                Barberia_grafico.logTextArea1.append(System.getProperty("line.separator")); // Esto para el salto de línea 
            }            
        }
    }
}