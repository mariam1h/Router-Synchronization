@SuppressWarnings("CallToPrintStackTrace")
class Semaphore {
    protected int value = 0;

    protected Semaphore() {
        value = 0;
    }

    protected Semaphore(int initial) {
        value = initial;
    }

    // This method acquires a permit (decrement the max size).
    // There is a working device now on router
    // from 2 (MAX) to 1 (one place is free)
    //`synchronized` : ensuring that only one thread can execute this method at a time
    public synchronized void P(Device device) {
        value--;
        if (value < 0) {
            try {
                System.out.println("(" + device.name + ") (" + device.getType() + ") arrived and waiting");
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        else{
            System.out.println("(" + device.name + ") " + "(" + device.getType() + ") arrived");
        }
    }

    // This method releases a permit (increment the max size).
    public synchronized void V(Device device, int connection) {
        System.out.println("Connection " + connection + ": (" + device.name + ")" + " logged out");
        value++;
        if (value <= 0) notify();
    }
}