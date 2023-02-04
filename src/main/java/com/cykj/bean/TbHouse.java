package com.cykj.bean;


public class TbHouse {

  private int houseId;
  private int toCommunityId;
  private int buildingNum;
  private String houseNum;
  private double houseArea;
  private double money;
  private int roomNum;
  private int washroomNum;
  private int livingroomNum;
  private int kitchenNum;
  private int balconyNum;
  private String remark;
  private String images;
//  private TbCommunity tbCommunity;
  private String houseType;
  private int communityId;
  private int toAreaId;
  private String communityName;
  private String address;
  private String comImages;
  private int parkingNum;

  public TbHouse() {
  }

  public TbHouse(int houseId, int toCommunityId, int buildingNum, String houseNum, double houseArea, double money, int roomNum, int washroomNum, int livingroomNum, int kitchenNum, int balconyNum, String remark, String images, String houseType, int communityId, int toAreaId, String communityName, String address, String comImages, int parkingNum) {
    this.houseId = houseId;
    this.toCommunityId = toCommunityId;
    this.buildingNum = buildingNum;
    this.houseNum = houseNum;
    this.houseArea = houseArea;
    this.money = money;
    this.roomNum = roomNum;
    this.washroomNum = washroomNum;
    this.livingroomNum = livingroomNum;
    this.kitchenNum = kitchenNum;
    this.balconyNum = balconyNum;
    this.remark = remark;
    this.images = images;
    this.houseType = houseType;
    this.communityId = communityId;
    this.toAreaId = toAreaId;
    this.communityName = communityName;
    this.address = address;
    this.comImages = comImages;
    this.parkingNum = parkingNum;
  }

  @Override
  public String toString() {
    return "TbHouse{" +
            "houseId=" + houseId +
            ", toCommunityId=" + toCommunityId +
            ", buildingNum=" + buildingNum +
            ", houseNum='" + houseNum + '\'' +
            ", houseArea=" + houseArea +
            ", money=" + money +
            ", roomNum=" + roomNum +
            ", washroomNum=" + washroomNum +
            ", livingroomNum=" + livingroomNum +
            ", kitchenNum=" + kitchenNum +
            ", balconyNum=" + balconyNum +
            ", remark='" + remark + '\'' +
            ", images='" + images + '\'' +
            ", houseType='" + houseType + '\'' +
            ", communityId=" + communityId +
            ", toAreaId=" + toAreaId +
            ", communityName='" + communityName + '\'' +
            ", address='" + address + '\'' +
            ", comImages='" + comImages + '\'' +
            ", parkingNum=" + parkingNum +
            '}';
  }

  public int getHouseId() {
    return houseId;
  }

  public void setHouseId(int houseId) {
    this.houseId = houseId;
  }


  public int getToCommunityId() {
    return toCommunityId;
  }

  public void setToCommunityId(int toCommunityId) {
    this.toCommunityId = toCommunityId;
  }

  public int getBuildingNum() {
    return buildingNum;
  }

  public void setBuildingNum(int buildingNum) {
    this.buildingNum = buildingNum;
  }


  public String getHouseNum() {
    return houseNum;
  }

  public void setHouseNum(String houseNum) {
    this.houseNum = houseNum;
  }


  public double getHouseArea() {
    return houseArea;
  }

  public void setHouseArea(double houseArea) {
    this.houseArea = houseArea;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public int getRoomNum() {
    return roomNum;
  }

  public void setRoomNum(int roomNum) {
    this.roomNum = roomNum;
  }


  public int getWashroomNum() {
    return washroomNum;
  }

  public void setWashroomNum(int washroomNum) {
    this.washroomNum = washroomNum;
  }


  public int getLivingroomNum() {
    return livingroomNum;
  }

  public void setLivingroomNum(int livingroomNum) {
    this.livingroomNum = livingroomNum;
  }


  public int getKitchenNum() {
    return kitchenNum;
  }

  public void setKitchenNum(int kitchenNum) {
    this.kitchenNum = kitchenNum;
  }


  public int getBalconyNum() {
    return balconyNum;
  }

  public void setBalconyNum(int balconyNum) {
    this.balconyNum = balconyNum;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public String getHouseType() {
    return houseType;
  }

  public void setHouseType() {
    this.houseType = this.roomNum + "室" + this.livingroomNum + "厅" + this.washroomNum + "卫";
  }

  //  public TbCommunity getTbCommunity() {
//    return tbCommunity;
//  }

//  public void setTbCommunity(TbCommunity tbCommunity) {
//    this.tbCommunity = tbCommunity;
//  }


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
