package com.ldj.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_fruit")
public class FruitInfo implements Serializable {
    @Id
    @Column(name = "fruit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fruitId;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "fruit_image")
    private String fruitImage;

    @Column(name = "prime_cost")
    private BigDecimal primeCost;

    @Column(name = "fruit_sale")
    private BigDecimal fruitSale;

    @Column(name = "sale_count")
    private Long saleCount;

    @Column(name = "fruit_stock")
    private Long fruitStock;

    @Column(name = "shelf_status")
    private Short shelfStatus;

    @Column(name = "fruit_hot")
    private Short fruitHot;

    @Column(name = "fruit_status")
    private String fruitStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "fruit_summery")
    private String fruitSummery;

    @Column(name = "fruit_detail")
    private String fruitDetail;

    private static final long serialVersionUID = 1L;

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
     * @return fruit_image
     */
    public String getFruitImage() {
        return fruitImage;
    }

    /**
     * @param fruitImage
     */
    public void setFruitImage(String fruitImage) {
        this.fruitImage = fruitImage == null ? null : fruitImage.trim();
    }

    /**
     * @return prime_cost
     */
    public BigDecimal getPrimeCost() {
        return primeCost;
    }

    /**
     * @param primeCost
     */
    public void setPrimeCost(BigDecimal primeCost) {
        this.primeCost = primeCost;
    }

    /**
     * @return fruit_sale
     */
    public BigDecimal getFruitSale() {
        return fruitSale;
    }

    /**
     * @param fruitSale
     */
    public void setFruitSale(BigDecimal fruitSale) {
        this.fruitSale = fruitSale;
    }

    /**
     * @return sale_count
     */
    public Long getSaleCount() {
        return saleCount;
    }

    /**
     * @param saleCount
     */
    public void setSaleCount(Long saleCount) {
        this.saleCount = saleCount;
    }

    /**
     * @return fruit_stock
     */
    public Long getFruitStock() {
        return fruitStock;
    }

    /**
     * @param fruitStock
     */
    public void setFruitStock(Long fruitStock) {
        this.fruitStock = fruitStock;
    }

    /**
     * @return shelf_status
     */
    public Short getShelfStatus() {
        return shelfStatus;
    }

    /**
     * @param shelfStatus
     */
    public void setShelfStatus(Short shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    /**
     * @return fruit_hot
     */
    public Short getFruitHot() {
        return fruitHot;
    }

    /**
     * @param fruitHot
     */
    public void setFruitHot(Short fruitHot) {
        this.fruitHot = fruitHot;
    }

    /**
     * @return fruit_status
     */
    public String getFruitStatus() {
        return fruitStatus;
    }

    /**
     * @param fruitStatus
     */
    public void setFruitStatus(String fruitStatus) {
        this.fruitStatus = fruitStatus == null ? null : fruitStatus.trim();
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

    /**
     * @return fruit_summery
     */
    public String getFruitSummery() {
        return fruitSummery;
    }

    /**
     * @param fruitSummery
     */
    public void setFruitSummery(String fruitSummery) {
        this.fruitSummery = fruitSummery == null ? null : fruitSummery.trim();
    }

    /**
     * @return fruit_detail
     */
    public String getFruitDetail() {
        return fruitDetail;
    }

    /**
     * @param fruitDetail
     */
    public void setFruitDetail(String fruitDetail) {
        this.fruitDetail = fruitDetail == null ? null : fruitDetail.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fruitId=").append(fruitId);
        sb.append(", fruitName=").append(fruitName);
        sb.append(", fruitImage=").append(fruitImage);
        sb.append(", primeCost=").append(primeCost);
        sb.append(", fruitSale=").append(fruitSale);
        sb.append(", saleCount=").append(saleCount);
        sb.append(", fruitStock=").append(fruitStock);
        sb.append(", shelfStatus=").append(shelfStatus);
        sb.append(", fruitHot=").append(fruitHot);
        sb.append(", fruitStatus=").append(fruitStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", fruitSummery=").append(fruitSummery);
        sb.append(", fruitDetail=").append(fruitDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}