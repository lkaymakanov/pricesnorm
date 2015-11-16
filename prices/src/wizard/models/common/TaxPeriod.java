package wizard.models.common;


import java.text.SimpleDateFormat;
import java.util.Date;

import db.AbstractModel;


public class TaxPeriod extends AbstractModel{

	private Date beginDate;
	private Date endDate;
	private String typekind;
	private String period;
	private boolean firstline = false; 

	public String getPeriod() {	
		if(firstline) return "------";	
			SimpleDateFormat daytime = new SimpleDateFormat("dd.MM.yyyy");	
			if(this.getBeginDate() != null  && this.getEndDate() != null)
			period = daytime.format(this.getBeginDate()) + "   " +  daytime.format(this.getEndDate());		
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTypekind() {
		return typekind;
	}
	public void setTypekind(String typekind) {
		this.typekind = typekind;
	}

	public boolean isFirstline() {
		return firstline;
	}

	public void setFirstline(boolean firstline) {
		this.firstline = firstline;
	}


}
