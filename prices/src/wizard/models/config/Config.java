package wizard.models.config;

import wizard.models.common.CommonTableModel;
import wizard.models.common.Municipality;

public class Config  extends CommonTableModel{


	private Municipality m = new Municipality();
	private String note = "";
	private String configValue= "";
	private String name = "";
	
	
	
	
	
	
	
	
	public Municipality getM() {
		return m;
	}
	public void setM(Municipality m) {
		this.m = m;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
