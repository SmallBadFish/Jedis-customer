package com.yin.project.jedis;


import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

public class ConnectionTest {

    @Test
    public void connect() throws IOException {
        Connection connection = new Connection("172.16.100.36", 6379);
        connection.connect();
        Socket socket = connection.getSocket();
        assert socket != null;
        socket.close();
    }
}