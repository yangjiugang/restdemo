package com.shenzhen.teamway.controller;

import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.soap.SOAPException;

import org.onvif.ver10.schema.PTZPreset;
import org.onvif.ver10.schema.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shenzhen.teamway.model.CommandResultMessage;
import com.shenzhen.teamway.model.GetMediaProfileMessageRequest;
import com.shenzhen.teamway.model.GetMediaProfileMessageResponse;
import com.shenzhen.teamway.model.GetMediaUrlMessageRequest;
import com.shenzhen.teamway.model.GetMediaUrlMessageResponse;
import com.shenzhen.teamway.model.GetPresetsMessageRequest;
import com.shenzhen.teamway.model.GetPresetsMessageResponse;
import com.shenzhen.teamway.model.GetPtzUrlMessageRequest;
import com.shenzhen.teamway.model.GotoPresetMessageRequest;
import com.shenzhen.teamway.model.RebootMessageRequest;
import com.shenzhen.teamway.model.SetPrestMessageRequest;
import com.shenzhen.teamway.model.GetPtzUrlMessageResponse;
import com.shenzhen.teamway.model.response.GetMediaProfileResponseBody;
import com.shenzhen.teamway.model.response.GetMediaUrlResponseBody;
import com.shenzhen.teamway.model.response.GetPresetsResponseBody;
import com.shenzhen.teamway.model.response.GetPtzUrlResponseBody;
import com.shenzhen.teamway.model.response.PresetInfo;
import com.shenzhen.teamway.webservice.MyUrlOnvifDevice;

import de.onvif.soap.OnvifDevice;
import de.onvif.soap.devices.PtzDevices;

/**
 * @author : Gaven
 * @version V1.0
 * @Project: restdemo
 * @Package com.shenzhen.teamway.controller
 * @Description:预置位接口控制类
 * @date Date : 2019年02月22日 18:41
 */
