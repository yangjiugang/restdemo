package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.request.SetDateAndTimeRequestBody;

/**
 * 设置时间请求报文 对时功能
 * 
 * @author gaven
 * @date 2019/03/11
 */
public class SetDateAndTimeMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = -1998994865942170269L;

    public SetDateAndTimeMessageRequest() {}

    private SetDateAndTimeRequestBody setDateAndTime;

    public SetDateAndTimeRequestBody getSetDateAndTime() {
        return setDateAndTime;
    }

    public void setSetDateAndTime(SetDateAndTimeRequestBody setDateAndTime) {
        this.setDateAndTime = setDateAndTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((setDateAndTime == null) ? 0 : setDateAndTime.hashCode());
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
        SetDateAndTimeMessageRequest other = (SetDateAndTimeMessageRequest)obj;
        if (setDateAndTime == null) {
            if (other.setDateAndTime != null)
                return false;
        } else if (!setDateAndTime.equals(other.setDateAndTime))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SetDateAndTimeMessageRequest [setDateAndTime=" + setDateAndTime + "]";
    }

}
