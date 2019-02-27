package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.request.GotoPresetRequestBody;

/**
 * 封装调用预置位 请求报文
 * @author gaven
 * @date 2019/02/27
 */
public class GotoPresetMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = -1917759416564796818L;
    private GotoPresetRequestBody gotoPresetRequestBody;

    public GotoPresetRequestBody getGotoPresetRequestBody() {
        return gotoPresetRequestBody;
    }

    public void setGotoPresetRequestBody(GotoPresetRequestBody gotoPresetRequestBody) {
        this.gotoPresetRequestBody = gotoPresetRequestBody;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((gotoPresetRequestBody == null) ? 0 : gotoPresetRequestBody.hashCode());
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
        GotoPresetMessageRequest other = (GotoPresetMessageRequest)obj;
        if (gotoPresetRequestBody == null) {
            if (other.gotoPresetRequestBody != null)
                return false;
        } else if (!gotoPresetRequestBody.equals(other.gotoPresetRequestBody))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GotoPresetMessageRequest [gotoPresetRequestBody=" + gotoPresetRequestBody + "]";
    }

}
