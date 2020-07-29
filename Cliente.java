package barberodormilon;

public class Cliente extends Thread{
    //hilo extendido con referencia a Barberia
    Barberia barberia; 
    
    //constructor de cliente
    public Cliente(Barberia barberia){
        super ("Cliente"); //le ponemos nombre cliente al hilo
        this.barberia=barberia; //Iniciamos la barberia
        
    }
    @Override
    public void run(){
        //iniciamos un bucle infinito poniendo a true el bucle while
        while(true){

            try{  
                /*probamos a ejecutar una condicion if comprobando que el numero de clientes sea mayor a 0,
                recordamos que solo van a entrar un total de 20 clientes, cuando llegue a 0 no entrara mas a esta condición, 
                esto se hace así porque al tener los hilos dormidos no alargar mucho la ejecucion del proceso */
                if (Barberia.numClientes>0){ 
                    //Llamamos al metodo llegaCliente, que esta sincronizado por usarse tambien desde la clase barbero
                    barberia.llegaCliente();
                    //decrementamos en 1 el número de clientes
                }
                //dormimos el hilo 1 segundo
                sleep(1000);   
            //si se interrumpe el hilo dormido lanza el error
            }catch(InterruptedException exception){
                System.out.println("Error: El hilo dormido se ha interrumpido");
                Barberia_grafico.logTextArea1.append("Error: El hilo dormido se ha interrumpido");
                Barberia_grafico.logTextArea1.append(System.getProperty("line.separator")); // Esto para el salto de línea  
            }
        }
    }
}