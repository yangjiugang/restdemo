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

    private String ptzUrl;
    private String profile;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((profile == null) ? 0 : profile.hashCode());
        result = prime * result + ((ptzUrl == null) ? 0 : ptzUrl.hashCode());
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
        GetPresetsRequestBody other = (GetPresetsRequestBody)obj;
        if (profile == null) {
            if (other.profile != null)
                return false;
        } else if (!profile.equals(other.profile))
            return false;
        if (ptzUrl == null) {
            if (other.ptzUrl != null)
                return false;
        } else if (!ptzUrl.equals(other.ptzUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetPresetsRequestBody [ptzUrl=" + ptzUrl + ", profile=" + profile + "]";
    }

}