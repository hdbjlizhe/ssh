package com.info.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.info.utils.OfficeDocUtil;

/***
 * 
 * 公文
 * @author GeeLee
 *
 */
@Entity
@Table(name="o_docs")
public class OfficeDoc implements Serializable {
			
	/**
	 * 
	 */
	private static final long serialVersionUID = -2649480858060103158L;
	//id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long id;
	
	private String uuid;
	//密级
	private Integer securityLevel;
	//紧急程度
	private Integer emergency;
	//同号文件顺序号（）
	private Integer indexNum;
	//发文单位（应该是个集合）<set>（联合发文时）
	private String fromDepartment;
	//签发人
	private String signer;
	//文种
	private Integer type;
	//发文字号
	private String issuedNumber;
	//文件标题
	private String subject;
	//主送机关：<set>
	private String toDepartment;
	//正文
	private String content;
	//附件标题
	private String attachments;
	//发放范围
	private String scope;
	//行文时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate;
	//主题词
	private String keyWords;
	//抄送机关
	private String copyDepartments;
	//印制机关
	private String prtDepartment;
	//印发时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prtDateTime;
	//份数
	private Integer copies;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Integer getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(Integer securityLevel) {
		this.securityLevel = securityLevel;
	}
	
	public Integer getEmergency() {
		return emergency;
	}
	public void setEmergency(Integer emergency) {
		this.emergency = emergency;
	}
	
	public Integer getIndexNum() {
		return indexNum;
	}
	public void setIndexNum(Integer indexNum) {
		this.indexNum = indexNum;
	}
	
	public String[] getFromDepartment() {
		return fromDepartment.split(",");
	}
	public void setFromDepartment(String[] fromDepartment) {
		this.fromDepartment=OfficeDocUtil.strArrayConnect(fromDepartment);
	}
	
	public String getSigner() {
		return signer;
	}
	public void setSigner(String signer) {
		this.signer = signer;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getIssuedNumber() {
		return issuedNumber;
	}
	public void setIssuedNumber(String issuedNumber) {
		this.issuedNumber = issuedNumber;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String[] getToDepartment() {
		return toDepartment.split(",");
	}
	public void setToDepartment(String[] toDepartment) {
		this.toDepartment = OfficeDocUtil.strArrayConnect(toDepartment);
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String[] getAttachments() {
		return attachments.split(",");
	}
	public void setAttachments(String[] attachments) {
		this.attachments = OfficeDocUtil.strArrayConnect(attachments);
	}
	
	public String[] getScope() {
		return scope.split(",");
	}
	public void setScope(String[] scope) {
		this.scope = OfficeDocUtil.strArrayConnect(scope);
	}
	
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	public String[] getKeyWords() {
		return keyWords.split(",");
	}
	public void setKeyWords(String[] keyWords) {
		this.keyWords = OfficeDocUtil.strArrayConnect(keyWords);
	}
	
	public String[] getCopyDepartments() {
		return copyDepartments.split(",");
	}
	public void setCopyDepartments(String[] copyDepartments) {
		this.copyDepartments = OfficeDocUtil.strArrayConnect(copyDepartments);
	}
	
	public String getPrtDepartment() {
		return prtDepartment;
	}
	public void setPrtDepartment(String prtDepartment) {
		this.prtDepartment = prtDepartment;
	}
	
	public Date getPrtDateTime() {
		return prtDateTime;
	}
	public void setPrtDateTime(Date prtDateTime) {
		this.prtDateTime = prtDateTime;
	}
	
	public Integer getCopies() {
		return copies;
	}
	public void setCopies(Integer copies) {
		this.copies = copies;
	}
		
}
