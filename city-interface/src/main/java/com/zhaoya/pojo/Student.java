package com.zhaoya.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zhuzg
 *
 */
public class Student implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5496098667910033955L;
	
	private Integer id;
	private String headerImg;
	
	private int shengId;
	private int shiId;
	private int xianId;
	
	private Area sheng;
	private Area shi;
	private Area xian;
	
	public Area getSheng() {
		return sheng;
	}
	public void setSheng(Area sheng) {
		this.sheng = sheng;
	}
	public Area getShi() {
		return shi;
	}
	public void setShi(Area shi) {
		this.shi = shi;
	}
	public Area getXian() {
		return xian;
	}
	public void setXian(Area xian) {
		this.xian = xian;
	}
	private String name;
	
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHeaderImg() {
		return headerImg;
	}
	public void setHeaderImg(String headerImg) {
		this.headerImg = headerImg;
	}
	public int getShengId() {
		return shengId;
	}
	public void setShengId(int shengId) {
		this.shengId = shengId;
	}
	public int getShiId() {
		return shiId;
	}
	public void setShiId(int shiId) {
		this.shiId = shiId;
	}
	public int getXianId() {
		return xianId;
	}
	public void setXianId(int xianId) {
		this.xianId = xianId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((headerImg == null) ? 0 : headerImg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sheng == null) ? 0 : sheng.hashCode());
		result = prime * result + shengId;
		result = prime * result + ((shi == null) ? 0 : shi.hashCode());
		result = prime * result + shiId;
		result = prime * result + ((xian == null) ? 0 : xian.hashCode());
		result = prime * result + xianId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (headerImg == null) {
			if (other.headerImg != null)
				return false;
		} else if (!headerImg.equals(other.headerImg))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sheng == null) {
			if (other.sheng != null)
				return false;
		} else if (!sheng.equals(other.sheng))
			return false;
		if (shengId != other.shengId)
			return false;
		if (shi == null) {
			if (other.shi != null)
				return false;
		} else if (!shi.equals(other.shi))
			return false;
		if (shiId != other.shiId)
			return false;
		if (xian == null) {
			if (other.xian != null)
				return false;
		} else if (!xian.equals(other.xian))
			return false;
		if (xianId != other.xianId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", headerImg=" + headerImg + ", name=" + name + ", createTime=" + createTime + "]";
	}
	
	
	
	
	
	

}
