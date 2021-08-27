package com.vinay.flutter_toast_message;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AadhaarXMLDatas implements Serializable {

    @SerializedName("mobileHash")
    @Expose
    private String mobileHash;
    @SerializedName("isEmailVerified")
    @Expose
    private boolean isEmailVerified;
    @SerializedName("imagebase64")
    @Expose
    private String imagebase64;
    @SerializedName("sharecode")
    @Expose
    private String sharecode;
    @SerializedName("maskedAahaarNumber")
    @Expose
    private String maskedAahaarNumber;
    @SerializedName("father")
    @Expose
    private String father;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("zipFileBase64")
    @Expose
    private String zipFileBase64;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("zipFilePath")
    @Expose
    private String zipFilePath;
    @SerializedName("isXmlVerify")
    @Expose
    private boolean isXmlVerify;
    @SerializedName("genDate")
    @Expose
    private String genDate;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("isMobileVerified")
    @Expose
    private boolean isMobileVerified;
    @SerializedName("isError")
    @Expose
    private boolean isError;
    @SerializedName("emailHash")
    @Expose
    private String emailHash;
    @SerializedName("address_careof")
    @Expose
    private String careOf;
    @SerializedName("address_house")
    @Expose
    private String house;
    @SerializedName("address_loc")@Expose
    private String locality;
    @SerializedName("address_street")@Expose
    private String street;
    @SerializedName("address_landmark")@Expose
    private String landMark;
    @SerializedName("address_vtc")@Expose
    private String vtc;
    @SerializedName("address_pc")@Expose
    private String pinCode;
    @SerializedName("address_po")@Expose
    private String post;
    @SerializedName("address_subdist")@Expose
    private String subDist;
    @SerializedName("address_dist")@Expose
    private String district;
    @SerializedName("address_state")@Expose
    private String state;
    @SerializedName("address_country")@Expose
    private String country;
    @SerializedName("message")
    private String errorMessage;

    public AadhaarXMLDatas() {
    }

    public AadhaarXMLDatas(String mobileHash, boolean isEmailVerified, String imagebase64, String sharecode, String maskedAahaarNumber, String father, String gender, String zipFileBase64, String address, String zipFilePath, boolean isXmlVerify, String genDate, String dob, String name, boolean isMobileVerified, boolean isError, String emailHash) {
        this.mobileHash = mobileHash;
        this.isEmailVerified = isEmailVerified;
        this.imagebase64 = imagebase64;
        this.sharecode = sharecode;
        this.maskedAahaarNumber = maskedAahaarNumber;
        this.father = father;
        this.gender = gender;
        this.zipFileBase64 = zipFileBase64;
        this.address = address;
        this.zipFilePath = zipFilePath;
        this.isXmlVerify = isXmlVerify;
        this.genDate = genDate;
        this.dob = dob;
        this.name = name;
        this.isMobileVerified = isMobileVerified;
        this.isError = isError;
        this.emailHash = emailHash;
    }

    public String getMobileHash() {
        return mobileHash;
    }

    public void setMobileHash(String mobileHash) {
        this.mobileHash = mobileHash;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getImagebase64() {
        return imagebase64;
    }

    public void setImagebase64(String imagebase64) {
        this.imagebase64 = imagebase64;
    }

    public String getSharecode() {
        return sharecode;
    }

    public void setSharecode(String sharecode) {
        this.sharecode = sharecode;
    }

    public String getMaskedAahaarNumber() {
        return maskedAahaarNumber;
    }

    public void setMaskedAahaarNumber(String maskedAahaarNumber) {
        this.maskedAahaarNumber = maskedAahaarNumber;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getZipFileBase64() {
        return zipFileBase64;
    }

    public void setZipFileBase64(String zipFileBase64) {
        this.zipFileBase64 = zipFileBase64;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipFilePath() {
        return zipFilePath;
    }

    public void setZipFilePath(String zipFilePath) {
        this.zipFilePath = zipFilePath;
    }

    public boolean isXmlVerify() {
        return isXmlVerify;
    }

    public void setXmlVerify(boolean xmlVerify) {
        isXmlVerify = xmlVerify;
    }

    public String getGenDate() {
        return genDate;
    }

    public void setGenDate(String genDate) {
        this.genDate = genDate;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMobileVerified() {
        return isMobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        isMobileVerified = mobileVerified;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getEmailHash() {
        return emailHash;
    }

    public void setEmailHash(String emailHash) {
        this.emailHash = emailHash;
    }

    public String getCareOf() {
        return careOf;
    }

    public String getHouse() {
        return house;
    }

    public String getLocality() {
        return locality;
    }

    public String getStreet() {
        return street;
    }

    public String getLandMark() {
        return landMark;
    }

    public String getVtc() {
        return vtc;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getPost() {
        return post;
    }

    public String getSubDist() {
        return subDist;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    /*@Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mobileHash);
        dest.writeByte((byte) (isEmailVerified ? 1 : 0));
        dest.writeString(imagebase64);
        dest.writeString(sharecode);
        dest.writeString(maskedAahaarNumber);
        dest.writeString(father);
        dest.writeString(gender);
        dest.writeString(zipFileBase64);
        dest.writeString(address);
        dest.writeString(zipFilePath);
        dest.writeByte((byte) (isXmlVerify ? 1 : 0));
        dest.writeString(genDate);
        dest.writeString(dob);
        dest.writeString(name);
        dest.writeByte((byte) (isMobileVerified ? 1 : 0));
        dest.writeByte((byte) (isError ? 1 : 0));
        dest.writeString(emailHash);
    }*/
}
