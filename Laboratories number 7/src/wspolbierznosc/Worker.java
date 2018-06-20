/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspolbierznosc;

import java.util.LinkedList;
import java.util.Queue;






/**
 *
 * @author Rafał
 */
public class Worker implements Runnable{
    int taskNumber=1;
    String workerName;
    boolean isWorking;
    boolean isStarted;
    Queue<NewTask>myQueue;
    public Thread thread;
    WorkerListener workerListener;
    public Worker(String work){
        isWorking=false;
        isStarted=false;
        myQueue = new LinkedList<>();
        workerName = "work "+ work + " thread";
        Thread thr = new Thread(this, workerName);
        System.out.println(thr);
        thr.start();
    }
    synchronized void enqueueTask(String taskName, Task task) throws InterruptedException {
        NewTask temp=new NewTask(taskName,task);
        myQueue.add(temp);
        notify();
    }
    public synchronized void start(){
        if(isStarted){
            System.out.println("Is started ");
            return;
        }
        isStarted = true;
        isWorking = true;
        thread = new Thread(() -> {
            while (isWorking) {
                if(myQueue.isEmpty() == true){
                    isWorking = false;
                    return;
                }
                try {
                    NewTask temp=myQueue.remove();
                    workerListener.onTaskStarted(taskNumber,temp.getNameTask());
                    temp.getTask().run(taskNumber);
                    workerListener.onTaskCompleted(taskNumber, temp.getNameTask());
                    taskNumber++;
                }catch(InterruptedException e){
                    break;
                }
            }
            isStarted=false;
            workerListener.onWorkerStoped();
            
        });
        thread.start();

    };
    public synchronized void stop() throws InterruptedException {
        if(!isStarted){
            System.out.println("Is stoped ");
            return;
        }
 
        if(thread==null)
            return;
 
        Thread.sleep(15000);
        thread.interrupt();
        thread.join();
    }
    void setListener( WorkerListener w) {
        workerListener = w;
    }
    boolean isStarted() {
        return isStarted;
        
    }
    boolean isWorking(){
        return isWorking;
        
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}
