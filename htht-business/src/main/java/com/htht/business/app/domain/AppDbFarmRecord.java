package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 农事记录
 * @TableName app_db_farm_record
 */
@TableName(value ="app_db_farm_record")
@Data
public class AppDbFarmRecord implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 茶园id
     */
    private Long teaGardenId;

    /**
     * 农事类型(0 施肥 1 浇水 2 松土 3其他)
     */
    private String farmingType;

    /**
     * 内容描述
     */
    private String workContent;

    /**
     * 工作人员名称
     */
    private String workName;

    /**
     * 农事记录日期
     */
    private Date workDate;

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
        AppDbFarmRecord other = (AppDbFarmRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeaGardenId() == null ? other.getTeaGardenId() == null : this.getTeaGardenId().equals(other.getTeaGardenId()))
            && (this.getFarmingType() == null ? other.getFarmingType() == null : this.getFarmingType().equals(other.getFarmingType()))
            && (this.getWorkContent() == null ? other.getWorkContent() == null : this.getWorkContent().equals(other.getWorkContent()))
            && (this.getWorkName() == null ? other.getWorkName() == null : this.getWorkName().equals(other.getWorkName()))
            && (this.getWorkDate() == null ? other.getWorkDate() == null : this.getWorkDate().equals(other.getWorkDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeaGardenId() == null) ? 0 : getTeaGardenId().hashCode());
        result = prime * result + ((getFarmingType() == null) ? 0 : getFarmingType().hashCode());
        result = prime * result + ((getWorkContent() == null) ? 0 : getWorkContent().hashCode());
        result = prime * result + ((getWorkName() == null) ? 0 : getWorkName().hashCode());
        result = prime * result + ((getWorkDate() == null) ? 0 : getWorkDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teaGardenId=").append(teaGardenId);
        sb.append(", farmingType=").append(farmingType);
        sb.append(", workContent=").append(workContent);
        sb.append(", workName=").append(workName);
        sb.append(", workDate=").append(workDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
