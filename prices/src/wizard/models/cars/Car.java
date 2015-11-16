package wizard.models.cars;

import wizard.models.common.CommonTableModel;
import wizard.models.common.Municipality;
import wizard.models.common.TaxPeriod;
import wizard.models.common.TransportVehicle;
import db.StringWrapper;

public class Car extends CommonTableModel{


	private Municipality municipality = new Municipality();
	private TaxPeriod   taxperiod = new TaxPeriod();
	private String seNo = "";
	private TransportVehicle  trasportVehicle = new TransportVehicle();
	
	
	private StringWrapper measureFrom  = new StringWrapper("", true);    //       VARCHAR2(20 CHAR),
	private StringWrapper measureTo   = new StringWrapper("", true);       //  VARCHAR2(20 CHAR),
	private StringWrapper normValueFrom  = new StringWrapper("", true);  // NORMVALUEFROM     VARCHAR2(20 CHAR),
	private StringWrapper normValueTo  = new StringWrapper("", true);  //   NORMVALLUETO      VARCHAR2(20 CHAR),
	private StringWrapper priceValue  = new StringWrapper("", true); 
	private StringWrapper measureUnit  = new StringWrapper("", true);
	
	
	public Municipality getMunicipality() {
		return municipality;
	}
	public void setMunicipality(Municipality municipality) {
		this.municipality = municipality;
	}
	public TaxPeriod getTaxperiod() {
		return taxperiod;
	}
	public void setTaxperiod(TaxPeriod taxperiod) {
		this.taxperiod = taxperiod;
	}
	public String getSeNo() {
		return seNo;
	}
	public void setSeNo(String seNo) {
		this.seNo = seNo;
	}
	public TransportVehicle getTrasportVehicle() {
		return trasportVehicle;
	}
	public void setTrasportVehicle(TransportVehicle trasportVehicle) {
		this.trasportVehicle = trasportVehicle;
	}
	public StringWrapper getMeasureFrom() {
		return measureFrom;
	}
	public void setMeasureFrom(StringWrapper measureFrom) {
		this.measureFrom = measureFrom;
	}
	public StringWrapper getMeasureTo() {
		return measureTo;
	}
	public void setMeasureTo(StringWrapper measureTo) {
		this.measureTo = measureTo;
	}
	public StringWrapper getNormValueFrom() {
		return normValueFrom;
	}
	public void setNormValueFrom(StringWrapper normValueFrom) {
		this.normValueFrom = normValueFrom;
	}
	public StringWrapper getNormValueTo() {
		return normValueTo;
	}
	public void setNormValueTo(StringWrapper normValueTo) {
		this.normValueTo = normValueTo;
	}
	public StringWrapper getPriceValue() {
		return priceValue;
	}
	public void setPriceValue(StringWrapper priceValue) {
		this.priceValue = priceValue;
	}
	public StringWrapper getMeasureUnit() {
		return measureUnit;
	}
	public void setMeasureUnit(StringWrapper measureUnit) {
		this.measureUnit = measureUnit;
	} 
	 
	
	
	
	
	
	
	
	
	
	/*
	 * select c.cartaxprice_id, c.municipality_id, c.seqnumber, c.taxperiod_id, c.transpmeansreg_id, c.measurefrom, c.measureto,
c.normvaluefrom, c.normvallueto,
c.pricevalue,

tp.begin_date, tp.end_date,
m.fullname,
treg.name trname,
treg.type trtype

 from
cartaxprice c
left join taxperiod tp
on c.taxperiod_id = tp.taxperiod_id
left join municipality m on c.municipality_id = m.municipality_id
left join transpmeansreg treg on c.transpmeansreg_id = treg.transpmeansreg_id
order by c.taxperiod_id, treg.transpmeansreg_id, c.seqnumber
	 */
	
	
}
