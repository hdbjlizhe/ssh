package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;

public class MonthStatisticsNewsDTO {
	/**
	 * 新闻发布版块
	 */
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int webchatOriginal;	//
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int webchatTranspond;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int weiboOriginal;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int weiboTranspond;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int toutiaoOriginal;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int toutiaoTranspond;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int newsBoard;
	@NotEmpty
	@NotNull
	@Digits(fraction = 0, integer = 0)
	private int newsWebsite;

	
	public int getWebchatOriginal() {
		return webchatOriginal;
	}
	public void setWebchatOriginal(int webchatOriginal) {
		this.webchatOriginal = webchatOriginal;
	}
	public int getWebchatTranspond() {
		return webchatTranspond;
	}
	public void setWebchatTranspond(int webchatTranspond) {
		this.webchatTranspond = webchatTranspond;
	}
	public int getWeiboOriginal() {
		return weiboOriginal;
	}
	public void setWeiboOriginal(int weiboOriginal) {
		this.weiboOriginal = weiboOriginal;
	}
	public int getWeiboTranspond() {
		return weiboTranspond;
	}
	public void setWeiboTranspond(int weiboTranspond) {
		this.weiboTranspond = weiboTranspond;
	}
	public int getToutiaoOriginal() {
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
