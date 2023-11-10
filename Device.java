public class Device extends Thread {
    public String name;
    public String type;


    public Device(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void run() {
        connect();
        try {
            wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PerformOnlineActivity();
        try {
            wait(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LogOut();
    }

    public void connect(){
        System.out.println("Connect");
    }
    public void PerformOnlineActivity(){
        System.out.println("Perform online activity");
    }
    public void LogOut(){
        System.out.println("Log out");
    }

}
