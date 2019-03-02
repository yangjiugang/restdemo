package com.shenzhen.teamway.model.response;

import java.io.Serializable;

/**
 * 封装MediaUrl 响应消息实体
 * 
 * @author gaven
 * @date 2019/03/02
 */
public class GetMediaUrlResponseBody implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7179452873742042712L;

    private String mediaUrl;

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mediaUrl == null) ? 0 : mediaUrl.hashCode());
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
        GetMediaUrlResponseBody other = (GetMediaUrlResponseBody)obj;
        if (mediaUrl == null) {
            if (other.mediaUrl != null)
                return false;
        } else if (!mediaUrl.equals(other.mediaUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetMediaUrlResponseBody [mediaUrl=" + mediaUrl + "]";
    }

}
