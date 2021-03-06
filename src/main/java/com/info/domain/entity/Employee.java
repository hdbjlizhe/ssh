package com.info.domain.entity;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="e_employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6740414617028525960L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // 用户ID-对应User.id
	private String name; // 姓名
	@ManyToOne
	private Department department; // 所在部门
	private boolean isFormal; // 是否在编
	private boolean isMale; // 是否男性
	@ManyToOne
	private Nation nation; // 民族
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date birthday; // 生日
	@ManyToOne
	private Party party; // 政治面貌
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date partyTime; // 党团时间
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date jobStartTime; // 参加工作时间
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date entryTime; // 工作调入时间
	@ManyToOne
	private Duty duty; // 当前职务
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date dutyTime; // 职务时间
	@ManyToOne
	private Rank rank; // 当前职级
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date rankTime; // 职级时间
	@ManyToOne
	private EduLevel fullTimeEdu; // 全日制学历
	@ManyToOne
	private EduLevel inServiceEdu; // 在职学历
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private Date createTime; // 创建时间
	
	public Employee() {
		super();
		this.setIsFormal(true);
		this.setIsMale(true);
	}
	//初始化函数，类似于清空
	public void init() {
		this.birthday=null;
		this.createTime=null;
		this.department=null;
		this.duty=null;
		this.dutyTime=null;
		this.entryTime=null;
		this.fullTimeEdu=null;
		this.inServiceEdu=null;
		this.isFormal=true;
		this.isMale=true;
		this.jobStartTime=null;
		this.name=null;
		this.nation=null;
		this.party=null;
		this.partyTime=null;
		this.rank=null;
		this.rankTime=null;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean getIsFormal() {
		return isFormal;
	}

	public void setIsFormal(boolean isFormal) {
		this.isFormal = isFormal;
	}

	public void setIsFormal(String isFormal) {
		if (isFormal != null && Integer.parseInt(isFormal) == 0)
			this.isFormal = false;
		else
			this.isFormal = true;

	}

	public boolean getIsMale() {
		return isMale;
	}

	public void setIsMale(boolean isMale) {
		this.isMale = isMale;
	}

	public void setIsMale(String isMale) {
		if (Integer.parseInt(isMale) == 0)
			this.isMale = false;
		else
			this.isMale = true;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Date getPartyTime() {
		return partyTime;
	}

	public void setPartyTime(Date partyTime) {
		this.partyTime = partyTime;
	}

	public Date getJobStartTime() {
		return jobStartTime;
	}

	public void setJobStartTime(Date jobStartTime) {
		this.jobStartTime = jobStartTime;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	public Date getDutyTime() {
		return dutyTime;
	}

	public void setDutyTime(Date dutyTime) {
		this.dutyTime = dutyTime;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Date getRankTime() {
		return rankTime;
	}

	public void setRankTime(Date rankTime) {
		this.rankTime = rankTime;
	}

	public EduLevel getFullTimeEdu() {
		return fullTimeEdu;
	}

	public void setFullTimeEdu(EduLevel fullTimeEdu) {
		this.fullTimeEdu = fullTimeEdu;
	}

	public EduLevel getInServiceEdu() {
		return inServiceEdu;
	}

	public void setInServiceEdu(EduLevel inServiceEdu) {
		this.inServiceEdu = inServiceEdu;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + name + ", department=" + department + ", isFormal=" + isFormal
				+ ", isMale=" + isMale + ", nation=" + nation + ", birthday=" + birthday + ", party=" + party
				+ ", partyTime=" + partyTime + ", jobStartTime=" + jobStartTime + ", entryTime=" + entryTime + ", duty="
				+ duty + ", dutyTime=" + dutyTime + ", rank=" + rank + ", rankTime=" + rankTime + ", fullTimeEdu="
				+ fullTimeEdu + ", inServiceEdu=" + inServiceEdu + ", createTime=" + createTime + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee employee=(Employee)obj;
			if(this.getId().equals(employee.getId()))
				return true;
			else
				return false;
		}else
			return false;
	}
}
