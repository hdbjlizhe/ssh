package com.info.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="m_statistics")
public class MonthStatistics {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true)
	@Size(max=6,min=6)
	private String month;//格式：201802
	
	/**
	 * 党务版块
	 */
	//理论学习次数
	private int partyStudy;
	//党务会议次数
	private int partyMeeting;
	//党组织活动次数
	private int partyActivity;
	
	/**
	 * 往来公文版块
	 */
	//处理公文项数
	private int docOffice;
	//配合相关处室完成工作
	private int docDepart;
	
	/**
	 * 例会版块
	 */
	//例会次数
	private int affairs;
	
	/**
	 * 新闻发布版块
	 */
	private int webchatOriginal;	//
	private int webchatTranspond;
	private int weiboOriginal;
	private int weiboTranspond;
	private int toutiaoOriginal;
	private int toutiaoTranspond;
	private int newsBoard;
	private int newsWebsite;
	/**
	 * 局官网政策维护版块
	 */
	private int websiteProfile;//
	private int websiteInvestBeijing;//
	private int websiteInteraction;//
	private int websiteMatters;//
	private int websiteParty;//
	private int websiteInfo;//
	/**
	 * 民间投资平台版块
	 */
	private int nongovernDevelopPlanning;
	private int nongovernInvestPolicy;
	private int nongovernAuthoritylicense;
	private int nongovernMarketAccess;
	private int nongovernInvestOpportunity;
	private int nongovernInvestService;
	/**
	 * 软硬件维护版块
	 */
	private int maintenanceHardware;
	private int maintenanceSoftware;
	/**
	 * 产业招商精准招商版块
	 */
	private int fbaseNew;
	/**
	 * 网络与信息安全
	 */
	private int securityAttackBlock;
	private int securitySystemReinforce;
	private int securitySafetyMessage;
	private int securityBugScan;
	private int securityBugNum;
	private int securityWebsiteTrouble;
	private int securityGlobalTrouble;
	/**
	 * 摄影摄像
	 */
	private int photoMeeting;
	private int photoActivity;
	private int photoImgNum;
	private int photoVideoNum;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getPartyStudy() {
		return partyStudy;
	}
	public void setPartyStudy(int partyStudy) {
		this.partyStudy = partyStudy;
	}
	public int getPartyMeeting() {
		return partyMeeting;
	}
	public void setPartyMeeting(int partyMeeting) {
		this.partyMeeting = partyMeeting;
	}
	public int getPartyActivity() {
		return partyActivity;
	}
	public void setPartyActivity(int partyActivity) {
		this.partyActivity = partyActivity;
	}
	public int getDocOffice() {
		return docOffice;
	}
	public void setDocOffice(int docOffice) {
		this.docOffice = docOffice;
	}
	public int getDocDepart() {
		return docDepart;
	}
	public void setDocDepart(int docDepart) {
		this.docDepart = docDepart;
	}
	public int getAffairs() {
		return affairs;
	}
	public void setAffairs(int affairs) {
		this.affairs = affairs;
	}
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
	public int getWebsiteProfile() {
		return websiteProfile;
	}
	public void setWebsiteProfile(int websiteProfile) {
		this.websiteProfile = websiteProfile;
	}
	public int getWebsiteInvestBeijing() {
		return websiteInvestBeijing;
	}
	public void setWebsiteInvestBeijing(int websiteInvestBeijing) {
		this.websiteInvestBeijing = websiteInvestBeijing;
	}
	public int getWebsiteInteraction() {
		return websiteInteraction;
	}
	public void setWebsiteInteraction(int websiteInteraction) {
		this.websiteInteraction = websiteInteraction;
	}
	public int getWebsiteMatters() {
		return websiteMatters;
	}
	public void setWebsiteMatters(int websiteMatters) {
		this.websiteMatters = websiteMatters;
	}
	public int getWebsiteParty() {
		return websiteParty;
	}
	public void setWebsiteParty(int websiteParty) {
		this.websiteParty = websiteParty;
	}
	public int getWebsiteInfo() {
		return websiteInfo;
	}
	public void setWebsiteInfo(int websiteInfo) {
		this.websiteInfo = websiteInfo;
	}
	public int getNongovernDevelopPlanning() {
		return nongovernDevelopPlanning;
	}
	public void setNongovernDevelopPlanning(int nongovernDevelopPlanning) {
		this.nongovernDevelopPlanning = nongovernDevelopPlanning;
	}
	public int getNongovernInvestPolicy() {
		return nongovernInvestPolicy;
	}
	public void setNongovernInvestPolicy(int nongovernInvestPolicy) {
		this.nongovernInvestPolicy = nongovernInvestPolicy;
	}
	public int getNongovernAuthoritylicense() {
		return nongovernAuthoritylicense;
	}
	public void setNongovernAuthoritylicense(int nongovernAuthoritylicense) {
		this.nongovernAuthoritylicense = nongovernAuthoritylicense;
	}
	public int getNongovernMarketAccess() {
		return nongovernMarketAccess;
	}
	public void setNongovernMarketAccess(int nongovernMarketAccess) {
		this.nongovernMarketAccess = nongovernMarketAccess;
	}
	public int getNongovernInvestOpportunity() {
		return nongovernInvestOpportunity;
	}
	public void setNongovernInvestOpportunity(int nongovernInvestOpportunity) {
		this.nongovernInvestOpportunity = nongovernInvestOpportunity;
	}
	public int getNongovernInvestService() {
		return nongovernInvestService;
	}
	public void setNongovernInvestService(int nongovernInvestService) {
		this.nongovernInvestService = nongovernInvestService;
	}
	public int getMaintenanceHardware() {
		return maintenanceHardware;
	}
	public void setMaintenanceHardware(int maintenanceHardware) {
		this.maintenanceHardware = maintenanceHardware;
	}
	public int getMaintenanceSoftware() {
		return maintenanceSoftware;
	}
	public void setMaintenanceSoftware(int maintenanceSoftware) {
		this.maintenanceSoftware = maintenanceSoftware;
	}
	public int getFbaseNew() {
		return fbaseNew;
	}
	public void setFbaseNew(int fbaseNew) {
		this.fbaseNew = fbaseNew;
	}
	public int getSecurityAttackBlock() {
		return securityAttackBlock;
	}
	public void setSecurityAttackBlock(int securityAttackBlock) {
		this.securityAttackBlock = securityAttackBlock;
	}
	public int getSecuritySystemReinforce() {
		return securitySystemReinforce;
	}
	public void setSecuritySystemReinforce(int securitySystemReinforce) {
		this.securitySystemReinforce = securitySystemReinforce;
	}
	public int getSecuritySafetyMessage() {
		return securitySafetyMessage;
	}
	public void setSecuritySafetyMessage(int securitySafetyMessage) {
		this.securitySafetyMessage = securitySafetyMessage;
	}
	public int getSecurityBugScan() {
		return securityBugScan;
	}
	public void setSecurityBugScan(int securityBugScan) {
		this.securityBugScan = securityBugScan;
	}
	public int getSecurityBugNum() {
		return securityBugNum;
	}
	public void setSecurityBugNum(int securityBugNum) {
		this.securityBugNum = securityBugNum;
	}
	public int getSecurityWebsiteTrouble() {
		return securityWebsiteTrouble;
	}
	public void setSecurityWebsiteTrouble(int securityWebsiteTrouble) {
		this.securityWebsiteTrouble = securityWebsiteTrouble;
	}
	public int getSecurityGlobalTrouble() {
		return securityGlobalTrouble;
	}
	public void setSecurityGlobalTrouble(int securityGlobalTrouble) {
		this.securityGlobalTrouble = securityGlobalTrouble;
	}
	public int getPhotoMeeting() {
		return photoMeeting;
	}
	public void setPhotoMeeting(int photoMeeting) {
		this.photoMeeting = photoMeeting;
	}
	public int getPhotoActivity() {
		return photoActivity;
	}
	public void setPhotoActivity(int photoActivity) {
		this.photoActivity = photoActivity;
	}
	public int getPhotoImgNum() {
		return photoImgNum;
	}
	public void setPhotoImgNum(int photoImgNum) {
		this.photoImgNum = photoImgNum;
	}
	public int getPhotoVideoNum() {
		return photoVideoNum;
	}
	public void setPhotoVideoNum(int photoVideoNum) {
		this.photoVideoNum = photoVideoNum;
	}
	@Override
	public String toString() {
		return "MonthStatistics [id=" + id + ", month=" + month + ", partyStudy=" + partyStudy + ", partyMeeting="
				+ partyMeeting + ", partyActivity=" + partyActivity + ", docOffice=" + docOffice + ", docDepart="
				+ docDepart + ", affairs=" + affairs + ", webchatOriginal=" + webchatOriginal + ", webchatTranspond="
				+ webchatTranspond + ", weiboOriginal=" + weiboOriginal + ", weiboTranspond=" + weiboTranspond
				+ ", toutiaoOriginal=" + toutiaoOriginal + ", toutiaoTranspond=" + toutiaoTranspond + ", newsBoard="
				+ newsBoard + ", newsWebsite=" + newsWebsite + ", websiteProfile=" + websiteProfile
				+ ", websiteInvestBeijing=" + websiteInvestBeijing + ", websiteInteraction=" + websiteInteraction
				+ ", websiteMatters=" + websiteMatters + ", websiteParty=" + websiteParty + ", websiteInfo="
				+ websiteInfo + ", nongovernDevelopPlanning=" + nongovernDevelopPlanning + ", nongovernInvestPolicy="
				+ nongovernInvestPolicy + ", nongovernAuthoritylicense=" + nongovernAuthoritylicense
				+ ", nongovernMarketAccess=" + nongovernMarketAccess + ", nongovernInvestOpportunity="
				+ nongovernInvestOpportunity + ", nongovernInvestService=" + nongovernInvestService
				+ ", maintenanceHardware=" + maintenanceHardware + ", maintenanceSoftware=" + maintenanceSoftware
				+ ", fbaseNew=" + fbaseNew + ", securityAttackBlock=" + securityAttackBlock
				+ ", securitySystemReinforce=" + securitySystemReinforce + ", securitySafetyMessage="
				+ securitySafetyMessage + ", securityBugScan=" + securityBugScan + ", securityBugNum=" + securityBugNum
				+ ", securityWebsiteTrouble=" + securityWebsiteTrouble + ", securityGlobalTrouble="
				+ securityGlobalTrouble + ", photoMeeting=" + photoMeeting + ", photoActivity=" + photoActivity
				+ ", photoImgNum=" + photoImgNum + ", photoVideoNum=" + photoVideoNum + "]";
	}
	
	
}
