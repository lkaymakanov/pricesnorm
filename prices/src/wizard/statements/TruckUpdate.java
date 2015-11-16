package wizard.statements;

import net.is_bg.ltf.db.common.UpdateSqlStatement;
import wizard.models.trucks.TruckTaxPrice;

public class TruckUpdate extends UpdateSqlStatement{
	
	private TruckTaxPrice t;
	
	public TruckUpdate(TruckTaxPrice t ){
		this.t = t;
	}

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		String sql = "";
		
		sql += " update trucktaxprice  "+
		" set hangingpfrom = "  + t.getHangingpfrom().getAsDouble() +
		" ,hangingpto =  " + t.getHangingpto().getAsDouble() +
		" ,hangotherfrom = " + t.getHangotherfrom().getAsDouble() +
		" ,hangotherto =  "+ t.getHangotherto().getAsDouble() +
		" where trucktaxprice_id = " + t.getId() ;
		
		return sql;
	}

}
