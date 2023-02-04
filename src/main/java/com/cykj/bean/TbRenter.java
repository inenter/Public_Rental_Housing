package com.cykj.bean;


public class TbRenter {

  private int renterId;
  private String renterAcc;
  private String renterPwd;
  private String renterName;
  private String renterTel;
  private String renterIdNum;
  private String contactAddr;

  public TbRenter() {
  }

  public TbRenter(int renterId, String renterAcc, String renterPwd, String renterName, String renterTel, String renterIdNum, String contactAddr) {
    this.renterId = renterId;
    this.renterAcc = renterAcc;
    this.renterPwd = renterPwd;
    this.renterName = renterName;
    this.renterTel = renterTel;
    this.renterIdNum = renterIdNum;
    this.contactAddr = contactAddr;
  }

  @Override
  public String toString() {
    return "TbRenter{" +
            "renterId=" + renterId +
            ", renterAcc='" + renterAcc + '\'' +
            ", renterPwd='" + renterPwd + '\'' +
            ", renterName='" + renterName + '\'' +
            ", renterTel='" + renterTel + '\'' +
            ", renterIdNum='" + renterIdNum + '\'' +
            ", contactAddr='" + contactAddr + '\'' +
            '}';
  }

  public int getRenterId() {
    return renterId;
  }

  public void setRenterId(int renterId) {
    this.renterId = renterId;
  }

  public String getRenterAcc() {
    return renterAcc;
  }

  public void setRenterAcc(String renterAcc) {
    this.renterAcc = renterAcc;
  }

  public String getRenterPwd() {
    return renterPwd;
  }

  public void setRenterPwd(String renterPwd) {
    this.renterPwd = renterPwd;
  }

  public String getRenterName() {
    return renterName;
  }

  public void setRenterName(String renterName) {
    this.renterName = renterName;
  }

  public String getRenterTel() {
    return renterTel;
  }

  public void setRenterTel(String renterTel) {
    this.renterTel = renterTel;
  }

  public String getRenterIdNum() {
    return renterIdNum;
  }

  public void setRenterIdNum(String renterIdNum) {
    this.renterIdNum = renterIdNum;
  }

  public String getContactAddr() {
    return contactAddr;
  }

  public void setContactAddr(String contactAddr) {
    this.contactAddr = contactAddr;
  }
}
