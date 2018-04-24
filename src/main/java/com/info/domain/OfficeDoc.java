package com.info.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.info.domain.entity.Department;

/***
 * 
 * 公文
 * @author GeeLee
 *
 */
//@Entity
//@Table(name="o_docs")
public class OfficeDoc {
			
	//id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//密级
	private Integer securityLevel;  
	//紧急程度
	private Integer emergency;
	//同号文件顺序号（）
	private Integer index;
	//发文单位（应该是个集合）<set>（联合发文时）
	private Set<Integer> from;
	//签发人
	private String signer;
	//文种
	private Integer type;
	//发文字号
	private String issuedNumber;
	//文件标题
	private String subject;
	//主送机关：<set>
	private String[] to;
	//正文
	private String content;
	//附件标题
	private String[] attachments;
	//发放范围
	
	//行文时间
	private Date writeDate;
	//主题词
	private Set<String> keywords;
	//抄送机关
	private Set<Department> departments;
	//印制机关
	private Department prtDepartment;
	//印发时间
	private DateTime prtDateTime;
	//份数
	private Integer copies;
	
	
}
