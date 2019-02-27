package com.shenzhen.teamway.model.request;

import java.io.Serializable;

/**
 * 封装设置预置位请求消息体
 * 
 * @author gaven
 * @date 2019/02/27
 */
public class SetPresetRequestBody implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3468135781233340491L;

    private String ptzUrl;
    private String profile;
    private String token;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        SetPresetRequestBody other = (SetPresetRequestBody)obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
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
        return "SetPresetRequestBody [ptzUrl=" + ptzUrl + ", profile=" + profile + ", token=" + token + ", name=" + name
            + "]";
    }

}
