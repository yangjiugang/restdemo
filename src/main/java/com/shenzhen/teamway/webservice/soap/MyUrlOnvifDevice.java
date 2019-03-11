package com.shenzhen.teamway.webservice.soap;

import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.soap.SOAPException;

import de.onvif.soap.OnvifDevice;

/**
 * 重写包装OnvifDevice 中的获得url方法
 * 
 * @author gaven
 * @date 2019/03/05
 */
public class MyUrlOnvifDevice extends OnvifDevice {

    public MyUrlOnvifDevice(String hostIp) throws ConnectException, SOAPException {
        super(hostIp);
    }

    public MyUrlOnvifDevice(String hostIp, String user, String password) throws ConnectException, SOAPException {
        super(hostIp, user, password);
    }

    @Override
    public String getEventsUri() {
        return super.getEventsUri();
    }

    @Override
    public String getPtzUri() {
        return super.getPtzUri();
    }

    @Override
    public String getMediaUri() {
        return super.getMediaUri();
    }

    @Override
    public String getImagingUri() {
        return super.getImagingUri();
    }

    public static void main(String[] args) throws ConnectException, SOAPException {
        MyUrlOnvifDevice myUrlOnvifDevice = new MyUrlOnvifDevice("192.168.12.99", "admin", "12345");
        Date nvtDate = myUrlOnvifDevice.getDevices().getDate();
        System.out.println("当前设备的系统时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nvtDate));
        System.out.println("当前设备获取的mediauri为：" + myUrlOnvifDevice.getMediaUri());
        System.out.println("当前设备获取的mediauri为：" + myUrlOnvifDevice.getDeviceUri());
    }

}