@Controller
public class PresetsController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取预置位列表
     * @param getPresetsMessageRequest
     * @return
     */
    @RequestMapping(value = "/getPresets", method = RequestMethod.POST)
    public @ResponseBody GetPresetsMessageResponse getPresets(@RequestBody GetPresetsMessageRequest getPresetsMessageRequest) {
        
        logger.info("-------------begin GetPresetsMessageResponse ,method param:{}--------------------", getPresetsMessageRequest);
        GetPresetsMessageResponse getPresetsMessageResponse = new GetPresetsMessageResponse();
        CommandResultMessage resultMessage = new CommandResultMessage();
        
        try {
            String ip = getPresetsMessageRequest.getAddress().concat(":").concat(getPresetsMessageRequest.getPort());
            String userName = getPresetsMessageRequest.getUser();
            String password = getPresetsMessageRequest.getPassword();
            // 获取连接
            OnvifDevice nvt = new OnvifDevice(ip, userName, password);
            Date nvtDate = nvt.getDevices().getDate();
            logger.info("当前设备的系统时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nvtDate));

            // 获取初始化基本功能
            nvt.getDevices();// 获取配置和信息的基本方法
            nvt.getMedia();// 获取流或屏幕截图URI等媒体配置
            nvt.getImaging();// 初始化获取头像设置服务
            nvt.getPtz();// 初始化移动设备功能

            // 获取快照URI
            List<Profile> profiles = nvt.getDevices().getProfiles();
            String profileToken = profiles.get(0).getToken();
            logger.info("Snapshot URI：" + nvt.getMedia().getSnapshotUri(profileToken));

            // 操作摄像头
            /*
             *先连接上onvif 再获取摄像机的token 
             */
            List<Profile> profile = nvt.getDevices().getProfiles();
            String token = profile.get(0).getToken();
            PtzDevices ptzDevices = nvt.getPtz(); // 获取PTZ设备
            List<PTZPreset> list = ptzDevices.getPresets(token);// 获取预置位信息

            // 包装预置位信息并返回
            List<PresetInfo> infoList = new ArrayList<PresetInfo>();
            for (int i = 0; i < list.size(); i++) {
                PresetInfo presetInfo = new PresetInfo();
                presetInfo.setToken(list.get(i).getToken());
                presetInfo.setName(list.get(i).getName());
                infoList.add(presetInfo);
            }
            // 封装预置位返回消息体实体
            GetPresetsResponseBody getPresetsResponseBody = new GetPresetsResponseBody();
            getPresetsResponseBody.setPresetsNumber(list.size()); // todo;
            getPresetsResponseBody.setPresets(infoList);

            // 封装返回消息内容
            getPresetsMessageResponse.setCommand(getPresetsMessageRequest.getCommand());
            getPresetsMessageResponse.setAddress(getPresetsMessageRequest.getAddress());
            getPresetsMessageResponse.setPort(getPresetsMessageRequest.getPort());
            getPresetsMessageResponse.setUser(getPresetsMessageRequest.getUser());
            getPresetsMessageResponse.setPassword(getPresetsMessageRequest.getPassword());
            getPresetsMessageResponse.setVersion(getPresetsMessageRequest.getVersion());
            getPresetsMessageResponse.setUuid(getPresetsMessageRequest.getUuid());
            getPresetsMessageResponse.setGetPresetsResp(getPresetsResponseBody);

            // 封装返回结果
            resultMessage.setResult(true);
            resultMessage.setMessage("操作成功");
            getPresetsMessageResponse.setCommandResp(resultMessage);

        } catch (ConnectException e) {
            logger.info("无法连接到nvt");
            resultMessage.setResult(false);
            resultMessage.setMessage("无法连接到nvt");
            getPresetsMessageResponse.setCommandResp(resultMessage);
        } catch (SOAPException e) {
            logger.info("设备出现故障");
            resultMessage.setResult(false);
            resultMessage.setMessage("设备出现故障");
            getPresetsMessageResponse.setCommandResp(resultMessage);
            e.printStackTrace();
        }
        logger.info("-------------end GetPresetsMessageResponse --------------------");
        return getPresetsMessageResponse;
    }

    /**
     * 设置预置位信息
     * @param prestMessageRequest
     * @return
     */
    @RequestMapping(value = "/setPreset", method = RequestMethod.POST)
    public @ResponseBody CommandResultMessage setPreset(@RequestBody SetPrestMessageRequest prestMessageRequest) {
        logger.info("-------------begin setPreset ,method param:{}--------------------",prestMessageRequest);
        CommandResultMessage resultMessage = new CommandResultMessage();
        try {
            String ip = prestMessageRequest.getAddress().concat(":").concat(prestMessageRequest.getPort());
            String userName = prestMessageRequest.getUser();
            String password = prestMessageRequest.getPassword();
            // 获取连接
            OnvifDevice nvt = new OnvifDevice(ip, userName, password);
            //获取profile 并获得token
            List<Profile> profile = nvt.getDevices().getProfiles();
            String token = profile.get(0).getToken();
            PtzDevices ptzDevices = nvt.getPtz(); // 获取PTZ设备
            ptzDevices.setPreset(prestMessageRequest.getSetPreset().getName(), prestMessageRequest.getSetPreset().getToken(), token);
            resultMessage.setResult(true);
            resultMessage.setMessage("设置成功");
        } catch (ConnectException e) {
            logger.info("无法连接到nvt");
            resultMessage.setResult(false);
            resultMessage.setMessage("无法连接到nvt");
        } catch (SOAPException e) {
            logger.info("设备出现故障");
            resultMessage.setResult(false);
            resultMessage.setMessage("设备出现故障");
            e.printStackTrace();
        }
        logger.info("-------------end setPreset --------------------");
        return resultMessage;
    }
    
    /**
     * 调用预置位
     * @param gotoPresetMessageRequest
     * @return
     */
    @RequestMapping(value = "/gotoPreset", method = RequestMethod.POST)
    public @ResponseBody CommandResultMessage gotoPreset(@RequestBody GotoPresetMessageRequest gotoPresetMessageRequest) {
        logger.info("-------------begin gotoPreset ,method param:{}--------------------",gotoPresetMessageRequest);
        CommandResultMessage resultMessage = new CommandResultMessage();
        try {
            String ip = gotoPresetMessageRequest.getAddress().concat(":").concat(gotoPresetMessageRequest.getPort());
            String userName = gotoPresetMessageRequest.getUser();
            String password = gotoPresetMessageRequest.getPassword();
            // 获取连接
            OnvifDevice nvt = new OnvifDevice(ip, userName, password);
            //获取profile 并获得token
            List<Profile> profile = nvt.getDevices().getProfiles();
            String token = profile.get(0).getToken();
            PtzDevices ptzDevices = nvt.getPtz(); // 获取PTZ设备
            ptzDevices.gotoPreset(gotoPresetMessageRequest.getGotoPreset().getToken(), token);
            resultMessage.setResult(true);
            resultMessage.setMessage("操作成功");
        } catch (ConnectException e) {
            logger.info("无法连接到nvt");
            resultMessage.setResult(false);
            resultMessage.setMessage("无法连接到nvt");
        } catch (SOAPException e) {
            logger.info("设备出现故障");
            resultMessage.setResult(false);
            resultMessage.setMessage("设备出现故障");
            e.printStackTrace();
        }
        logger.info("-------------end gotoPreset --------------------");
        return resultMessage;
    }
    
    /**
     * 获取mediaUrl
     * 
     * @param getMediaUrlMessageRequest
     * @return
     */
    @RequestMapping(value = "/getMediaUrl", method = RequestMethod.POST)
    public @ResponseBody GetMediaUrlMessageResponse getMediaUrl(@RequestBody GetMediaUrlMessageRequest getMediaUrlMessageRequest) {
        logger.info("-------------begin getMediaUrl ,method param:{}--------------------",getMediaUrlMessageRequest);
        GetMediaUrlMessageResponse getMediaUrlMessageResponse = new GetMediaUrlMessageResponse();
        CommandResultMessage resultMessage = new CommandResultMessage();
        try {
            String ip = getMediaUrlMessageRequest.getAddress().concat(":").concat(getMediaUrlMessageRequest.getPort());
            String userName = getMediaUrlMessageRequest.getUser();
            String password = getMediaUrlMessageRequest.getPassword();
            // 获取连接
            MyUrlOnvifDevice myUrlOnvifDevice = new MyUrlOnvifDevice(ip, userName, password);
            String mediaUrl = myUrlOnvifDevice.getMediaUri();
            
            // 封装返回消息内容
            getMediaUrlMessageResponse.setCommand(getMediaUrlMessageRequest.getCommand());
            getMediaUrlMessageResponse.setAddress(getMediaUrlMessageRequest.getAddress());
            getMediaUrlMessageResponse.setPort(getMediaUrlMessageRequest.getPort());
            getMediaUrlMessageResponse.setUser(getMediaUrlMessageRequest.getUser());
            getMediaUrlMessageResponse.setPassword(getMediaUrlMessageRequest.getPassword());
            getMediaUrlMessageResponse.setVersion(getMediaUrlMessageRequest.getVersion());
            getMediaUrlMessageResponse.setUuid(getMediaUrlMessageRequest.getUuid());

            GetMediaUrlResponseBody getMediaUrlResponseBody = new GetMediaUrlResponseBody();
            getMediaUrlResponseBody.setMediaUrl(mediaUrl);
            getMediaUrlMessageResponse.setGetMediaUrlResp(getMediaUrlResponseBody);
            resultMessage.setResult(true);
            resultMessage.setMessage("操作成功");
            getMediaUrlMessageResponse.setCommandResultMessage(resultMessage);
        } catch (ConnectException e) {
            logger.info("无法连接到nvt");
            resultMessage.setResult(false);
            resultMessage.setMessage("无法连接到nvt");
            e.printStackTrace();
        } catch (SOAPException e) {
            logger.info("设备出现故障");
            resultMessage.setResult(false);
            resultMessage.setMessage("设备出现故障");
            e.printStackTrace();
        }
        logger.info("-------------end getMediaUrl --------------------");
        return getMediaUrlMessageResponse;
    }
    
    /**
     * 获取przUrl
     * @param getPtzUrlMessageRequest
     * @return
     */
    @RequestMapping(value = "/getPtzUrl", method = RequestMethod.POST)
    public @ResponseBody GetPtzUrlMessageResponse getPtzUrl(@RequestBody GetPtzUrlMessageRequest getPtzUrlMessageRequest) {
        logger.info("-------------begin getPtzUrl ,method param:{}--------------------",getPtzUrlMessageRequest);
        GetPtzUrlMessageResponse getPtzUrlMessageResponse = new GetPtzUrlMessageResponse();
        CommandResultMessage resultMessage = new CommandResultMessage();
        try {
            String ip = getPtzUrlMessageRequest.getAddress().concat(":").concat(getPtzUrlMessageRequest.getPort());
            String userName = getPtzUrlMessageRequest.getUser();
            String password = getPtzUrlMessageRequest.getPassword();
            // 获取连接
            MyUrlOnvifDevice myUrlOnvifDevice = new MyUrlOnvifDevice(ip, userName, password);
            String ptzUrl = myUrlOnvifDevice.getPtzUri();
            GetPtzUrlResponseBody getPtzUrlResponseBody = new GetPtzUrlResponseBody();
            getPtzUrlResponseBody.setPtzUrl(ptzUrl);
            
            // 封装返回消息内容
            getPtzUrlMessageResponse.setCommand(getPtzUrlMessageRequest.getCommand());
            getPtzUrlMessageResponse.setAddress(getPtzUrlMessageRequest.getAddress());
            getPtzUrlMessageResponse.setPort(getPtzUrlMessageRequest.getPort());
            getPtzUrlMessageResponse.setUser(getPtzUrlMessageRequest.getUser());
            getPtzUrlMessageResponse.setPassword(getPtzUrlMessageRequest.getPassword());
            getPtzUrlMessageResponse.setVersion(getPtzUrlMessageRequest.getVersion());
            getPtzUrlMessageResponse.setUuid(getPtzUrlMessageRequest.getUuid());
            getPtzUrlMessageResponse.setGetPtzUrlResp(getPtzUrlResponseBody);
            resultMessage.setResult(true);
            resultMessage.setMessage("操作成功");
            getPtzUrlMessageResponse.setCommandResp(resultMessage);
        } catch (ConnectException e) {
            logger.info("无法连接到nvt");
            resultMessage.setResult(false);
            resultMessage.setMessage("无法连接到nvt");
            e.printStackTrace();
        } catch (SOAPException e) {
            logger.info("设备出现故障");
            resultMessage.setResult(false);
            resultMessage.setMessage("设备出现故障");
            e.printStackTrace();
        }
        logger.info("-------------end getPtzUrl --------------------");
        return getPtzUrlMessageResponse;
    }
    
    /**
     * 获取Profile
     * @param getMediaProfileMessageRequest
     * @return
     */
    @RequestMapping(value = "/getMediaProfile", method = RequestMethod.POST)
    public @ResponseBody GetMediaProfileMessageResponse  getMediaProfile(@RequestBody GetMediaProfileMessageRequest getMediaProfileMessageRequest) {
        logger.info("-------------begin getMediaProfile ,method param:{}--------------------",getMediaProfileMessageRequest);
        GetMediaProfileMessageResponse getMediaProfileMessageResponse = new GetMediaProfileMessageResponse();
        CommandResultMessage resultMessage = new CommandResultMessage();
        try {
            String ip = getMediaProfileMessageRequest.getAddress().concat(":").concat(getMediaProfileMessageRequest.getPort());
            String userName = getMediaProfileMessageRequest.getUser();
            String password = getMediaProfileMessageRequest.getPassword();
            // 获取连接
            OnvifDevice nvt = new OnvifDevice(ip, userName, password);
            List<Profile> profile = nvt.getDevices().getProfiles();
            
            String profiles[] = new String[profile.size()];
            for (int i = 0; i < profile.size(); i++) {
                profiles[i] = profile.get(i).getName();
            }
            GetMediaProfileResponseBody getMediaProfileResponseBody = new GetMediaProfileResponseBody();
            getMediaProfileResponseBody.setProfileNumber(profile.size());
            getMediaProfileResponseBody.setProfiles(profiles);
            
            // 封装返回消息内容
            getMediaProfileMessageResponse.setCommand(getMediaProfileMessageRequest.getCommand());
            getMediaProfileMessageResponse.setAddress(getMediaProfileMessageRequest.getAddress());
            getMediaProfileMessageResponse.setPort(getMediaProfileMessageRequest.getPort());
            getMediaProfileMessageResponse.setUser(getMediaProfileMessageRequest.getUser());
            getMediaProfileMessageResponse.setPassword(getMediaProfileMessageRequest.getPassword());
            getMediaProfileMessageResponse.setVersion(getMediaProfileMessageRequest.getVersion());
            getMediaProfileMessageResponse.setUuid(getMediaProfileMessageRequest.getUuid());
            getMediaProfileMessageResponse.setGetMediaProfileResp(getMediaProfileResponseBody);
            resultMessage.setResult(true);
            resultMessage.setMessage("操作成功");
            getMediaProfileMessageResponse.setCommandResp(resultMessage);
            
        } catch (ConnectException e) {
            logger.info("无法连接到nvt");
            resultMessage.setResult(false);
            resultMessage.setMessage("无法连接到nvt");
            e.printStackTrace();
        } catch (SOAPException e) {
            logger.info("设备出现故障");
            resultMessage.setResult(false);
            resultMessage.setMessage("设备出现故障");
            e.printStackTrace();
        }
        logger.info("-------------end getMediaProfile --------------------");
        return getMediaProfileMessageResponse;
    }
    
    /**
     * 重启功能
     * @param rebootMessageRequest
     * @return
     */
    @RequestMapping(value = "/reboot", method = RequestMethod.POST)
    public @ResponseBody CommandResultMessage reboot(@RequestBody RebootMessageRequest rebootMessageRequest) {
        logger.info("-------------begin reboot ,method param:{}--------------------", rebootMessageRequest);
        CommandResultMessage resultMessage = new CommandResultMessage();
        try {
            String ip = rebootMessageRequest.getAddress().concat(":").concat(rebootMessageRequest.getPort());
            String userName = rebootMessageRequest.getUser();
            String password = rebootMessageRequest.getPassword();
            // 获取连接
            OnvifDevice nvt = new OnvifDevice(ip, userName, password);
            String msg = nvt.reboot();
            resultMessage.setResult(true);
            resultMessage.setMessage("返回消息" + msg);
        } catch (ConnectException e) {
            logger.info("无法连接到nvt");
            resultMessage.setResult(false);
            resultMessage.setMessage("无法连接到nvt");
            e.printStackTrace();
        } catch (SOAPException e) {
            logger.info("设备出现故障");
            resultMessage.setResult(false);
            resultMessage.setMessage("设备出现故障");
            e.printStackTrace();
        }
        logger.info("-------------end reboot --------------------");
        return resultMessage;
    }
}