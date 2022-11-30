import java.io.IOException;
import java.io.InputStream;

public class Ping {
    public static void main(String[] args) {

        if (args.length != 1 || args[0].length() < 1) {
            System.err.println("Se require de una dirección para hacer ping.");
            System.exit(-1);
        }

        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "ping", args[0]);

        Process p;

        try {

            p = pb.start();

            InputStream is = p.getInputStream();
            int c = 0;
            is = p.getInputStream();
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }

            is.close();
            p.destroy();

        } catch (

        IOException e) {
            e.printStackTrace();
        }

    }

}
