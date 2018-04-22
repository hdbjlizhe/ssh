package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;

public class MonthStatisticsNewsDTO {
	/**
	 * 新闻发布版块
	 */
	private Long id;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer webchatOriginal;	//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer webchatTranspond;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer weiboOriginal;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer weiboTranspond;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer toutiaoOriginal;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer toutiaoTranspond;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer newsBoard;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private Integer newsWebsite;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getWebchatOriginal() {
		return webchatOriginal;
	}
	public void setWebchatOriginal(Integer webchatOriginal) {
		this.webchatOriginal = webchatOriginal;
	}
	public Integer getWebchatTranspond() {
		return webchatTranspond;
	}
	public void setWebchatTranspond(Integer webchatTranspond) {
		this.webchatTranspond = webchatTranspond;
	}
	public Integer getWeiboOriginal() {
		return weiboOriginal;
	}
	public void setWeiboOriginal(Integer weiboOriginal) {
		this.weiboOriginal = weiboOriginal;
	}
	public Integer getWeiboTranspond() {
		return weiboTranspond;
	}
	public void setWeiboTranspond(Integer weiboTranspond) {
		this.weiboTranspond = weiboTranspond;
	}
	public Integer getToutiaoOriginal() {
		return toutiaoOriginal;
	}
	public void setToutiaoOriginal(int toutiaoOriginal) {
		this.toutiaoOriginal = toutiaoOriginal;
	}
	public int getToutiaoTranspond() {
		return toutiaoTranspond;
	}
	public void setToutiaoTranspond(int toutiaoTranspond) {
		this.toutiaoTranspond = toutiaoTranspond;
	}
	public int getNewsBoard() {
		return newsBoard;
	}
	public void setNewsBoard(int newsBoard) {
		this.newsBoard = newsBoard;
	}
	public int getNewsWebsite() {
		return newsWebsite;
	}
	public void setNewsWebsite(int newsWebsite) {
		this.newsWebsite = newsWebsite;
	}
	
}
