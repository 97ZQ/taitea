package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 农资求购信息-报价内容
 * @TableName app_db_price_info
 */
@TableName(value ="app_db_price_info")
@Data
public class AppDbPriceInfo implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 报价内容
     */
    private String priceContent;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系方式
     */
    private String contactPhone;

    /**
     * 附件
     */
    private String fileUrl;

    /**
     * 求购id
     */
    private Long purchaseId;

    /**
     * 报价人id
     */
    private Long pricePersonId;

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
        AppDbPriceInfo other = (AppDbPriceInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPriceContent() == null ? other.getPriceContent() == null : this.getPriceContent().equals(other.getPriceContent()))
            && (this.getContactPerson() == null ? other.getContactPerson() == null : this.getContactPerson().equals(other.getContactPerson()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getPurchaseId() == null ? other.getPurchaseId() == null : this.getPurchaseId().equals(other.getPurchaseId()))
            && (this.getPricePersonId() == null ? other.getPricePersonId() == null : this.getPricePersonId().equals(other.getPricePersonId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPriceContent() == null) ? 0 : getPriceContent().hashCode());
        result = prime * result + ((getContactPerson() == null) ? 0 : getContactPerson().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getPurchaseId() == null) ? 0 : getPurchaseId().hashCode());
        result = prime * result + ((getPricePersonId() == null) ? 0 : getPricePersonId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", priceContent=").append(priceContent);
        sb.append(", contactPerson=").append(contactPerson);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", purchaseId=").append(purchaseId);
        sb.append(", pricePersonId=").append(pricePersonId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}