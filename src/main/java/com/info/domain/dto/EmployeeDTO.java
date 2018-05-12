package com.info.domain.dto;

public class EmployeeDTO {
	private String id;
	private String dept;//Department
	private String name;//Name
	private String formal;//Is Formal
	private String sex;//Sex
	private String nation;//Nation
	private String birth;//Birth
	private String party;//Party
	private String partyTime;//Party Time
	private String jobStartTime;
	private String entryTime;
	private String duty;
	private String dutyTime;
	private String rank;
	private String rankTime;
	private String fullTimeEdu;
	private String inServiceEdu;
	private String createTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormal() {
		return formal;
	}
	public void setFormal(String formal) {
		this.formal = formal;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getPartyTime() {
		return partyTime;
	}
	public void setPartyTime(String partyTime) {
		this.partyTime = partyTime;
	}
	public String getJobStartTime() {
		return jobStartTime;
	}
	public void setJobStartTime(String jobStartTime) {
		this.jobStartTime = jobStartTime;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getDutyTime() {
		return dutyTime;
	}
	public void setDutyTime(String dutyTime) {
		this.dutyTime = dutyTime;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getRankTime() {
		return rankTime;
	}
	public void setRankTime(String rankTime) {
		this.rankTime = rankTime;
	}
	public String getFullTimeEdu() {
		return fullTimeEdu;
	}
	public void setFullTimeEdu(String fullTimeEdu) {
		this.fullTimeEdu = fullTimeEdu;
	}
	public String getInServiceEdu() {
		return inServiceEdu;
	}
	public void setInServiceedu(String inServiceEdu) {
		this.inServiceEdu = inServiceEdu;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", dept=" + dept + ", name=" + name + ", formal=" + formal + ", sex=" + sex
				+ ", nation=" + nation + ", birth=" + birth + ", party=" + party + ", partyTime=" + partyTime
				+ ", jobStartTime=" + jobStartTime + ", entryTime=" + entryTime + ", duty=" + duty + ", dutyTime="
				+ dutyTime + ", rank=" + rank + ", rankTime=" + rankTime + ", fullTimeEdu=" + fullTimeEdu
				+ ", inServiceedu=" + inServiceEdu + ", createTime=" + createTime + "]";
	}
	
}
