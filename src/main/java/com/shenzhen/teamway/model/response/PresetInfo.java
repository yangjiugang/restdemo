package com.shenzhen.teamway.model.response;

import java.io.Serializable;

/**
 * @author : Gaven
 * @version V1.0
 * @Project: restdemo
 * @Package com.shenzhen.teamway.model
 * @Description: 预置位信息实体类
 * @date Date : 2019年02月22日 14:42
 */
public class PresetInfo implements Serializable {

    private static final long serialVersionUID = 7690683898741464608L;

    private String token;
    private String name;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
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
        PresetInfo other = (PresetInfo)obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PresetInfo [token=" + token + ", name=" + name + "]";
    }

}