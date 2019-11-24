package com.tensquare.article.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "tb_article")
public class Article implements Serializable {

  @Id
  private String id;
  private String columnid;
  private String userid;
  private String title;
  private String content;
  private String image;
  private String createtime;
  private String updatetime;
  private String ispublic;
  private String istop;
  private String visits;
  private String thumbup;
  private String comment;
  private String state;
  private String channelid;
  private String url;
  private String type;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getColumnid() {
    return columnid;
  }

  public void setColumnid(String columnid) {
    this.columnid = columnid;
  }


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public String getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
  }

  public String getIspublic() {
    return ispublic;
  }

  public void setIspublic(String ispublic) {
    this.ispublic = ispublic;
  }


  public String getIstop() {
    return istop;
  }

  public void setIstop(String istop) {
    this.istop = istop;
  }


  public String getVisits() {
    return visits;
  }

  public void setVisits(String visits) {
    this.visits = visits;
  }


  public String getThumbup() {
    return thumbup;
  }

  public void setThumbup(String thumbup) {
    this.thumbup = thumbup;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getChannelid() {
    return channelid;
  }

  public void setChannelid(String channelid) {
    this.channelid = channelid;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
