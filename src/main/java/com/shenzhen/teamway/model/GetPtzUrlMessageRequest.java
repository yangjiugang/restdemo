package com.shenzhen.teamway.model;

/**
 * 封装获取预置位请求消息实体
 * @author gaven
 * @date 2019/03/02
 */
public class GetPtzUrlMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = 8636396856881450260L;

    private GetPtzUrlMessageRequest getPtzUrl;

    public GetPtzUrlMessageRequest getGetPtzUrl() {
        return getPtzUrl;
    }

    public void setGetPtzUrl(GetPtzUrlMessageRequest getPtzUrl) {
        this.getPtzUrl = getPtzUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((getPtzUrl == null) ? 0 : getPtzUrl.hashCode());
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
        GetPtzUrlMessageRequest other = (GetPtzUrlMessageRequest)obj;
        if (getPtzUrl == null) {
            if (other.getPtzUrl != null)
                return false;
        } else if (!getPtzUrl.equals(other.getPtzUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetPtzUrlMessageRequest [getPtzUrl=" + getPtzUrl + "]";
    }

}
