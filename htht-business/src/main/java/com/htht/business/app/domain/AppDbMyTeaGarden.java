package com.htht.business.app.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 农事管理-我的茶园-基本信息
 * @TableName app_db_my_tea_garden
 */
@TableName(value ="app_db_my_tea_garden")
@Data
public class AppDbMyTeaGarden implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 茶园名称
     */
    private String teaName;

    /**
     * 茶园介绍
     */
    private String teaIntroduce;

    /**
     * 轮播图1
     */
    private String carouselMapOne;

    /**
     * 轮播图2
     */
    private String carouselMapTwo;

    /**
     * 茶园负责人id
     */
    private Long teaOwnerId;

    /**
     * 茶园负责人名称
     */
    private String teaOwnerName;

    /**
     * 天气预报街道
     */
    private String weatherStreet;

    /**
     * 视频监控
     */
    private String videoSurveillance;

    /**
     * 茶园负责人电话
     */
    private String teaOwnerPhone;

    /**
     * 静态地址
     */
    private String carouselMapStaticPath;

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
        AppDbMyTeaGarden other = (AppDbMyTeaGarden) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeaName() == null ? other.getTeaName() == null : this.getTeaName().equals(other.getTeaName()))
            && (this.getTeaIntroduce() == null ? other.getTeaIntroduce() == null : this.getTeaIntroduce().equals(other.getTeaIntroduce()))
            && (this.getCarouselMapOne() == null ? other.getCarouselMapOne() == null : this.getCarouselMapOne().equals(other.getCarouselMapOne()))
            && (this.getCarouselMapTwo() == null ? other.getCarouselMapTwo() == null : this.getCarouselMapTwo().equals(other.getCarouselMapTwo()))
            && (this.getTeaOwnerId() == null ? other.getTeaOwnerId() == null : this.getTeaOwnerId().equals(other.getTeaOwnerId()))
            && (this.getTeaOwnerName() == null ? other.getTeaOwnerName() == null : this.getTeaOwnerName().equals(other.getTeaOwnerName()))
            && (this.getWeatherStreet() == null ? other.getWeatherStreet() == null : this.getWeatherStreet().equals(other.getWeatherStreet()))
            && (this.getVideoSurveillance() == null ? other.getVideoSurveillance() == null : this.getVideoSurveillance().equals(other.getVideoSurveillance()))
            && (this.getTeaOwnerPhone() == null ? other.getTeaOwnerPhone() == null : this.getTeaOwnerPhone().equals(other.getTeaOwnerPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeaName() == null) ? 0 : getTeaName().hashCode());
        result = prime * result + ((getTeaIntroduce() == null) ? 0 : getTeaIntroduce().hashCode());
        result = prime * result + ((getCarouselMapOne() == null) ? 0 : getCarouselMapOne().hashCode());
        result = prime * result + ((getCarouselMapTwo() == null) ? 0 : getCarouselMapTwo().hashCode());
        result = prime * result + ((getTeaOwnerId() == null) ? 0 : getTeaOwnerId().hashCode());
        result = prime * result + ((getTeaOwnerName() == null) ? 0 : getTeaOwnerName().hashCode());
        result = prime * result + ((getWeatherStreet() == null) ? 0 : getWeatherStreet().hashCode());
        result = prime * result + ((getVideoSurveillance() == null) ? 0 : getVideoSurveillance().hashCode());
        result = prime * result + ((getTeaOwnerPhone() == null) ? 0 : getTeaOwnerPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teaName=").append(teaName);
        sb.append(", teaIntroduce=").append(teaIntroduce);
        sb.append(", carouselMapOne=").append(carouselMapOne);
        sb.append(", carouselMapTwo=").append(carouselMapTwo);
        sb.append(", teaOwnerId=").append(teaOwnerId);
        sb.append(", teaOwnerName=").append(teaOwnerName);
        sb.append(", weatherStreet=").append(weatherStreet);
        sb.append(", videoSurveillance=").append(videoSurveillance);
        sb.append(", teaOwnerPhone=").append(teaOwnerPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
