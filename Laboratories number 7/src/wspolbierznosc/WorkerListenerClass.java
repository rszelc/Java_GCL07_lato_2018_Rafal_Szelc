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
public class WorkerListenerClass implements WorkerListener {

            @Override
            public void onWorkerStarted() {
                System.out.println("Worker started");
            }
 
            @Override
            public void onWorkerStoped() {
                System.out.println("Worker stoped");
            }
 
            @Override
            public void onTaskStarted(int taskNumber, String taskName) {
                System.out.println("Start of task number " + taskNumber +" - "+ taskName);
            }
 
            @Override
            public void onTaskCompleted(int taskNumber, String taskName) {
                System.out.println("End of task number: " + taskNumber +" - "+ taskName);
            }
    
}
