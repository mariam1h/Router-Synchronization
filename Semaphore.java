public class Semaphore {
    protected int value = 0;

    protected Semaphore() {
        value = 0;
    }

    protected Semaphore(int initial) {
        value = initial;
    }

    public synchronized boolean P() {
        /*
          process is entering a critical section
          If the semaphore value is greater than or equal to 0, the process can proceed
        */
        value--;
        if (value < 0)
            try {
                wait();
                return false;
            } catch (InterruptedException e) {

            }
        return true;
    }

    public synchronized void V() {
        /*
         called when a process exits a critical section

         */
        value++;
        if (value <= 0)
            notify();
    }
}
