package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.request.SetPresetRequestBody;

/**
 * 封装设置预置位 请求报文
 * 
 * @author gaven
 * @date 2019/02/27
 */
public class SetPrestMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = 1919794193309111894L;
    private SetPresetRequestBody setPreset;

    public SetPresetRequestBody getSetPreset() {
        return setPreset;
    }

    public void setSetPreset(SetPresetRequestBody setPreset) {
        this.setPreset = setPreset;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((setPreset == null) ? 0 : setPreset.hashCode());
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
        if (setPreset == null) {
            if (other.setPreset != null)
                return false;
        } else if (!setPreset.equals(other.setPreset))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SetPrestMessageRequest [setPreset=" + setPreset + "]";
    }

}
