package com.tensquare.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_user")
public class User {

  @Id
  private String id;
  private String mobile;
  private String password;
  private String nickname;
  private String sex;
  private Date birthday;
  private String avatar;
  private String email;
  private Date regdate;
  private Date updatedate;
  private Date lastdate;
  private String online;
  private String interest;
  private String personality;
  private String fanscount;
  private String followcount;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getRegdate() {
    return regdate;
  }

  public void setRegdate(Date regdate) {
    this.regdate = regdate;
  }

  public Date getUpdatedate() {
    return updatedate;
  }

  public void setUpdatedate(Date updatedate) {
    this.updatedate = updatedate;
  }

  public Date getLastdate() {
    return lastdate;
  }

  public void setLastdate(Date lastdate) {
    this.lastdate = lastdate;
  }

  public String getOnline() {
    return online;
  }

  public void setOnline(String online) {
    this.online = online;
  }

  public String getInterest() {
    return interest;
  }

  public void setInterest(String interest) {
    this.interest = interest;
  }

  public String getPersonality() {
    return personality;
  }

  public void setPersonality(String personality) {
    this.personality = personality;
  }

  public String getFanscount() {
    return fanscount;
  }

  public void setFanscount(String fanscount) {
    this.fanscount = fanscount;
  }

  public String getFollowcount() {
    return followcount;
  }

  public void setFollowcount(String followcount) {
    this.followcount = followcount;
  }

  @Override
  public String toString() {
    return "User{" +
            "id='" + id + '\'' +
            ", mobile='" + mobile + '\'' +
            ", password='" + password + '\'' +
            ", nickname='" + nickname + '\'' +
            ", sex='" + sex + '\'' +
            ", birthday=" + birthday +
            ", avatar='" + avatar + '\'' +
            ", email='" + email + '\'' +
            ", regdate=" + regdate +
            ", updatedate=" + updatedate +
            ", lastdate=" + lastdate +
            ", online='" + online + '\'' +
            ", interest='" + interest + '\'' +
            ", personality='" + personality + '\'' +
            ", fanscount='" + fanscount + '\'' +
            ", followcount='" + followcount + '\'' +
            '}';
  }
}