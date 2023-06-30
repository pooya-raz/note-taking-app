package org.maikini;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        final var socketAddress = new InetSocketAddress("localhost", 8000);
        final var server = HttpServer.create(socketAddress, 0);
        server.start();
        System.out.println("Hello world");
    }
}
