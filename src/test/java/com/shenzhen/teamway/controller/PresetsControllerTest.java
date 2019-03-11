package com.shenzhen.teamway.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.shenzhen.teamway.model.GetMediaProfileMessageRequest;
import com.shenzhen.teamway.model.GetMediaUrlMessageRequest;
import com.shenzhen.teamway.model.GetPresetsMessageRequest;
import com.shenzhen.teamway.model.GetPtzUrlMessageRequest;
import com.shenzhen.teamway.model.GotoPresetMessageRequest;
import com.shenzhen.teamway.model.RebootMessageRequest;
import com.shenzhen.teamway.model.SetDateAndTimeMessageRequest;
import com.shenzhen.teamway.model.SetPrestMessageRequest;
import com.shenzhen.teamway.model.request.GetMediaProfileRequestBody;
import com.shenzhen.teamway.model.request.GetMediaUrlRequestBody;
import com.shenzhen.teamway.model.request.GetPresetsRequestBody;
import com.shenzhen.teamway.model.request.GetPtzUrlRequestBody;
import com.shenzhen.teamway.model.request.GotoPresetRequestBody;
import com.shenzhen.teamway.model.request.RebootRequestBody;
import com.shenzhen.teamway.model.request.SetDateAndTimeRequestBody;
import com.shenzhen.teamway.model.request.SetPresetRequestBody;
import com.shenzhen.teamway.model.response.GetMediaUrlResponseBody;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PresetsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPresets() throws UnsupportedEncodingException, Exception {
        GetPresetsMessageRequest getPresetsMessageRequest = new GetPresetsMessageRequest();
        getPresetsMessageRequest.setCommand("getPresets");
        getPresetsMessageRequest.setAddress("192.168.12.99");
        getPresetsMessageRequest.setPort("80");
        getPresetsMessageRequest.setUser("admin");
        getPresetsMessageRequest.setPassword("12345");
        getPresetsMessageRequest.setVersion(1);
        getPresetsMessageRequest.setUuid("000001");

        GetPresetsRequestBody getPresetsRequestBody = new GetPresetsRequestBody();
        getPresetsRequestBody.setPtzUrl("http://192.168.12.103:2000/onvif/PTZ");
        getPresetsRequestBody.setProfile("profile_1");
        getPresetsMessageRequest.setGetPresets(getPresetsRequestBody);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(getPresetsMessageRequest);

        String responseString = mockMvc
            .perform(MockMvcRequestBuilders.post("http://localhost:8081/getPresets")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            .andReturn().getResponse().getContentAsString();

        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    public void testSetPreset() throws UnsupportedEncodingException, Exception {
        SetPrestMessageRequest setPrestMessageRequest = new SetPrestMessageRequest();
        setPrestMessageRequest.setCommand("setPreset");
        setPrestMessageRequest.setAddress("192.168.12.99");
        setPrestMessageRequest.setPort("80");
        setPrestMessageRequest.setUser("admin");
        setPrestMessageRequest.setPassword("12345");
        setPrestMessageRequest.setVersion(1);
        setPrestMessageRequest.setUuid("000001");

        SetPresetRequestBody setPresetRequestBody = new SetPresetRequestBody();
        setPresetRequestBody.setPtzUrl("http://192.168.12.103:2000/onvif/PTZ");
        setPresetRequestBody.setProfile("profile_1");
        setPresetRequestBody.setToken("8");
        setPresetRequestBody.setName("preset1");
        setPrestMessageRequest.setSetPreset(setPresetRequestBody);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(setPrestMessageRequest);

        String responseString = mockMvc
            .perform(MockMvcRequestBuilders.post("http://localhost:8081/setPreset")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            .andReturn().getResponse().getContentAsString();

        System.out.println("-----返回的json = " + responseString);
    }
    
    @Test
    public void testGotoPreset() throws UnsupportedEncodingException, Exception {
        GotoPresetMessageRequest gotoPresetMessageRequest = new GotoPresetMessageRequest();
        gotoPresetMessageRequest.setCommand("gotoPreset");
        gotoPresetMessageRequest.setAddress("192.168.12.99");
        gotoPresetMessageRequest.setPort("80");
        gotoPresetMessageRequest.setUser("admin");
        gotoPresetMessageRequest.setPassword("12345");
        gotoPresetMessageRequest.setVersion(1);
        gotoPresetMessageRequest.setUuid("000001");

        GotoPresetRequestBody gotoPresetRequestBody = new GotoPresetRequestBody();
        gotoPresetRequestBody.setPtzUrl("http://192.168.12.103:2000/onvif/PTZ");
        gotoPresetRequestBody.setProfile("profile_1");
        gotoPresetRequestBody.setToken("1");
        gotoPresetMessageRequest.setGotoPreset(gotoPresetRequestBody);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(gotoPresetMessageRequest);

        String responseString = mockMvc
            .perform(MockMvcRequestBuilders.post("http://localhost:8081/gotoPreset")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            .andReturn().getResponse().getContentAsString();

        System.out.println("-----返回的json = " + responseString);
    }
    
    @Test
    public void testGetMediaUrl() throws UnsupportedEncodingException, Exception {
        GetMediaUrlMessageRequest getMediaUrlMessageRequest = new GetMediaUrlMessageRequest();
        getMediaUrlMessageRequest.setCommand("getMediaUrl");
        getMediaUrlMessageRequest.setAddress("192.168.12.99");
        getMediaUrlMessageRequest.setPort("80");
        getMediaUrlMessageRequest.setUser("admin");
        getMediaUrlMessageRequest.setPassword("12345");
        getMediaUrlMessageRequest.setVersion(1);
        getMediaUrlMessageRequest.setUuid("000001");

//        GetMediaUrlRequestBody getMediaUrlRequestBody = new GetMediaUrlRequestBody();
//        getMediaUrlMessageRequest.setGetMediaUrl(getMediaUrlRequestBody);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(getMediaUrlMessageRequest);

        String responseString = mockMvc
            .perform(MockMvcRequestBuilders.post("http://localhost:8081/getMediaUrl")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            .andReturn().getResponse().getContentAsString();

        System.out.println("-----返回的json = " + responseString);
    }
    
    @Test
    public void testGetPtzUrl() throws UnsupportedEncodingException, Exception {
        GetPtzUrlMessageRequest getPtzUrlMessageRequest = new GetPtzUrlMessageRequest();
        getPtzUrlMessageRequest.setCommand("getPtzUrl");
        getPtzUrlMessageRequest.setAddress("192.168.12.99");
        getPtzUrlMessageRequest.setPort("80");
        getPtzUrlMessageRequest.setUser("admin");
        getPtzUrlMessageRequest.setPassword("12345");
        getPtzUrlMessageRequest.setVersion(1);
        getPtzUrlMessageRequest.setUuid("000001");

//        GetPtzUrlRequestBody getPtzUrlRequestBody = new GetPtzUrlRequestBody();
//        getPtzUrlMessageRequest.setGetPtzUrl(getPtzUrlRequestBody);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(getPtzUrlMessageRequest);

        String responseString = mockMvc
            .perform(MockMvcRequestBuilders.post("http://localhost:8081/getPtzUrl")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            .andReturn().getResponse().getContentAsString();

        System.out.println("-----返回的json = " + responseString);
    }
    
    @Test
    public void testGetMediaProfile() throws UnsupportedEncodingException, Exception {
        GetMediaProfileMessageRequest getMediaProfileMessageRequest = new GetMediaProfileMessageRequest();
        getMediaProfileMessageRequest.setCommand("getMediaProfile");
        getMediaProfileMessageRequest.setAddress("192.168.12.99");
        getMediaProfileMessageRequest.setPort("80");
        getMediaProfileMessageRequest.setUser("admin");
        getMediaProfileMessageRequest.setPassword("12345");
        getMediaProfileMessageRequest.setVersion(1);
        getMediaProfileMessageRequest.setUuid("000001");

//        GetMediaProfileRequestBody getMediaProfileRequestBody = new  GetMediaProfileRequestBody();
//        getMediaProfileMessageRequest.setGetMediaProfile(getMediaProfileRequestBody);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(getMediaProfileMessageRequest);

        String responseString = mockMvc
            .perform(MockMvcRequestBuilders.post("http://localhost:8081/getMediaProfile")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            .andReturn().getResponse().getContentAsString();

        System.out.println("-----返回的json = " + responseString);
    }
    
    @Test
    public void testReboot() throws UnsupportedEncodingException, Exception {
        RebootMessageRequest rebootMessageRequest = new RebootMessageRequest();
        rebootMessageRequest.setCommand("reboot");
        rebootMessageRequest.setAddress("192.168.12.99");
        rebootMessageRequest.setPort("80");
        rebootMessageRequest.setUser("admin");
        rebootMessageRequest.setPassword("12345");
        rebootMessageRequest.setVersion(1);
        rebootMessageRequest.setUuid("000001");

//        RebootRequestBody rebootRequestBody = new  RebootRequestBody();
//        rebootMessageRequest.setReboot(rebootRequestBody);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(rebootMessageRequest);

        String responseString = mockMvc
            .perform(MockMvcRequestBuilders.post("http://localhost:8081/getMediaProfile")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            .andReturn().getResponse().getContentAsString();

        System.out.println("-----返回的json = " + responseString);
    }
    
    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        
        SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        System.out.println("现在时间："+simdf.format(calendar.getTime()));
        
        System.out.println(calendar.get(calendar.YEAR));
        System.out.println(calendar.get(calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        
        System.out.println(calendar.get(calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(calendar.MINUTE));
        System.out.println(calendar.get(calendar.SECOND));
        
    }
    
    @Test
    public void testSetDateAndTime() throws UnsupportedEncodingException, Exception {
        SetDateAndTimeMessageRequest setDateAndTimeMessageRequest = new SetDateAndTimeMessageRequest();
        setDateAndTimeMessageRequest.setCommand("setDateAndTime");
        setDateAndTimeMessageRequest.setAddress("192.168.12.99");
        setDateAndTimeMessageRequest.setPort("80");
        setDateAndTimeMessageRequest.setUser("admin");
        setDateAndTimeMessageRequest.setPassword("12345");
        setDateAndTimeMessageRequest.setVersion(1);
        setDateAndTimeMessageRequest.setUuid("000001");
        
        SetDateAndTimeRequestBody SetDateAndTimeRequestBody = new SetDateAndTimeRequestBody();
        SetDateAndTimeRequestBody.setDateTime("2009-11-09 18:07:20");
        SetDateAndTimeRequestBody.setTimeZone("CST-8");
        setDateAndTimeMessageRequest.setSetDateAndTime(SetDateAndTimeRequestBody);
//        RebootRequestBody rebootRequestBody = new  RebootRequestBody();
//        rebootMessageRequest.setReboot(rebootRequestBody);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(setDateAndTimeMessageRequest);

        String responseString = mockMvc
            .perform(MockMvcRequestBuilders.post("http://localhost:8081/setDateAndTime")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
            .andDo(print())
            .andReturn().getResponse().getContentAsString();

        System.out.println("-----返回的json = " + responseString);
    }
    
}
