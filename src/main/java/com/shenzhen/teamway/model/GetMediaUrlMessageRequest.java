package com.shenzhen.teamway.model;

/**
 * 封装 获取 mediaUrl 消息实体
 * 
 * @author gaven
 * @date 2019/03/02
 */
public class GetMediaUrlMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = 9119765196510342147L;

    private GetMediaUrlMessageRequest getMediaUrl;

    public GetMediaUrlMessageRequest getGetMediaUrl() {
        return getMediaUrl;
    }

    public void setGetMediaUrl(GetMediaUrlMessageRequest getMediaUrl) {
        this.getMediaUrl = getMediaUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((getMediaUrl == null) ? 0 : getMediaUrl.hashCode());
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
        GetMediaUrlMessageRequest other = (GetMediaUrlMessageRequest)obj;
        if (getMediaUrl == null) {
            if (other.getMediaUrl != null)
                return false;
        } else if (!getMediaUrl.equals(other.getMediaUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetMediaUrlMessageRequest [getMediaUrl=" + getMediaUrl + "]";
    }

}
