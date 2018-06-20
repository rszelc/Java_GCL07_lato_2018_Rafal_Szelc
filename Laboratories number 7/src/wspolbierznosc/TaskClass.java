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
public class TaskClass implements Task{

    @Override
    public void run(int taskNumber) throws InterruptedException {
        Thread.sleep(10000);
    }
    
}
