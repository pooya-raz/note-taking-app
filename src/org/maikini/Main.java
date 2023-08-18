package org.maikini;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {
        final var logger = Logger.getLogger("NoteLogger");
        final var socketAddress = new InetSocketAddress("localhost", 8000);
        final var server = HttpServer.create(socketAddress, 0);
        server.start();
        logger.info("Server is up and running at: http:/" + server.getAddress());
    }

}
