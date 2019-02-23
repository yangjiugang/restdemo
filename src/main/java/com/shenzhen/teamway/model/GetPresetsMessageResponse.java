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

    /**
     *
     */
    private static final long serialVersionUID = -356723226368929087L;

    private GetPresetsResponseBody getPresetsResponseBody;// 预制位响应消息体内容

    public GetPresetsResponseBody getGetPresetsResponseBody() {
        return getPresetsResponseBody;
    }

    public void setGetPresetsResponseBody(GetPresetsResponseBody getPresetsResponseBody) {
        this.getPresetsResponseBody = getPresetsResponseBody;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((getPresetsResponseBody == null) ? 0 : getPresetsResponseBody.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        GetPresetsMessageResponse other = (GetPresetsMessageResponse)obj;
        if (getPresetsResponseBody == null) {
            if (other.getPresetsResponseBody != null)
                return false;
        } else if (!getPresetsResponseBody.equals(other.getPresetsResponseBody))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetPresetsMessageResponse [getPresetsResponseBody=" + getPresetsResponseBody + "]";
    }

}