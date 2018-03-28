/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.threads_;

/**
 *
 * @author Adrian
 */
public abstract class Threads_main_class implements Runnable {
        protected Thread t;
        protected String threadName;
        protected volatile boolean running=true;
        
        public void terminate() {
            running = false;
        }  
        
        //@Override
        //abstract public void run();
        
        public void start () {
            System.out.println("Starting " +  threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }        
}
