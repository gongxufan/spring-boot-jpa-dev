package gxf.dev.topology.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by gongxufan on 2014/11/20.
 */
@Entity
@Table(name = "node")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node implements Serializable {

    @Id
    private String id;
    private String elementType;
    private String x;
    private String y;
    private String width;
    private String height;
    private String alpha;
    private String rotate;
    private String scaleX;
    private String scaleY;
    private String strokeColor;
    private String fillColor;
    private String shadowColor;
    private String shadowOffsetX;
    private String shadowOffsetY;
    private String zIndex;
    private String text;
    private String font;
    private String fontColor;
    private String textPosition;
    private String textOffsetX;
    private String textOffsetY;
    private String borderRadius;
    private String deviceId;
    private String dataType;
    private String borderColor;
    private String offsetGap;
    private String childNodes;
    private String nodeImage;
    private String templateId;
    private String deviceA;
    private String deviceZ;
    private String lineType;
    private String direction;
    private String vmInstanceId;
    private String displayName;
    private String vmid;
    private String topoLevel;
    private String parentLevel;
    private String nextLevel;

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

    public String getTopoLevel() {
        return topoLevel;
    }

    public void setTopoLevel(String topoLevel) {
        this.topoLevel = topoLevel;
    }

    public String getVmid() {
        return vmid;
    }

    public void setVmid(String vmid) {
        this.vmid = vmid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getVmInstanceId() {
        return vmInstanceId;
    }

    public void setVmInstanceId(String vmInstanceId) {
        this.vmInstanceId = vmInstanceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getDeviceA() {
        return deviceA;
    }

    public void setDeviceA(String deviceA) {
        this.deviceA = deviceA;
    }

    public String getDeviceZ() {
        return deviceZ;
    }

    public void setDeviceZ(String deviceZ) {
        this.deviceZ = deviceZ;
    }

    public String getNodeImage() {
        return nodeImage;
    }

    public void setNodeImage(String nodeImage) {
        this.nodeImage = nodeImage;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getOffsetGap() {
        return offsetGap;
    }

    public void setOffsetGap(String offsetGap) {
        this.offsetGap = offsetGap;
    }

    public String getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(String childNodes) {
        this.childNodes = childNodes;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getWidth() {
        return width;
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


    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public String getRotate() {
        return rotate;
    }

    public void setRotate(String rotate) {
        this.rotate = rotate;
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

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    public String getShadowOffsetX() {
        return shadowOffsetX;
    }

    public void setShadowOffsetX(String shadowOffsetX) {
        this.shadowOffsetX = shadowOffsetX;
    }

    public String getShadowOffsetY() {
        return shadowOffsetY;
    }

    public void setShadowOffsetY(String shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
    }


    public String getZIndex() {
        return zIndex;
    }

    public void setZIndex(String zIndex) {
        this.zIndex = zIndex;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getTextPosition() {
        return textPosition;
    }

    public void setTextPosition(String textPosition) {
        this.textPosition = textPosition;
    }

    public String getTextOffsetX() {
        return textOffsetX;
    }

    public void setTextOffsetX(String textOffsetX) {
        this.textOffsetX = textOffsetX;
    }

    public String getTextOffsetY() {
        return textOffsetY;
    }

    public void setTextOffsetY(String textOffsetY) {
        this.textOffsetY = textOffsetY;
    }

    public String getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(String borderRadius) {
        this.borderRadius = borderRadius;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
