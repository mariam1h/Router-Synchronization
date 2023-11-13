import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ClassEscapesDefinedScope")
//public class Router {
//    private Semaphore spaces;
//    private final Map<Device, Integer> connections; // Map of Device to Connection ID
//    public int connectionCtr = 0;
//
//    public Router(int max) {
//        this.spaces = new Semaphore(max);
//        this.connections = new HashMap<>(max);
//    }
//
//    public int getConnectionId(Device device){
//        return connections.get(device);
//    }
//
//    public void occupyConnection(Device device) throws InterruptedException {
//        spaces.P();
//        connectionCtr++;
//        connections.put(device, connectionCtr);
//    }
//
//    public void connect(Device device){
//        System.out.println("(" + device.name + ")(" + device.type + ") arrived");
//    }
//
//    public void releaseConnection(Device device){
//        spaces.V();
//        connectionCtr--;
//        connections.remove(device);
//    }
//}

public class Router {
    ArrayList<Device> connections;
    Semaphore sem;

    public Router(int maxConnections) {
        connections = new ArrayList<>();
        for (int i = 0; i < maxConnections; i++) {
            connections.add(null);
        }
        sem = new Semaphore(maxConnections);
    }

    public synchronized int connect(Device device) {
        sem.P(device);
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i) == null) {
                connections.set(i, device);
                return i + 1;
            }
        }
        return -1;
    }

    public void disconnect(Device device) {
        int idx = connections.indexOf(device);
        connections.set(idx, null);
        sem.V(device, idx + 1);
    }
}


