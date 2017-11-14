package gxf.dev.topology.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 拓扑编辑器舞台对象
 * Created by gongxufan on 2014/11/20.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Stage")
public class Stage implements Serializable {
    @Id
    private String version;
    private String frames;
    private String wheelZoom;
    private String deviceNum;
    private String width;
    private String height;
    private String id;
    private String totalLevel;
    private String topoLevel;
    private String parentLevel;
    private String nextLevel;

    @Transient
    private List<Scene> childs;

    public String getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(String nextLevel) {
        this.nextLevel = nextLevel;
    }

    public String getParentLevel() {
        return parentLevel;
    }

    public void setParentLevel(String parentLevel) {
        this.parentLevel = parentLevel;
    }

    public String getTotalLevel() {
        return totalLevel;
    }

    public void setTotalLevel(String totalLevel) {
        this.totalLevel = totalLevel;
    }

    public String getTopoLevel() {
        return topoLevel;
    }

    public void setTopoLevel(String topoLevel) {
        this.topoLevel = topoLevel;
    }

    public String getWidth() {
        return width;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFrames() {
        return frames;
    }

    public void setFrames(String frames) {
        this.frames = frames;
    }

    public String getWheelZoom() {
        return wheelZoom;
    }

    public void setWheelZoom(String wheelZoom) {
        this.wheelZoom = wheelZoom;
    }

    public List<Scene> getChilds() {
        return childs;
    }

    public void setChilds(List<Scene> childs) {
        this.childs = childs;
    }
}
