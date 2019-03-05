package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.request.GetMediaProfileRequestBody;

/**
 * 获取mediaProfile 请求消息
 * 
 * @author gaven
 * @date 2019/03/02
 */
public class GetMediaProfileMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = 6090068629014520466L;

    private GetMediaProfileRequestBody getMediaProfile;

    public GetMediaProfileRequestBody getGetMediaProfile() {
        return getMediaProfile;
    }

    public void setGetMediaProfile(GetMediaProfileRequestBody getMediaProfile) {
        this.getMediaProfile = getMediaProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((getMediaProfile == null) ? 0 : getMediaProfile.hashCode());
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
        GetMediaProfileMessageRequest other = (GetMediaProfileMessageRequest)obj;
        if (getMediaProfile == null) {
            if (other.getMediaProfile != null)
                return false;
        } else if (!getMediaProfile.equals(other.getMediaProfile))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetMediaProfileMessageRequest [getMediaProfile=" + getMediaProfile + "]";
    }

}
