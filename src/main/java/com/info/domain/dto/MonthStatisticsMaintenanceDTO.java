package com.info.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthStatisticsMaintenanceDTO {

	private Long id;
	@NotEmpty
	@NotNull
	private Integer maintenanceHardware;
	@NotEmpty
	@NotNull
	private Integer maintenanceSoftware;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMaintenanceHardware() {
		return maintenanceHardware;
	}
	public void setMaintenanceHardware(Integer maintenanceHardware) {
		this.maintenanceHardware = maintenanceHardware;
	}
	public int getMaintenanceSoftware() {
		return maintenanceSoftware;
	}
	public void setMaintenanceSoftware(Integer maintenanceSoftware) {
		this.maintenanceSoftware = maintenanceSoftware;
	}
	
}
