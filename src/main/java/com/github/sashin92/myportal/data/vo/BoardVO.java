package com.github.sashin92.myportal.data.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardVO {
	private Integer no;
	private String title;
	private String content;
	private Integer hit;
	private Timestamp regDate;
	private Integer userNo;
	private String userName;
	
	
}
