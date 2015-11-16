package wizard.models.common;

import db.AbstractModel;





public class Province extends  AbstractModel{
	private String ekatte;
	private String name;
	private String code;
	
	public Province(long id, 
					String ekatte, 
					String name, 
					String code) {
		super(id);
		this.ekatte = ekatte;
		this.name = name;
		this.code = code;
	}
	
	public Province() {
		//nothing
	}

	public String getEkatte() {
		return ekatte;
	}

	public void setEkatte(String ekatte) {
		this.ekatte = ekatte;
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
	
	
}
