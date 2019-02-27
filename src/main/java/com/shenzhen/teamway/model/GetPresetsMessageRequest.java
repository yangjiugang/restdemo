package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.request.GetPresetsRequestBody;

/**
 * @author : Gaven
 * @version V1.0
 * @Project: restdemo
 * @Package com.shenzhen.teamway.model
 * @Description: 封装获取预置位信息请求报文
 * @date Date : 2019年02月22日 15:06
 */
public class GetPresetsMessageRequest extends HeadMessage {
    /**
     *
     */
    private static final long serialVersionUID = -3951835048949080045L;

    private GetPresetsRequestBody getPresets; // 预置位请求信息

    public GetPresetsRequestBody getGetPresets() {
        return getPresets;
    }

    public void setGetPresets(GetPresetsRequestBody getPresets) {
        this.getPresets = getPresets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        GetPresetsMessageRequest that = (GetPresetsMessageRequest)o;

        return getPresets.equals(that.getPresets);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getPresets.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GetPresetsMessageRequest [getPresets=" + getPresets + "]";
    }

}