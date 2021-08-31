package me.noip.threads;

public class CreateThreadsCount {

    public static int SLEEP;

    public static void main(String[] args) {
        SLEEP = Integer.parseInt(args[0]);
        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            Hello thread = new Hello();
            thread.start();
            System.out.println("A new thread has been started [" + i + "].");
        }
        System.out.println("Active threads in the current thread's group:" + Thread.activeCount());
    }

}

class Hello extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("The thread has been created.");
            Thread.sleep(CreateThreadsCount.SLEEP * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("The thread has been terminated.");
        }
    }
}
