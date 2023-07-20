package org.maikini;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import static java.lang.System.Logger.Level.INFO;

public class Main {

    public static void main(String[] args) throws IOException {
        final var logger = System.getLogger("NoteLogger");
        final var socketAddress = new InetSocketAddress("localhost", 8000);
        final var server = HttpServer.create(socketAddress, 0);
        server.start();
        final var bob = new Handler();
        server.createContext("/", bob);
        logger.log(INFO, "Server is up and running at: http:/" + server.getAddress());
    }
}

class Handler implements HttpHandler {
    System.Logger logger = System.getLogger(Handler.class.getName());

    public void handle(HttpExchange exchange) {
        logger.log(INFO, "The request method is: " + exchange.getRequestMethod());
        logger.log(INFO, "Bob is handling the exchange");
    }
}
