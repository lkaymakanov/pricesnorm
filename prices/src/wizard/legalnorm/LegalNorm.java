package wizard.legalnorm;

import java.util.Date;

import wizard.models.common.CommonTableModel;
import db.StringWrapper;

public class LegalNorm extends CommonTableModel{
	

	private String name= "";
	private String note = "";
	
	private StringWrapper minValue = new StringWrapper("", true);
	private StringWrapper maxValue = new StringWrapper("", true);
	
	
	private Date begin_date;
	
	
	
	private long patent_activity_reg_id = -1;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(Date beginDate) {
		begin_date = beginDate;
	}
	public long getPatent_activity_reg_id() {
		return patent_activity_reg_id;
	}
	public void setPatent_activity_reg_id(long patentActivityRegId) {
		patent_activity_reg_id = patentActivityRegId;
	}
	public StringWrapper getMinValue() {
		return minValue;
	}
	public StringWrapper getMaxValue() {
		return maxValue;
	}
	public void setMinValue(StringWrapper minValue) {
		this.minValue = minValue;
	}
	public void setMaxValue(StringWrapper maxValue) {
		this.maxValue = maxValue;
	}

}
