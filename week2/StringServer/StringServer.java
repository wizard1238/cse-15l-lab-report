import java.io.IOException;
import java.net.URI;
import java.util.HashSet;

class Handler implements URLHandler {
    String message = "";

    public String handleRequest(URI url) {
        try {
            if (url.getPath().equals("/add-message")) {
                String query = getQuery(url);
                message += query + "\n";
                return message;
            } else {
              return "404 Not Found";
            }
        } catch(Exception e) {
            return "400 Bad Request";
        }
    }

    private String getQuery(URI url) {
        String[] parameters = url.getQuery().split("=");
        if (parameters[0].equals("s")) {
            if (parameters.length < 2) {
                throw new IllegalArgumentException("Invalid query");
            }
            return parameters[1];
        }

        throw new IllegalArgumentException("Invalid query");
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}