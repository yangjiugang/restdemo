package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.response.GetMediaUrlResponseBody;

/**
 * 封装getMediaUrl响应实体
 * 
 * @author gaven
 * @date 2019/03/02
 */
public class GetMediaUrlMessageResponse extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = 6329818973580194808L;

    private CommandResultMessage commandResultMessage; // 返回消息实体

    private GetMediaUrlResponseBody getMediaUrlResp; // 返回消息实体

    public CommandResultMessage getCommandResultMessage() {
        return commandResultMessage;
    }

    public void setCommandResultMessage(CommandResultMessage commandResultMessage) {
        this.commandResultMessage = commandResultMessage;
    }

    public GetMediaUrlResponseBody getGetMediaUrlResp() {
        return getMediaUrlResp;
    }

    public void setGetMediaUrlResp(GetMediaUrlResponseBody getMediaUrlResp) {
        this.getMediaUrlResp = getMediaUrlResp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((commandResultMessage == null) ? 0 : commandResultMessage.hashCode());
        result = prime * result + ((getMediaUrlResp == null) ? 0 : getMediaUrlResp.hashCode());
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
        GetMediaUrlMessageResponse other = (GetMediaUrlMessageResponse)obj;
        if (commandResultMessage == null) {
            if (other.commandResultMessage != null)
                return false;
        } else if (!commandResultMessage.equals(other.commandResultMessage))
            return false;
        if (getMediaUrlResp == null) {
            if (other.getMediaUrlResp != null)
                return false;
        } else if (!getMediaUrlResp.equals(other.getMediaUrlResp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetMediaUrlMessageResponse [commandResultMessage=" + commandResultMessage + ", getMediaUrlResp="
            + getMediaUrlResp + "]";
    }

}
