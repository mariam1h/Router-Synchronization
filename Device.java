public class Device extends Thread {
    String name;
    String type;
    Router router;

    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

}
