package com.info.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="m_statistics")
public class MonthStatistics {
	
	private Date month;
	
}
