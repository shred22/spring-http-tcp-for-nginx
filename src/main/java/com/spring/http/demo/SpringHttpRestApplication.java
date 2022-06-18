package com.spring.http.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringHttpRestApplication {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) throws IOException {

        SpringApplication.run(SpringHttpRestApplication.class, args);
        log.info("HTTP Server started . . .");
        log.info("starting TCP server now . . . ");

        new SpringHttpRestApplication().start(6666);
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            clientSocket = serverSocket.accept();
            log.info("Established Connection with Client : " + clientSocket.getLocalAddress().getHostAddress());
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
                log.info("Sending Response to client");
                out.println("hello client");
            } else if("close".equals(greeting)) {
				log.info("Closing Connection");
				out.println("Closing Connection");
				stop();
				break;
			}
			else {
                log.info("Sending Response to unrecognised client request ");
                out.println("unrecognised greeting");
            }
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
