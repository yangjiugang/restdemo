package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.request.GotoPresetRequestBody;

/**
 * 封装调用预置位 请求报文
 * 
 * @author gaven
 * @date 2019/02/27
 */
public class GotoPresetMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = -1917759416564796818L;
    private GotoPresetRequestBody gotoPreset;

    public GotoPresetRequestBody getGotoPreset() {
        return gotoPreset;
    }

    public void setGotoPreset(GotoPresetRequestBody gotoPreset) {
        this.gotoPreset = gotoPreset;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((gotoPreset == null) ? 0 : gotoPreset.hashCode());
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
        if (gotoPreset == null) {
            if (other.gotoPreset != null)
                return false;
        } else if (!gotoPreset.equals(other.gotoPreset))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GotoPresetMessageRequest [gotoPreset=" + gotoPreset + "]";
    }

}
