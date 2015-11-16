package wizard.models.common;

import db.AbstractModel;



public class Municipality extends AbstractModel {
	private String fullName;
	private String name;
	private String code;
	private String ebk;
	private String url;
	private long parentMunicipalityId;
	
	private Province province = new Province();
	
	public Municipality(long id, 
						String fullName, 
						String name, 
						String code,
						String ebk, 
						String url, 
						long parentMunicipalityId,
						Province province) {
		super(id);
		this.fullName = fullName;
		this.name = name;
		this.code = code;
		this.ebk = ebk;
		this.url = url;
		this.parentMunicipalityId = parentMunicipalityId;
		this.province = province;
	}
	
	public Municipality(){
		//nothing
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = (fullName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = (name);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEbk() {
		return ebk;
	}

	public void setEbk(String ebk) {
		this.ebk = ebk;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getParentMunicipalityId() {
		return parentMunicipalityId;
	}

	public void setParentMunicipalityId(long parentMunicipalityId) {
		this.parentMunicipalityId = parentMunicipalityId;
	}

	
}
