package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MonthStatisticsPhotoDTO {

	private Long id;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer photoMeeting;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer photoActivity;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer photoImgNum;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private Integer photoVideoNum;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPhotoMeeting() {
		return photoMeeting;
	}
	public void setPhotoMeeting(Integer photoMeeting) {
		this.photoMeeting = photoMeeting;
	}
	public Integer getPhotoActivity() {
		return photoActivity;
	}
	public void setPhotoActivity(Integer photoActivity) {
		this.photoActivity = photoActivity;
	}
	public Integer getPhotoImgNum() {
		return photoImgNum;
	}
	public void setPhotoImgNum(Integer photoImgNum) {
		this.photoImgNum = photoImgNum;
	}
	public Integer getPhotoVideoNum() {
		return photoVideoNum;
	}
	public void setPhotoVideoNum(Integer photoVideoNum) {
		this.photoVideoNum = photoVideoNum;
	}
	
	
}
