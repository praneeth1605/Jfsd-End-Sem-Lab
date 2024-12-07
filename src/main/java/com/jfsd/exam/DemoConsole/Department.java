package com.jfsd.exam.DemoConsole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dept_table")
public class Department 
{
	@Id
	@Column(name = "deptid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int deptid;
	@Column(name = "dname")
  private String dname;
	@Column(name = "location")
  private String location;
	@Column(name = "hname")
  private String hname;
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
}
