package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 农事管理-我的茶厂-基本信息
 * @TableName app_db_my_tea_factory
 */
@TableName(value ="app_db_my_tea_factory")
@Data
public class AppDbMyTeaFactory implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 茶厂负责人id
     */
    private Long teaFactoryChargeId;

    /**
     * 茶厂负责人名称
     */
    private String teaFactoryChargeName;

    /**
     * 茶厂负责人联系电话
     */
    private String teaFactoryChargePhone;

    /**
     * 茶厂名称
     */
    private String teaFactoryName;

    /**
     * 茶厂介绍
     */
    private String teaFactoryIntroduce;

    /**
     * 轮播图1
     */
    private String carouselMapOne;

    /**
     * 轮播图2
     */
    private String carouselMapTwo;

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
        AppDbMyTeaFactory other = (AppDbMyTeaFactory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeaFactoryChargeId() == null ? other.getTeaFactoryChargeId() == null : this.getTeaFactoryChargeId().equals(other.getTeaFactoryChargeId()))
            && (this.getTeaFactoryChargeName() == null ? other.getTeaFactoryChargeName() == null : this.getTeaFactoryChargeName().equals(other.getTeaFactoryChargeName()))
            && (this.getTeaFactoryChargePhone() == null ? other.getTeaFactoryChargePhone() == null : this.getTeaFactoryChargePhone().equals(other.getTeaFactoryChargePhone()))
            && (this.getTeaFactoryName() == null ? other.getTeaFactoryName() == null : this.getTeaFactoryName().equals(other.getTeaFactoryName()))
            && (this.getTeaFactoryIntroduce() == null ? other.getTeaFactoryIntroduce() == null : this.getTeaFactoryIntroduce().equals(other.getTeaFactoryIntroduce()))
            && (this.getCarouselMapOne() == null ? other.getCarouselMapOne() == null : this.getCarouselMapOne().equals(other.getCarouselMapOne()))
            && (this.getCarouselMapTwo() == null ? other.getCarouselMapTwo() == null : this.getCarouselMapTwo().equals(other.getCarouselMapTwo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeaFactoryChargeId() == null) ? 0 : getTeaFactoryChargeId().hashCode());
        result = prime * result + ((getTeaFactoryChargeName() == null) ? 0 : getTeaFactoryChargeName().hashCode());
        result = prime * result + ((getTeaFactoryChargePhone() == null) ? 0 : getTeaFactoryChargePhone().hashCode());
        result = prime * result + ((getTeaFactoryName() == null) ? 0 : getTeaFactoryName().hashCode());
        result = prime * result + ((getTeaFactoryIntroduce() == null) ? 0 : getTeaFactoryIntroduce().hashCode());
        result = prime * result + ((getCarouselMapOne() == null) ? 0 : getCarouselMapOne().hashCode());
        result = prime * result + ((getCarouselMapTwo() == null) ? 0 : getCarouselMapTwo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teaFactoryChargeId=").append(teaFactoryChargeId);
        sb.append(", teaFactoryChargeName=").append(teaFactoryChargeName);
        sb.append(", teaFactoryChargePhone=").append(teaFactoryChargePhone);
        sb.append(", teaFactoryName=").append(teaFactoryName);
        sb.append(", teaFactoryIntroduce=").append(teaFactoryIntroduce);
        sb.append(", carouselMapOne=").append(carouselMapOne);
        sb.append(", carouselMapTwo=").append(carouselMapTwo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
