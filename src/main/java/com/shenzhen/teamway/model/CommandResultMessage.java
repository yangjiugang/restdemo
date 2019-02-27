package com.shenzhen.teamway.model;

import java.io.Serializable;

/**
 * 封装报文执行结果
 * 
 * @author gaven
 * @date 2019/02/27
 */
public class CommandResultMessage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7439948849823696122L;

    private boolean result; // 命令执行成功或者失败
    private String message; // 命令返回消息体

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + (this.result ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CommandResultMessage other = (CommandResultMessage)obj;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (result != other.result)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CommandResultMessage [result=" + result + ", message=" + message + "]";
    }

}
