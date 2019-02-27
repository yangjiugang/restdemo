package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.request.SetPresetRequestBody;

/**
 * 封装设置预置位 请求报文
 * @author gaven
 * @date 2019/02/27
 */
public class SetPrestMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = 1919794193309111894L;
    private SetPresetRequestBody setPresetRequestBody;

    public SetPresetRequestBody getSetPresetRequestBody() {
        return setPresetRequestBody;
    }

    public void setSetPresetRequestBody(SetPresetRequestBody setPresetRequestBody) {
        this.setPresetRequestBody = setPresetRequestBody;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((setPresetRequestBody == null) ? 0 : setPresetRequestBody.hashCode());
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
        SetPrestMessageRequest other = (SetPrestMessageRequest)obj;
        if (setPresetRequestBody == null) {
            if (other.setPresetRequestBody != null)
                return false;
        } else if (!setPresetRequestBody.equals(other.setPresetRequestBody))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SetPrestMessageRequest [setPresetRequestBody=" + setPresetRequestBody + "]";
    }

}
