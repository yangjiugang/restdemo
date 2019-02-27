package com.shenzhen.teamway.model;

import com.shenzhen.teamway.model.response.GetPresetsResponseBody;

/**
 * @author : Gaven
 * @version V1.0
 * @Project: restdemo
 * @Package com.shenzhen.teamway.model
 * @Description: 封装获取预置位信息响应报文
 * @date Date : 2019年02月22日 15:06
 */
public class GetPresetsMessageResponse extends HeadMessage {

    /**
     *
     */
    private static final long serialVersionUID = -356723226368929087L;

    private CommandResultMessage commandResp; // 返回命令执行结果
    
    private GetPresetsResponseBody getPresetsResp;// 预制位响应消息体内容

    public GetPresetsResponseBody getGetPresetsResp() {
        return getPresetsResp;
    }

    public void setGetPresetsResp(GetPresetsResponseBody getPresetsResp) {
        this.getPresetsResp = getPresetsResp;
    }

    public CommandResultMessage getCommandResp() {
        return commandResp;
    }

    public void setCommandResp(CommandResultMessage commandResp) {
        this.commandResp = commandResp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((commandResp == null) ? 0 : commandResp.hashCode());
        result = prime * result + ((getPresetsResp == null) ? 0 : getPresetsResp.hashCode());
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
        GetPresetsMessageResponse other = (GetPresetsMessageResponse)obj;
        if (commandResp == null) {
            if (other.commandResp != null)
                return false;
        } else if (!commandResp.equals(other.commandResp))
            return false;
        if (getPresetsResp == null) {
            if (other.getPresetsResp != null)
                return false;
        } else if (!getPresetsResp.equals(other.getPresetsResp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetPresetsMessageResponse [getPresetsResp=" + getPresetsResp + ", commandResp=" + commandResp + "]";
    }

}