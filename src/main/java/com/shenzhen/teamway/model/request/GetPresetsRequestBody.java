package com.shenzhen.teamway.model.request;

import java.io.Serializable;

/**
 * @author : Gaven
 * @version V1.0
 * @Project: restdemo
 * @Package com.shenzhen.teamway.model.request
 * @Description:封装获取预置位请求报文内容
 * @date Date : 2019年02月22日 11:56
 */
public class GetPresetsRequestBody implements Serializable {

    private static final long serialVersionUID = 5161386484393720835L;

    private String uuid;
    private String ptzUrl;
    private String profile;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPtzUrl() {
        return ptzUrl;
    }

    public void setPtzUrl(String ptzUrl) {
        this.ptzUrl = ptzUrl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        GetPresetsRequestBody that = (GetPresetsRequestBody)o;

        if (!uuid.equals(that.uuid))
            return false;
        if (!ptzUrl.equals(that.ptzUrl))
            return false;
        return profile.equals(that.profile);
    }

    @Override public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + uuid.hashCode();
        result = 31 * result + ptzUrl.hashCode();
        result = 31 * result + profile.hashCode();
        return result;
    }

    @Override public String toString() {
        return "GetPresetsRequestBody{" + "uuid='" + uuid + '\'' + ", ptzUrl='" + ptzUrl + '\'' + ", profile='" + profile
            + '\'' + '}';
    }
}