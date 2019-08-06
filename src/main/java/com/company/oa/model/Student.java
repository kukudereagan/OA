package com.company.oa.model;

import org.apache.ibatis.type.Alias;

 
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Alias("studentModel")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer sex;
    private String nation;
    private String certificateType;
    private String certificateCode;
    private Date birthDay;
    private String countryCode;
    private String country;
    private String carModelCode;
    private String carModel;
    private Integer drivingSchoolId;
    private String drivingSchool;
    private String registerArea;
    private String registerAddress;
    private String source;
    private String temporaryResidenceCode;
    private String contactArea;
    private String contactAddress;
    private String contactJurisdiction;
    private String contactZip;
    private String phone;
    private String mobile1;
    private String mobile2;
    private String idcardBefore;//身份证正面
    private String idcardBack;//身份证反面
    private String scenePicture;//现场拍照
    private String fingerprint;//指纹
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCarModelCode() {
		return carModelCode;
	}

	public void setCarModelCode(String carModelCode) {
		this.carModelCode = carModelCode;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Integer getDrivingSchoolId() {
		return drivingSchoolId;
	}

	public void setDrivingSchoolId(Integer drivingSchoolId) {
		this.drivingSchoolId = drivingSchoolId;
	}

	public String getDrivingSchool() {
		return drivingSchool;
	}

	public void setDrivingSchool(String drivingSchool) {
		this.drivingSchool = drivingSchool;
	}

	public String getRegisterArea() {
		return registerArea;
	}

	public void setRegisterArea(String registerArea) {
		this.registerArea = registerArea;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTemporaryResidenceCode() {
		return temporaryResidenceCode;
	}

	public void setTemporaryResidenceCode(String temporaryResidenceCode) {
		this.temporaryResidenceCode = temporaryResidenceCode;
	}

	public String getContactArea() {
		return contactArea;
	}

	public void setContactArea(String contactArea) {
		this.contactArea = contactArea;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactJurisdiction() {
		return contactJurisdiction;
	}

	public void setContactJurisdiction(String contactJurisdiction) {
		this.contactJurisdiction = contactJurisdiction;
	}

	public String getContactZip() {
		return contactZip;
	}

	public void setContactZip(String contactZip) {
		this.contactZip = contactZip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	
	public String getIdcardBefore() {
		return idcardBefore;
	}

	public void setIdcardBefore(String idcardBefore) {
		this.idcardBefore = idcardBefore;
	}
	
	public String getIdcardBack() {
		return idcardBack;
	}

	public void setIdcardBack(String idcardBack) {
		this.idcardBack = idcardBack;
	}
	
	public String getScenePicture() {
		return scenePicture;
	}

	public void setScenePicture(String scenePicture) {
		this.scenePicture = scenePicture;
	}
	
	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
}
