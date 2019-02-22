package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.response.GetPresetsResponseBody;

/**
 * @author : Gaven
 * @version V1.0
 * @Project: restdemo
 * @Package com.shenzhen.teamway.model
 * @Description: 封装获取预置位信息响应报文
 * @date Date : 2019年02月22日 15:06
 */
public class GetPresetsMessageResponse extends HeadMessage {

    private GetPresetsResponseBody getPresetsResp;//预制位响应消息体内容

    public GetPresetsResponseBody getGetPresetsResp() {
        return getPresetsResp;
    }

    public void setGetPresetsResp(GetPresetsResponseBody getPresetsResp) {
        this.getPresetsResp = getPresetsResp;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        GetPresetsMessageResponse that = (GetPresetsMessageResponse)o;

        return getPresetsResp.equals(that.getPresetsResp);
    }

    @Override public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getPresetsResp.hashCode();
        return result;
    }

    @Override public String toString() {
        return "GetPresetsMessageResponse{" + "getPresetsResp=" + getPresetsResp + '}';
    }
}