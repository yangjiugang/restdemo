package com.shenzhen.teamway.controller;

import com.shenzhen.teamway.model.CommandResultMessage;
import com.shenzhen.teamway.model.GetPresetsMessageRequest;
import com.shenzhen.teamway.model.GetPresetsMessageResponse;
import com.shenzhen.teamway.model.response.GetPresetsResponseBody;
import com.shenzhen.teamway.model.response.PresetInfo;

import de.onvif.soap.OnvifDevice;
import de.onvif.soap.devices.PtzDevices;

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

    @RequestMapping(value = "/getPresets", method = RequestMethod.POST)
    public @ResponseBody GetPresetsMessageResponse getPresets(@RequestBody GetPresetsMessageRequest getPresetsMessageRequest) {
        logger.info("-------------begin GetPresetsMessageResponse ,method param:{}--------------------",  getPresetsMessageRequest);
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
            String Token = profile.get(0).getToken();
            PtzDevices ptzDevices = nvt.getPtz(); // 获取PTZ设备
            List<PTZPreset> list = ptzDevices.getPresets(Token);// 获取预置位信息

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
            getPresetsResponseBody.setPresetsNumber(list.size()); //todo;
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
            
            //封装返回结果
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
    
    
}