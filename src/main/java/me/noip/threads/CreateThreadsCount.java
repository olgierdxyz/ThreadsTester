package me.noip.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateThreadsCount {

    public static int SLEEP;

    public static void main(String[] args) {
        SLEEP = Integer.parseInt(args[0]);
        for (int i = 1; i <= Integer.parseInt(args[1]); i++) {
            System.out.println("Let's create a new thread [" + i + "]...");
            Hello thread = new Hello();
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CreateThreadsCount.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Active threads in the current thread group:" + Thread.activeCount());
    }

}

class Hello extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Thread with threadId " + this.getId() + " has been created.");
            Thread.sleep(CreateThreadsCount.SLEEP * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CreateThreadsCount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("Thread with threadId " + this.getId() + " has been terminated.");
        }
    }
}
