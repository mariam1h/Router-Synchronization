import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        int N;
        int TC;
        ArrayList<Device> TC_lines = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("What is the number of WI-FI Connections?");
        N = input.nextInt();
        System.out.println("What is the number of devices Clients want to connect?");
        TC = input.nextInt();

        Router router = new Router(N,TC);

        for (int i = 0; i < TC; i++) {
            String name , type;
            name = input.next();
            type = input.next();
            Device device = new Device(name,type);
            TC_lines.add(device);
        }

    }
}
