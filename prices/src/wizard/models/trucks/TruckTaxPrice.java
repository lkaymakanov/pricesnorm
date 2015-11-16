package wizard.models.trucks;

import wizard.models.common.CommonTableModel;
import wizard.models.common.Municipality;
import wizard.models.common.TaxPeriod;
import wizard.models.common.TransportVehicle;
import db.StringWrapper;

public class TruckTaxPrice extends CommonTableModel {


	
	private Municipality municipality = new Municipality();
	private TaxPeriod   taxperiod = new TaxPeriod();
	private String seqNo = "";
	private TransportVehicle  trasportVehicle = new TransportVehicle();
	
	
	private StringWrapper maxmassfrom  = new StringWrapper("", true);    //       VARCHAR2(20 CHAR),
	private StringWrapper maxmassto   = new StringWrapper("", true);       //  VARCHAR2(20 CHAR),
	
	private StringWrapper hangingpfrom  = new StringWrapper("", true);  // NORMVALUEFROM     VARCHAR2(20 CHAR),
	private StringWrapper hangingpto  = new StringWrapper("", true);  //   NORMVALLUETO      VARCHAR2(20 CHAR),
	
	
	private StringWrapper hangotherfrom  = new StringWrapper("", true);
	private StringWrapper hangotherto  = new StringWrapper("", true);
	private StringWrapper hangingptax  = new StringWrapper("", true);
	private StringWrapper hangothertax  = new StringWrapper("", true);
	
	
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
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public TransportVehicle getTrasportVehicle() {
		return trasportVehicle;
	}
	public void setTrasportVehicle(TransportVehicle trasportVehicle) {
		this.trasportVehicle = trasportVehicle;
	}
	public StringWrapper getMaxmassfrom() {
		return maxmassfrom;
	}
	public void setMaxmassfrom(StringWrapper maxmassfrom) {
		this.maxmassfrom = maxmassfrom;
	}
	public StringWrapper getMaxmassto() {
		return maxmassto;
	}
	public void setMaxmassto(StringWrapper maxmassto) {
		this.maxmassto = maxmassto;
	}
	public StringWrapper getHangingpfrom() {
		return hangingpfrom;
	}
	public void setHangingpfrom(StringWrapper hangingpfrom) {
		this.hangingpfrom = hangingpfrom;
	}
	public StringWrapper getHangingpto() {
		return hangingpto;
	}
	public void setHangingpto(StringWrapper hangingpto) {
		this.hangingpto = hangingpto;
	}


	public StringWrapper getHangotherfrom() {
		return hangotherfrom;
	}
	public void setHangotherfrom(StringWrapper hangotherfrom) {
		this.hangotherfrom = hangotherfrom;
	}
	public StringWrapper getHangotherto() {
		return hangotherto;
	}
	public void setHangotherto(StringWrapper hangotherto) {
		this.hangotherto = hangotherto;
	}
	public StringWrapper getHangingptax() {
		return hangingptax;
	}
	public void setHangingptax(StringWrapper hangingptax) {
		this.hangingptax = hangingptax;
	}
	public StringWrapper getHangothertax() {
		return hangothertax;
	}
	public void setHangothertax(StringWrapper hangothertax) {
		this.hangothertax = hangothertax;
	}
		
}
