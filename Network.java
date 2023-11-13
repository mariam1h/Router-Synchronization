import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

    public class Network {

        public static void main(String[] args) throws InterruptedException {
            int N;
            int TC;
            ArrayList<Device> TC_lines = new ArrayList<>();
            Scanner input = new Scanner(System.in);

            System.out.println("What is the number of WI-FI Connections?");
            N = input.nextInt();
            System.out.println("What is the number of devices Clients want to connect?");
            TC = input.nextInt();

            Router router = new Router(N);

            // Redirect System.out to a file
            try (PrintStream fileStream = new PrintStream(new FileOutputStream("output.txt"))) {
                System.setOut(fileStream);

                for (int i = 0; i < TC; i++) {
                    String name, type;
                    name = input.next();
                    type = input.next();
                    Device device = new Device(name, type, router);
                    TC_lines.add(device);
                }

                for (Device device : TC_lines) {
                    device.start();
                }

                try {
                    for (Device device : TC_lines) {
                        device.join();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Join interrupted");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Reset System.out to the console
                System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
            }
        }
    }
