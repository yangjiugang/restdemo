package com.shenzhen.teamway.model.response;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 封装getMediaProfile 响应消息实体
 * @author gaven
 * @date 2019/03/02
 */
public class GetMediaProfileResponseBody implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6145912778463716315L;

    private Integer profileNumber;

    private String[] profiles = null;

    public Integer getProfileNumber() {
        return profileNumber;
    }

    public void setProfileNumber(Integer profileNumber) {
        this.profileNumber = profileNumber;
    }

    public String[] getProfiles() {
        return profiles;
    }

    public void setProfiles(String[] profiles) {
        this.profiles = profiles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((profileNumber == null) ? 0 : profileNumber.hashCode());
        result = prime * result + Arrays.hashCode(profiles);
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
        GetMediaProfileResponseBody other = (GetMediaProfileResponseBody)obj;
        if (profileNumber == null) {
            if (other.profileNumber != null)
                return false;
        } else if (!profileNumber.equals(other.profileNumber))
            return false;
        if (!Arrays.equals(profiles, other.profiles))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetMediaProfileResponseBody [profileNumber=" + profileNumber + ", profiles=" + Arrays.toString(profiles)
            + "]";
    }

}
