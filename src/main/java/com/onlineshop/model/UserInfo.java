package com.onlineshop.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfo {
	
	@Id
	private String userId;

	private String userName;

	private Integer sex;

	private Date birth;

	private String postCode;

	private String todoufuken;

	private String shikucyouson;

	private String cyoumebanchi;

	private String roomNumber;

	private String phoneNumber;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@Column(name = "update_date")
	private LocalDateTime updateDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTodoufuken() {
		return todoufuken;
	}

	public void setTodoufuken(String todoufuken) {
		this.todoufuken = todoufuken;
	}

	public String getShikucyouson() {
		return shikucyouson;
	}

	public void setShikucyouson(String shikucyouson) {
		this.shikucyouson = shikucyouson;
	}

	public String getCyoumebanchi() {
		return cyoumebanchi;
	}

	public void setCyoumebanchi(String cyoumebanchi) {
		this.cyoumebanchi = cyoumebanchi;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

}
