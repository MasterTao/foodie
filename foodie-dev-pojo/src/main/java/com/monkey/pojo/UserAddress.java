package com.monkey.pojo;

import javax.persistence.*;

@Table(name = "user_address")
public class UserAddress {
    @Id
    @Column(name = "address_id")
    private Integer addressId;

    /**
     * SHIPPING, BILLING
     */
    @Column(name = "address_type")
    private String addressType;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "user_id")
    private Integer userId;

    private String consignee;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    /**
     * 性别
     */
    private String gender;

    private String email;

    private Short country;

    private Short province;

    private Short city;

    private Short district;

    private String address;

    private String zipcode;

    private String tel;

    private String mobile;

    @Column(name = "sign_building")
    private String signBuilding;

    @Column(name = "best_time")
    private String bestTime;

    /**
     * 省/直辖市，输入
     */
    @Column(name = "province_text")
    private String provinceText;

    /**
     * 市/区，输入
     */
    @Column(name = "city_text")
    private String cityText;

    /**
     * 县/区，输入
     */
    @Column(name = "district_text")
    private String districtText;

    /**
     * 是否是默认配送地址
     */
    @Column(name = "is_default")
    private Boolean isDefault;

    /**
     * CPF or CNPJ code type
     */
    @Column(name = "tax_code_type")
    private Boolean taxCodeType;

    /**
     * CPF or CNPJ code value
     */
    @Column(name = "tax_code_value")
    private String taxCodeValue;

    /**
     * 南美suburb
     */
    private String suburb;

    private String area;

    @Column(name = "nearest_landmark")
    private String nearestLandmark;

    /**
     * HOME,BUSINESS
     */
    @Column(name = "location_type")
    private String locationType;

    /**
     * @return address_id
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * @param addressId
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取SHIPPING, BILLING
     *
     * @return address_type - SHIPPING, BILLING
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * 设置SHIPPING, BILLING
     *
     * @param addressType SHIPPING, BILLING
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * @return address_name
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * @param addressName
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return consignee
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * @param consignee
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * @return first_name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return last_name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return country
     */
    public Short getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(Short country) {
        this.country = country;
    }

    /**
     * @return province
     */
    public Short getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(Short province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public Short getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(Short city) {
        this.city = city;
    }

    /**
     * @return district
     */
    public Short getDistrict() {
        return district;
    }

    /**
     * @param district
     */
    public void setDistrict(Short district) {
        this.district = district;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return sign_building
     */
    public String getSignBuilding() {
        return signBuilding;
    }

    /**
     * @param signBuilding
     */
    public void setSignBuilding(String signBuilding) {
        this.signBuilding = signBuilding;
    }

    /**
     * @return best_time
     */
    public String getBestTime() {
        return bestTime;
    }

    /**
     * @param bestTime
     */
    public void setBestTime(String bestTime) {
        this.bestTime = bestTime;
    }

    /**
     * 获取省/直辖市，输入
     *
     * @return province_text - 省/直辖市，输入
     */
    public String getProvinceText() {
        return provinceText;
    }

    /**
     * 设置省/直辖市，输入
     *
     * @param provinceText 省/直辖市，输入
     */
    public void setProvinceText(String provinceText) {
        this.provinceText = provinceText;
    }

    /**
     * 获取市/区，输入
     *
     * @return city_text - 市/区，输入
     */
    public String getCityText() {
        return cityText;
    }

    /**
     * 设置市/区，输入
     *
     * @param cityText 市/区，输入
     */
    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    /**
     * 获取县/区，输入
     *
     * @return district_text - 县/区，输入
     */
    public String getDistrictText() {
        return districtText;
    }

    /**
     * 设置县/区，输入
     *
     * @param districtText 县/区，输入
     */
    public void setDistrictText(String districtText) {
        this.districtText = districtText;
    }

    /**
     * 获取是否是默认配送地址
     *
     * @return is_default - 是否是默认配送地址
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否是默认配送地址
     *
     * @param isDefault 是否是默认配送地址
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取CPF or CNPJ code type
     *
     * @return tax_code_type - CPF or CNPJ code type
     */
    public Boolean getTaxCodeType() {
        return taxCodeType;
    }

    /**
     * 设置CPF or CNPJ code type
     *
     * @param taxCodeType CPF or CNPJ code type
     */
    public void setTaxCodeType(Boolean taxCodeType) {
        this.taxCodeType = taxCodeType;
    }

    /**
     * 获取CPF or CNPJ code value
     *
     * @return tax_code_value - CPF or CNPJ code value
     */
    public String getTaxCodeValue() {
        return taxCodeValue;
    }

    /**
     * 设置CPF or CNPJ code value
     *
     * @param taxCodeValue CPF or CNPJ code value
     */
    public void setTaxCodeValue(String taxCodeValue) {
        this.taxCodeValue = taxCodeValue;
    }

    /**
     * 获取南美suburb
     *
     * @return suburb - 南美suburb
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * 设置南美suburb
     *
     * @param suburb 南美suburb
     */
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    /**
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return nearest_landmark
     */
    public String getNearestLandmark() {
        return nearestLandmark;
    }

    /**
     * @param nearestLandmark
     */
    public void setNearestLandmark(String nearestLandmark) {
        this.nearestLandmark = nearestLandmark;
    }

    /**
     * 获取HOME,BUSINESS
     *
     * @return location_type - HOME,BUSINESS
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * 设置HOME,BUSINESS
     *
     * @param locationType HOME,BUSINESS
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}