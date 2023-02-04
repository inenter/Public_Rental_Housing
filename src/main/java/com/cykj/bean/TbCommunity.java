package com.cykj.bean;


public class TbCommunity {

  private int communityId;
  private int toAreaId;
  private String communityName;
  private String comState;
  private String address;
  private String comImages;
  private int parkingNum;

  public TbCommunity() {
  }

  public TbCommunity(int communityId, int toAreaId, String communityName, String comState, String address, String comImages, int parkingNum) {
    this.communityId = communityId;
    this.toAreaId = toAreaId;
    this.communityName = communityName;
    this.comState = comState;
    this.address = address;
    this.comImages = comImages;
    this.parkingNum = parkingNum;
  }

  @Override
  public String toString() {
    return "TbCommunity{" +
            "communityId=" + communityId +
            ", toAreaId=" + toAreaId +
            ", communityName='" + communityName + '\'' +
            ", comState='" + comState + '\'' +
            ", address='" + address + '\'' +
            ", comImages='" + comImages + '\'' +
            ", parkingNum=" + parkingNum +
            '}';
  }

  public int getCommunityId() {
    return communityId;
  }

  public void setCommunityId(int communityId) {
    this.communityId = communityId;
  }

  public int getToAreaId() {
    return toAreaId;
  }

  public void setToAreaId(int toAreaId) {
    this.toAreaId = toAreaId;
  }

  public String getCommunityName() {
    return communityName;
  }

  public void setCommunityName(String communityName) {
    this.communityName = communityName;
  }

  public String getComState() {
    return comState;
  }

  public void setComState(String comState) {
    this.comState = comState;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getComImages() {
    return comImages;
  }

  public void setComImages(String comImages) {
    this.comImages = comImages;
  }

  public int getParkingNum() {
    return parkingNum;
  }

  public void setParkingNum(int parkingNum) {
    this.parkingNum = parkingNum;
  }
}
