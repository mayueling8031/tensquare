package com.tensquare.qa.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {

    private static final long serialVersionUID = 4870749384561036587L;
    @Id
  private String problemid;
  @Id
  private String labelid;


  public String getProblemid() {
    return problemid;
  }

  public void setProblemid(String problemid) {
    this.problemid = problemid;
  }


  public String getLabelid() {
    return labelid;
  }

  public void setLabelid(String labelid) {
    this.labelid = labelid;
  }

}
