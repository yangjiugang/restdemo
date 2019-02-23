package com.shenzhen.teamway.controller;

import com.shenzhen.teamway.model.GetPresetsMessageRequest;
import com.shenzhen.teamway.model.GetPresetsMessageResponse;
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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody GetPresetsMessageResponse getPresets(@RequestBody GetPresetsMessageRequest getPresetsMessageRequest) {
        return null;
    }
}