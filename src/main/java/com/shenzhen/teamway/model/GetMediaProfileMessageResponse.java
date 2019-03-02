package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.response.GetMediaProfileResponseBody;

/**
 * 封装getMediaProfile 响应消息
 * 
 * @author gaven
 * @date 2019/03/02
 */
public class GetMediaProfileMessageResponse extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = 5827357267320616438L;

    private CommandResultMessage commandResp;

    private GetMediaProfileResponseBody getMediaProfileResp;

    public CommandResultMessage getCommandResp() {
        return commandResp;
    }

    public void setCommandResp(CommandResultMessage commandResp) {
        this.commandResp = commandResp;
    }

    public GetMediaProfileResponseBody getGetMediaProfileResp() {
        return getMediaProfileResp;
    }

    public void setGetMediaProfileResp(GetMediaProfileResponseBody getMediaProfileResp) {
        this.getMediaProfileResp = getMediaProfileResp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((commandResp == null) ? 0 : commandResp.hashCode());
        result = prime * result + ((getMediaProfileResp == null) ? 0 : getMediaProfileResp.hashCode());
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
        GetMediaProfileMessageResponse other = (GetMediaProfileMessageResponse)obj;
        if (commandResp == null) {
            if (other.commandResp != null)
                return false;
        } else if (!commandResp.equals(other.commandResp))
            return false;
        if (getMediaProfileResp == null) {
            if (other.getMediaProfileResp != null)
                return false;
        } else if (!getMediaProfileResp.equals(other.getMediaProfileResp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetMediaProfileMessageResponse [commandResp=" + commandResp + ", getMediaProfileResp="
            + getMediaProfileResp + "]";
    }

}
