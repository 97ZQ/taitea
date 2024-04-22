package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 农资信息-农资求购信息
 * @TableName app_db_purchase_info
 */
@TableName(value ="app_db_purchase_info")
@Data
public class AppDbPurchaseInfo implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 求购类型(0 急购 1 采购)
     */
    private String type;

    /**
     * 采购量
     */
    private String amountPurchased;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 发布人
     */
    private String publisher;

    /**
     * 发布人id
     */
    private Long publisherId;

    /**
     * 求购标题
     */
    private String purchaseInformation;

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
        AppDbPurchaseInfo other = (AppDbPurchaseInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAmountPurchased() == null ? other.getAmountPurchased() == null : this.getAmountPurchased().equals(other.getAmountPurchased()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getPublisher() == null ? other.getPublisher() == null : this.getPublisher().equals(other.getPublisher()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getPurchaseInformation() == null ? other.getPurchaseInformation() == null : this.getPurchaseInformation().equals(other.getPurchaseInformation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAmountPurchased() == null) ? 0 : getAmountPurchased().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getPublisher() == null) ? 0 : getPublisher().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getPurchaseInformation() == null) ? 0 : getPurchaseInformation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", amountPurchased=").append(amountPurchased);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", publisher=").append(publisher);
        sb.append(", publisherId=").append(publisherId);
        sb.append(", purchaseInformation=").append(purchaseInformation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}