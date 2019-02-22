package com.shenzhen.teamway.model;

import java.io.Serializable;

/**
 * @author : Gaven
 * @version V1.0
 * @Project: restdemo
 * @Package com.shenzhen.teamway.model
 * @Description: 协议共用头文件
 * @date Date : 2019年02月22日 11:23
 */
public class HeadMessage implements Serializable {

    private static final long serialVersionUID = 7207766623587155312L;
    private String command;
    private String address;
    private String port;
    private String user;
    private String password;
    private Integer version;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        HeadMessage that = (HeadMessage)o;

        if (!command.equals(that.command))
            return false;
        if (!address.equals(that.address))
            return false;
        if (!port.equals(that.port))
            return false;
        if (!user.equals(that.user))
            return false;
        if (!password.equals(that.password))
            return false;
        return version.equals(that.version);
    }

    @Override public int hashCode() {
        int result = command.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + port.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }

    @Override public String toString() {
        return "HeadMessage{" + "command='" + command + '\'' + ", address='" + address + '\'' + ", port='" + port + '\''
            + ", user='" + user + '\'' + ", password='" + password + '\'' + '}';
    }
}