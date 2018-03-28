package com.yin.project.jedis;

import com.yin.project.jedis.exceptions.JedisConnectionException;
import com.yin.project.jedis.util.RedisInputStream;
import com.yin.project.jedis.util.RedisOutputStream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Eason
 * @create 2018-03-28 14:47
 **/
public class Connection implements Cloneable {
//
    /**
     * 与Redis建立Scoket通信
     */
    private Socket socket;
    private String host = "localhost";
    private int port = 6379;
    private int connectionTimeout = 2000;
    private int soTimeout = 2000;
    private RedisOutputStream outputStream;
    private RedisInputStream inputStream;

    public Connection() {
    }

    public Connection(final String host) {
        this.host = host;
    }

    public Connection(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 连接方法
     */
    public void connect() {
        try {
            socket = new Socket();
            socket.setReuseAddress(true);
            socket.setKeepAlive(true);
            socket.setTcpNoDelay(true);
            socket.setSoLinger(true, 0);
            socket.connect(new InetSocketAddress(host, port), connectionTimeout);
            socket.setSoTimeout(soTimeout);
            outputStream = new RedisOutputStream(socket.getOutputStream());
            inputStream = new RedisInputStream(socket.getInputStream());
        } catch (IOException ex) {
            throw new JedisConnectionException(ex);
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
