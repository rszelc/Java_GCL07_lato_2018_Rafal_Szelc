/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspolbierznosc;

/**
 *
 * @author rszelc
 */
public class Task100 implements Task{

    @Override
    public void run(int taskNumber) throws InterruptedException {
       int suma=0;
       long t1 =System.currentTimeMillis();
       for(int i =1000000;i>0;i--){
           for(int j=1000000;j>0;j--){
               for(int z=1000000;z>0;z--){
                   if(t1+10000<System.currentTimeMillis())
                       break;
                   suma+=Math.pow(Math.pow(i, j), z);
               }
               if(t1+10000<System.currentTimeMillis())
                       break;
           }
           if(t1+10000<System.currentTimeMillis())
                       break;
        }
       Thread.sleep(10000);
    }
    
}
