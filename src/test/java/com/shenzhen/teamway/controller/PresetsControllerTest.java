package com.shenzhen.teamway.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.UnsupportedEncodingException;

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
import com.shenzhen.teamway.model.GetPresetsMessageRequest;
import com.shenzhen.teamway.model.request.GetPresetsRequestBody;

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

        System.out.println("Not yet implemented");
    }

}
