package com.shenzhen.teamway.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Gaven
 * @version V1.0
 * @Project: restdemo
 * @Package com.shenzhen.teamway.model.response
 * @Description: 封装响应预置位请求报文内容
 * @date Date : 2019年02月22日 11:57
 */
public class GetPresetsResponseBody implements Serializable {

    private static final long serialVersionUID = -7089063070800293763L;

    private Integer presetsNumber;
    // 响应的各个预置位信息
    private List<PresetInfo> presets;

    public Integer getPresetsNumber() {
        return presetsNumber;
    }

    public void setPresetsNumber(Integer presetsNumber) {
        this.presetsNumber = presetsNumber;
    }

    public List<PresetInfo> getPresets() {
        return presets;
    }

    public void setPresets(List<PresetInfo> presets) {
        this.presets = presets;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((presets == null) ? 0 : presets.hashCode());
        result = prime * result + ((presetsNumber == null) ? 0 : presetsNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GetPresetsResponseBody other = (GetPresetsResponseBody)obj;
        if (presets == null) {
            if (other.presets != null)
                return false;
        } else if (!presets.equals(other.presets))
            return false;
        if (presetsNumber == null) {
            if (other.presetsNumber != null)
                return false;
        } else if (!presetsNumber.equals(other.presetsNumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetPresetsResponseBody [presetsNumber=" + presetsNumber + ", presets=" + presets + "]";
    }

}