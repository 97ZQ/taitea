package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 农资信息-采集中心
 * @TableName app_db_acquisition_center
 */
@TableName(value ="app_db_acquisition_center")
@Data
public class AppDbAcquisitionCenter implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 采集标题
     */
    private String captureTitle;

    /**
     * 采购量
     */
    private String quantityPurchased;

    /**
     * 截止时间
     */
    private Date cutOffTime;

    /**
     * 文件地址
     */
    private String attachments;

    /**
     * 静态文件地址
     */
    private String staticPath;

    /**
     * 文件id
     */
    private Long fileId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AppDbAcquisitionCenter other = (AppDbAcquisitionCenter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCaptureTitle() == null ? other.getCaptureTitle() == null : this.getCaptureTitle().equals(other.getCaptureTitle()))
            && (this.getQuantityPurchased() == null ? other.getQuantityPurchased() == null : this.getQuantityPurchased().equals(other.getQuantityPurchased()))
            && (this.getCutOffTime() == null ? other.getCutOffTime() == null : this.getCutOffTime().equals(other.getCutOffTime()))
            && (this.getAttachments() == null ? other.getAttachments() == null : this.getAttachments().equals(other.getAttachments()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCaptureTitle() == null) ? 0 : getCaptureTitle().hashCode());
        result = prime * result + ((getQuantityPurchased() == null) ? 0 : getQuantityPurchased().hashCode());
        result = prime * result + ((getCutOffTime() == null) ? 0 : getCutOffTime().hashCode());
        result = prime * result + ((getAttachments() == null) ? 0 : getAttachments().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", captureTitle=").append(captureTitle);
        sb.append(", quantityPurchased=").append(quantityPurchased);
        sb.append(", cutOffTime=").append(cutOffTime);
        sb.append(", attachments=").append(attachments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
