package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 我的茶厂-加工统计
 * @TableName app_db_tea_processing_statistics
 */
@TableName(value ="app_db_tea_processing_statistics")
@Data
public class AppDbTeaProcessingStatistics implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 茶厂id
     */
    private Long teaFactoryId;

    /**
     * 加工时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date processingDate;

    /**
     * 加工茶青等级(0 一级 1二级)
     */
    private Integer processingTeaLevel;

    /**
     * 茶青重量(斤)
     */
    private Double teaGreenWeight;

    /**
     * 产出类型(0 绿毛茶 1红毛茶)
     */
    private Integer teaOutputType;

    /**
     * 产出毛茶(斤)
     */
    private Double teaOutputQuantity;

    /**
     * 茶园id
     */
    private Long teaId;

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
        AppDbTeaProcessingStatistics other = (AppDbTeaProcessingStatistics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeaFactoryId() == null ? other.getTeaFactoryId() == null : this.getTeaFactoryId().equals(other.getTeaFactoryId()))
            && (this.getProcessingDate() == null ? other.getProcessingDate() == null : this.getProcessingDate().equals(other.getProcessingDate()))
            && (this.getProcessingTeaLevel() == null ? other.getProcessingTeaLevel() == null : this.getProcessingTeaLevel().equals(other.getProcessingTeaLevel()))
            && (this.getTeaGreenWeight() == null ? other.getTeaGreenWeight() == null : this.getTeaGreenWeight().equals(other.getTeaGreenWeight()))
            && (this.getTeaOutputType() == null ? other.getTeaOutputType() == null : this.getTeaOutputType().equals(other.getTeaOutputType()))
            && (this.getTeaOutputQuantity() == null ? other.getTeaOutputQuantity() == null : this.getTeaOutputQuantity().equals(other.getTeaOutputQuantity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeaFactoryId() == null) ? 0 : getTeaFactoryId().hashCode());
        result = prime * result + ((getProcessingDate() == null) ? 0 : getProcessingDate().hashCode());
        result = prime * result + ((getProcessingTeaLevel() == null) ? 0 : getProcessingTeaLevel().hashCode());
        result = prime * result + ((getTeaGreenWeight() == null) ? 0 : getTeaGreenWeight().hashCode());
        result = prime * result + ((getTeaOutputType() == null) ? 0 : getTeaOutputType().hashCode());
        result = prime * result + ((getTeaOutputQuantity() == null) ? 0 : getTeaOutputQuantity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teaFactoryId=").append(teaFactoryId);
        sb.append(", processingDate=").append(processingDate);
        sb.append(", processingTeaLevel=").append(processingTeaLevel);
        sb.append(", teaGreenWeight=").append(teaGreenWeight);
        sb.append(", teaOutputType=").append(teaOutputType);
        sb.append(", teaOutputQuantity=").append(teaOutputQuantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
