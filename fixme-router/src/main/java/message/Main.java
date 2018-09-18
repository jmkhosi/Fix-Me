package message;


public class Main {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int[] ports = {5000, 5001};

        for (int port : ports) {
            Thread thread =  new Thread(new Router("localhost", port));
           thread.start();
           thread.join();
        }

    }
}





