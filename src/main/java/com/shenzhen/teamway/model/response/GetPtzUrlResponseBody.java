package com.shenzhen.teamway.model.response;

import java.io.Serializable;

/**
 * 封装获取预置位url请求实体
 * 
 * @author gaven
 * @date 2019/03/02
 */
public class GetPtzUrlResponseBody implements Serializable {

    /**
     * 预置位url
     */
    private String ptzUrl;

    public String getPtzUrl() {
        return ptzUrl;
    }

    public void setPtzUrl(String ptzUrl) {
        this.ptzUrl = ptzUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        GetPtzUrlResponseBody other = (GetPtzUrlResponseBody)obj;
        if (ptzUrl == null) {
            if (other.ptzUrl != null)
                return false;
        } else if (!ptzUrl.equals(other.ptzUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetPtzUrlResponseBody [ptzUrl=" + ptzUrl + "]";
    }

}
