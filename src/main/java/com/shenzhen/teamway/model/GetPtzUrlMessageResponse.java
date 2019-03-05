package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.response.GetPtzUrlResponseBody;

/**
 * 封装获取预置位url响应报文
 * 
 * @author gaven
 * @date 2019/03/02
 */
public class GetPtzUrlMessageResponse extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = -6365782148027398095L;

    private CommandResultMessage commandResp;

    private GetPtzUrlResponseBody getPtzUrlResp;

    public CommandResultMessage getCommandResp() {
        return commandResp;
    }

    public void setCommandResp(CommandResultMessage commandResp) {
        this.commandResp = commandResp;
    }

    public GetPtzUrlResponseBody getGetPtzUrlResp() {
        return getPtzUrlResp;
    }

    public void setGetPtzUrlResp(GetPtzUrlResponseBody getPtzUrlResp) {
        this.getPtzUrlResp = getPtzUrlResp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((commandResp == null) ? 0 : commandResp.hashCode());
        result = prime * result + ((getPtzUrlResp == null) ? 0 : getPtzUrlResp.hashCode());
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
        GetPtzUrlMessageResponse other = (GetPtzUrlMessageResponse)obj;
        if (commandResp == null) {
            if (other.commandResp != null)
                return false;
        } else if (!commandResp.equals(other.commandResp))
            return false;
        if (getPtzUrlResp == null) {
            if (other.getPtzUrlResp != null)
                return false;
        } else if (!getPtzUrlResp.equals(other.getPtzUrlResp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "getPtzUrlMessageResponse [commandResp=" + commandResp + ", getPtzUrlResp=" + getPtzUrlResp + "]";
    }

}
