package wizard.statements;

import net.is_bg.ltf.db.common.UpdateSqlStatement;
import wizard.legalnorm.LegalNorm;
import db.StringWrapper;

public class LegalNormUpdate extends UpdateSqlStatement{

	LegalNorm norm;
	
	public LegalNormUpdate(LegalNorm norm){
		this.norm = norm;
		swapValues();
		
	}
	
	
	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return  "  update legalnorm  "+
				"  set minvalue = " + norm.getMinValue().getAsDouble() +
				 " ,maxvalue = " + norm.getMaxValue().getAsDouble() +
				 " where legalnorm_id = " + norm.getId();
	}
	
	
	private void swapValues(){
		StringWrapper hlp;
		if(norm.getMinValue().getAsDouble() >  norm.getMaxValue().getAsDouble()){
			hlp = norm.getMaxValue();
			norm.setMaxValue(norm.getMinValue());
			norm.setMinValue(hlp);
		}
	}
	

}
