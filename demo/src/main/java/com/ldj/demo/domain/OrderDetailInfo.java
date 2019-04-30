package com.ldj.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order_detail")
public class OrderDetailInfo implements Serializable {
    @Id
    @Column(name = "detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "fruit_id")
    private Long fruitId;

    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "fruit_price")
    private BigDecimal fruitPrice;

    @Column(name = "fruit_number")
    private Long fruitNumber;

    @Column(name = "fruit_total_price")
    private BigDecimal fruitTotalPrice;

    @Column(name = "detail_status")
    private String detailStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return detail_id
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * @param detailId
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    /**
     * @return order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return fruit_id
     */
    public Long getFruitId() {
        return fruitId;
    }

    /**
     * @param fruitId
     */
    public void setFruitId(Long fruitId) {
        this.fruitId = fruitId;
    }

    /**
     * @return order_no
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * @return fruit_name
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * @param fruitName
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName == null ? null : fruitName.trim();
    }

    /**
     * @return fruit_price
     */
    public BigDecimal getFruitPrice() {
        return fruitPrice;
    }

    /**
     * @param fruitPrice
     */
    public void setFruitPrice(BigDecimal fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    /**
     * @return fruit_number
     */
    public Long getFruitNumber() {
        return fruitNumber;
    }

    /**
     * @param fruitNumber
     */
    public void setFruitNumber(Long fruitNumber) {
        this.fruitNumber = fruitNumber;
    }

    /**
     * @return fruit_total_price
     */
    public BigDecimal getFruitTotalPrice() {
        return fruitTotalPrice;
    }

    /**
     * @param fruitTotalPrice
     */
    public void setFruitTotalPrice(BigDecimal fruitTotalPrice) {
        this.fruitTotalPrice = fruitTotalPrice;
    }

    /**
     * @return detail_status
     */
    public String getDetailStatus() {
        return detailStatus;
    }

    /**
     * @param detailStatus
     */
    public void setDetailStatus(String detailStatus) {
        this.detailStatus = detailStatus == null ? null : detailStatus.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailId=").append(detailId);
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", fruitId=").append(fruitId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", fruitName=").append(fruitName);
        sb.append(", fruitPrice=").append(fruitPrice);
        sb.append(", fruitNumber=").append(fruitNumber);
        sb.append(", fruitTotalPrice=").append(fruitTotalPrice);
        sb.append(", detailStatus=").append(detailStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}