package com.ldj.demo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_address")
public class AddressInfo implements Serializable {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "receive_name")
    private String receiveName;

    @Column(name = "receive_tel")
    private String receiveTel;

    @Column(name = "receive_phone")
    private String receivePhone;

    @Column(name = "receive_province")
    private String receiveProvince;

    @Column(name = "receive_city")
    private String receiveCity;

    @Column(name = "receive_county")
    private String receiveCounty;

    @Column(name = "receive_detail_address")
    private String receiveDetailAddress;

    @Column(name = "address_state")
    private String addressState;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return address_id
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * @param addressId
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
     * @return receive_name
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * @param receiveName
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName == null ? null : receiveName.trim();
    }

    /**
     * @return receive_tel
     */
    public String getReceiveTel() {
        return receiveTel;
    }

    /**
     * @param receiveTel
     */
    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel == null ? null : receiveTel.trim();
    }

    /**
     * @return receive_phone
     */
    public String getReceivePhone() {
        return receivePhone;
    }

    /**
     * @param receivePhone
     */
    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone == null ? null : receivePhone.trim();
    }

    /**
     * @return receive_province
     */
    public String getReceiveProvince() {
        return receiveProvince;
    }

    /**
     * @param receiveProvince
     */
    public void setReceiveProvince(String receiveProvince) {
        this.receiveProvince = receiveProvince == null ? null : receiveProvince.trim();
    }

    /**
     * @return receive_city
     */
    public String getReceiveCity() {
        return receiveCity;
    }

    /**
     * @param receiveCity
     */
    public void setReceiveCity(String receiveCity) {
        this.receiveCity = receiveCity == null ? null : receiveCity.trim();
    }

    /**
     * @return receive_county
     */
    public String getReceiveCounty() {
        return receiveCounty;
    }

    /**
     * @param receiveCounty
     */
    public void setReceiveCounty(String receiveCounty) {
        this.receiveCounty = receiveCounty == null ? null : receiveCounty.trim();
    }

    /**
     * @return receive_detail_address
     */
    public String getReceiveDetailAddress() {
        return receiveDetailAddress;
    }

    /**
     * @param receiveDetailAddress
     */
    public void setReceiveDetailAddress(String receiveDetailAddress) {
        this.receiveDetailAddress = receiveDetailAddress == null ? null : receiveDetailAddress.trim();
    }

    /**
     * @return address_state
     */
    public String getAddressState() {
        return addressState;
    }

    /**
     * @param addressState
     */
    public void setAddressState(String addressState) {
        this.addressState = addressState == null ? null : addressState.trim();
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
        sb.append(", addressId=").append(addressId);
        sb.append(", userId=").append(userId);
        sb.append(", receiveName=").append(receiveName);
        sb.append(", receiveTel=").append(receiveTel);
        sb.append(", receivePhone=").append(receivePhone);
        sb.append(", receiveProvince=").append(receiveProvince);
        sb.append(", receiveCity=").append(receiveCity);
        sb.append(", receiveCounty=").append(receiveCounty);
        sb.append(", receiveDetailAddress=").append(receiveDetailAddress);
        sb.append(", addressState=").append(addressState);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}