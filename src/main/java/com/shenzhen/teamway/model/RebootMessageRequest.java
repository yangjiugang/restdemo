package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.request.RebootRequestBody;

/**
 * 封装重启请求报文
 * 
 * @author gaven
 * @date 2019/03/02
 */
public class RebootMessageRequest extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = 503040021386822978L;

    private RebootRequestBody reboot;

    public RebootRequestBody getReboot() {
        return reboot;
    }

    public void setReboot(RebootRequestBody reboot) {
        this.reboot = reboot;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((reboot == null) ? 0 : reboot.hashCode());
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
        RebootMessageRequest other = (RebootMessageRequest)obj;
        if (reboot == null) {
            if (other.reboot != null)
                return false;
        } else if (!reboot.equals(other.reboot))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RebootMessageRequest [reboot=" + reboot + "]";
    }

}
