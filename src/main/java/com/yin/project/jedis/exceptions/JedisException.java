package com.yin.project.jedis.exceptions;

/**
 * 不知道该抛什么异常的时候抛这个
 *
 * @author Eason
 * @createTime 2018-04-04
 */
public class JedisException extends RuntimeException {
    private static final long serialVersionUID = -2946266495682282677L;

    public JedisException(String message) {
        super(message);
    }

    public JedisException(Throwable e) {
        super(e);
    }

    public JedisException(String message, Throwable cause) {
        super(message, cause);
    }
}
