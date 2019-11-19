package com.tensquare.recruit.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_enterprise")
public class Enterprise implements Serializable {

    private static final long serialVersionUID = -4725727561163553395L;
    @Id
  private String id;

  private String name;
  private String summary;
  private String address;
  private String labels;
  private String coordinate;
  private String ishot;
  private String logo;
  private String jobcount;
  private String url;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getLabels() {
    return labels;
  }

  public void setLabels(String labels) {
    this.labels = labels;
  }


  public String getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(String coordinate) {
    this.coordinate = coordinate;
  }


  public String getIshot() {
    return ishot;
  }

  public void setIshot(String ishot) {
    this.ishot = ishot;
  }


  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }


  public String getJobcount() {
    return jobcount;
  }

  public void setJobcount(String jobcount) {
    this.jobcount = jobcount;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
