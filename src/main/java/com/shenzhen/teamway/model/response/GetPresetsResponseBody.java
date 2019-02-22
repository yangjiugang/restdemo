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

    private String uuid;
    private String presetsNumber;
    //响应的各个预置位信息
    private List<PresetInfo> presets;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPresetsNumber() {
        return presetsNumber;
    }

    public void setPresetsNumber(String presetsNumber) {
        this.presetsNumber = presetsNumber;
    }

    public List<PresetInfo> getPresets() {
        return presets;
    }

    public void setPresets(List<PresetInfo> presets) {
        this.presets = presets;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GetPresetsResponseBody that = (GetPresetsResponseBody)o;

        if (!uuid.equals(that.uuid))
            return false;
        if (!presetsNumber.equals(that.presetsNumber))
            return false;
        return presets.equals(that.presets);
    }

    @Override public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + presetsNumber.hashCode();
        result = 31 * result + presets.hashCode();
        return result;
    }

    @Override public String toString() {
        return "GetPresetsResponseBody{" + "uuid='" + uuid + '\'' + ", presetsNumber='" + presetsNumber + '\''
            + ", presets=" + presets + '}';
    }
}