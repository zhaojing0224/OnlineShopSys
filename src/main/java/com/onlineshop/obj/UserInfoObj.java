package com.onlineshop.obj;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserInfoObj {

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

}
