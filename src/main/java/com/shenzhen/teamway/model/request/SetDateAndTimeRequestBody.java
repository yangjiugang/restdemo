package com.shenzhen.teamway.model.request;

import java.io.Serializable;

/**
 * 设置摄像机时间
 * 
 * @author gaven
 * @date 2019/03/11
 */
public class SetDateAndTimeRequestBody implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 851940486372281875L;

    public SetDateAndTimeRequestBody() {}

    private String timeZone;
    private String dateTime;

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
        result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
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
        SetDateAndTimeRequestBody other = (SetDateAndTimeRequestBody)obj;
        if (dateTime == null) {
            if (other.dateTime != null)
                return false;
        } else if (!dateTime.equals(other.dateTime))
            return false;
        if (timeZone == null) {
            if (other.timeZone != null)
                return false;
        } else if (!timeZone.equals(other.timeZone))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SetDateAndTimeRequestBody [timeZone=" + timeZone + ", dateTime=" + dateTime + "]";
    }

}
