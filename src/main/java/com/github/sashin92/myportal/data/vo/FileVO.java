package com.github.sashin92.myportal.data.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileVO {
	private Integer no;
	private String name;
	public FileVO(String name) {
		this.name = name;
	}
	
	
}
