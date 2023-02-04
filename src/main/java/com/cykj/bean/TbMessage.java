package com.cykj.bean;


import java.sql.Timestamp;

public class TbMessage {

  private int messageId;
  private int renterId;
  private int managerId;
  private java.sql.Timestamp creatTime;
  private String messageText;
  private String messageState;

  public TbMessage() {
  }

  public TbMessage(int messageId, int renterId, int managerId, Timestamp creatTime, String messageText, String messageState) {
    this.messageId = messageId;
    this.renterId = renterId;
    this.managerId = managerId;
    this.creatTime = creatTime;
    this.messageText = messageText;
    this.messageState = messageState;
  }

  @Override
  public String toString() {
    return "TbMessage{" +
            "messageId=" + messageId +
            ", renterId=" + renterId +
            ", managerId=" + managerId +
            ", creatTime=" + creatTime +
            ", messageText='" + messageText + '\'' +
            ", messageState='" + messageState + '\'' +
            '}';
  }

  public int getMessageId() {
    return messageId;
  }

  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  public int getRenterId() {
    return renterId;
  }

  public void setRenterId(int renterId) {
    this.renterId = renterId;
  }

  public int getManagerId() {
    return managerId;
  }

  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }

  public Timestamp getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(Timestamp creatTime) {
    this.creatTime = creatTime;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public String getMessageState() {
    return messageState;
  }

  public void setMessageState(String messageState) {
    this.messageState = messageState;
  }
}
