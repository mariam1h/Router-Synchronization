import java.util.ArrayList;
import java.util.List;

public class Router {
    List<Device> connections;
    Semaphore spaces ;
    Semaphore devices;

    public Router(int s , int p){
        spaces = new Semaphore(s);
        devices = new Semaphore(p);
    }
    public void OccupyConnection(Device device){
        boolean flag = spaces.P();
        if (flag){
            System.out.println("("+device.name+") "+"("+device.type+") arrived");
        }
        else {
            System.out.println("("+device.name+") "+"("+device.type+") arrived and waiting");
        }

        connections.add(device);
        devices.V();
    }
    public void realseConnection(){

    }
}
