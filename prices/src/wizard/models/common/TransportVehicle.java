package wizard.models.common;

import db.AbstractModel;

public class TransportVehicle extends AbstractModel{

	//Types of transportMeans
		public final static String  LEKI = "1";
		public final static String  BEZLEKI = "2";
		public final static String  PLAVATELNI = "3";
		public final static String  VAZDUHOPLAVATELNI = "4";
		
		private String code;
		private String name;
		private String type;
		private String typecode;
		
		public TransportVehicle(long id,
								String code, 
								String name, 
								String type,
								String typecode) {
			setId(id);
			this.code = code;
			this.name = name;
			this.type = type;
			this.typecode = typecode;
		}
		
		public TransportVehicle() {
			//nothing
		}
		
		public String getTypecode() {
			return typecode;
		}
		public void setTypecode(String typecode) {
			this.typecode = typecode;
		}

		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
			
}
