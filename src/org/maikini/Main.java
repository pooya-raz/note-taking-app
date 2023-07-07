package org.maikini;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import static java.lang.System.Logger.Level.INFO;

public class Main {

    public static void main(String[] args) throws IOException {
        final var log = System.getLogger("NoteLogger");

        final var socketAddress = new InetSocketAddress("localhost", 8000);
        final var server = HttpServer.create(socketAddress, 0);
        server.start();
        log.log(INFO, "Server is up and running at: http:/" + server.getAddress());
    }
}
