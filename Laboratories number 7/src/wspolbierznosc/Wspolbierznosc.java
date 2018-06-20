/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspolbierznosc;

/**
 *
 * @author Rafał
 */
public class Wspolbierznosc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker("name1");
        worker.setListener(new WorkerListenerClass());
        worker.enqueueTask("One",new TaskClass());
        worker.enqueueTask("Two",new Task100());
        worker.enqueueTask("Three",new yieldTask());
        worker.enqueueTask("Four",new TaskClass());
        worker.enqueueTask("Five",new TaskClass());
       
        worker.start();
        worker.enqueueTask("Six",new TaskClass());
        worker.enqueueTask("Seven",new Task100());
        worker.enqueueTask("Eight",new yieldTask());
        worker.enqueueTask("Nine",new TaskClass());
        worker.enqueueTask("Ten",new TaskClass());
        worker.stop();
        try{
            worker.thread.join();
        }catch(InterruptedException e){
            System.out.println("Break of main thread");
        }
        System.out.println("End of main thread");
    }
    
}
