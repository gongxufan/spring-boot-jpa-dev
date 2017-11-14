package gxf.dev.topology.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gongxufan on 2014/11/20.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Scene")
public class Scene implements Serializable {
    @Id
    private String id;
    private String elementType;
    private String background;
    private String backgroundColor;
    private String mode;
    private String translateX;
    private String translateY;
    private String alpha;
    private String scaleX;
    private String scaleY;
    private String totalLevel;
    private String parentLevel;
    private String nextLevel;
    private String topoLevel;
    @Transient
    private List<Node> childs;

    public String getTopoLevel() {
        return topoLevel;
    }

    public void setTopoLevel(String topoLevel) {
        this.topoLevel = topoLevel;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTranslateX() {
        return translateX;
    }

    public void setTranslateX(String translateX) {
        this.translateX = translateX;
    }

    public String getTranslateY() {
        return translateY;
    }

    public void setTranslateY(String translateY) {
        this.translateY = translateY;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public String getScaleX() {
        return scaleX;
    }

    public void setScaleX(String scaleX) {
        this.scaleX = scaleX;
    }

    public String getScaleY() {
        return scaleY;
    }

    public void setScaleY(String scaleY) {
        this.scaleY = scaleY;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }
}
