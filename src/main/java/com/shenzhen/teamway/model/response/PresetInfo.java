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

    private Integer index;
    private String name;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PresetInfo that = (PresetInfo)o;

        if (!index.equals(that.index))
            return false;
        return name.equals(that.name);
    }

    @Override public int hashCode() {
        int result = index.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override public String toString() {
        return "PresetInfo{" + "index=" + index + ", name='" + name + '\'' + '}';
    }
}