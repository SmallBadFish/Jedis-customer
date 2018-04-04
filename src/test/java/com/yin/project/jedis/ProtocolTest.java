package com.yin.project.jedis;

import com.yin.project.jedis.util.RedisOutputStream;
import com.yin.project.jedis.util.SafeEncoder;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 */
public class ProtocolTest {

    @Test
    public void sendCommand() throws IOException {
        RedisOutputStream os = new RedisOutputStream(new ByteArrayOutputStream());
        Protocol.sendCommand(os, Protocol.Command.SET, SafeEncoder.encode("testkey"), SafeEncoder.encode("testvalue"));
        os.flush();
    }
}