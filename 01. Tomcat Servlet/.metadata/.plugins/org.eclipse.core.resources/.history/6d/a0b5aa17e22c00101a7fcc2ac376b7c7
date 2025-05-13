import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/headers", new HeaderHandler());
        server.createContext("/query", new QueryHandler());
        server.createContext("/body", new BodyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started at http://localhost:8081/");
    }

    static class RootHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1>Hello from Java HttpServer!</h1>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class HeaderHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder response = new StringBuilder("<pre>");
            for (Map.Entry<String, List<String>> entry : exchange.getRequestHeaders().entrySet()) {
                response.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            response.append("</pre>");
            byte[] bytes = response.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    static class QueryHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            URI requestURI = exchange.getRequestURI();
            String query = requestURI.getQuery();
            String response = "<h2>Query Parameters:</h2><p>" + query + "</p>";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class BodyHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                InputStream is = exchange.getRequestBody();
                StringBuilder body = new StringBuilder();
                int i;
                while ((i = is.read()) != -1) {
                    body.append((char) i);
                }
                String response = "Received POST body:\n" + body;
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                String msg = "Please send a POST request to use this endpoint.";
                exchange.sendResponseHeaders(405, msg.length());
                OutputStream os = exchange.getResponseBody();
                os.write(msg.getBytes());
                os.close();
            }
        }
    }
}
