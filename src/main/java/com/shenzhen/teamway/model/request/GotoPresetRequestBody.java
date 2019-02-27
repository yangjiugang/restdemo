package com.shenzhen.teamway.model.request;

import java.io.Serializable;

/**
 * 封装调用预置位请求实体
 * @author gaven
 * @date 2019/02/27
 */
public class GotoPresetRequestBody implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 866254295027097473L;

    private String ptzUrl;
    private String profile;
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((profile == null) ? 0 : profile.hashCode());
        result = prime * result + ((ptzUrl == null) ? 0 : ptzUrl.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
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
        GotoPresetRequestBody other = (GotoPresetRequestBody)obj;
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
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GotoPresetRequestBody [ptzUrl=" + ptzUrl + ", profile=" + profile + ", token=" + token + "]";
    }

}
