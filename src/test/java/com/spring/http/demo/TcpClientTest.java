package com.spring.http.demo;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.spring.http.demo.tcpclient.TcpClient;

import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class TcpClientTest {

    @Test
    void tcpClientTest() throws IOException {
        TcpClient client = new TcpClient();
        client.startConnection("127.0.0.1", 12341);
        String response = client.sendMessage("hello server");
        log.info("TCP CLIENT - Received Response from Server : "+response);
        assertEquals("hello client", response);
    }
}
