package com.info.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MonthStatisticsPhotoDTO {
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int photoMeeting;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int photoActivity;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int photoImgNum;
	@NotEmpty
	@NotNull
	@Digits(fraction=0,integer=0)
	private int photoVideoNum;
}
