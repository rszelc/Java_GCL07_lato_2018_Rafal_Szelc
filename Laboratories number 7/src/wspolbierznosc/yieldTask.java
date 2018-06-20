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
public class yieldTask implements Task{
    @Override
    public void run(int taskNumber) throws InterruptedException {
        for(int i=10;i>0;i--)
        {
            System.out.println(i);
            Thread.yield();
            Thread.sleep(1000);
            
        }
    }
    
}
