package wizard.statements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;
import net.is_bg.ltf.db.common.interfaces.IAbstractModel;
import wizard.models.trucks.TruckTaxPrice;


public class TruckSelect extends SelectSqlStatement{
	
	List<IAbstractModel> result = new  ArrayList<IAbstractModel>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select tr.trucktaxprice_id, tr.municipality_id, tr.taxperiod_id, tr.transpmeansreg_id, "+
				"	tr.axes_number,  tr.seqnumber, "+
				"   tr.maxmassfrom, tr.maxmassto,"+
				"	tr.hangingpfrom, tr.hangingpto, "+
				"	tr.hangotherfrom, tr.hangotherto, "+
				"	tr.hangingptax, tr.hangothertax, "+
				"	m.fullname, treg.name trname, treg.type trtype, tp.begin_date, tp.end_date "+
					
				"	from trucktaxprice tr "+
				"	left join taxperiod tp on "+ 
				"	tr.taxperiod_id = tp.taxperiod_id "+
				"	left join municipality m on  "+
				"	tr.municipality_id = m.municipality_id "+
				"	left join transpmeansreg treg on tr.transpmeansreg_id = treg.transpmeansreg_id "+
				"	order by tr.taxperiod_id, tr.transpmeansreg_id, tr.seqnumber ";
	}
	
	
	
	
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int cnt = 1;
		while(rs.next()){
			
			TruckTaxPrice  c = new TruckTaxPrice();
			c.setRownum(cnt++);
			c.setId(rs.getLong("trucktaxprice_id"));
			c.getMunicipality().setId(rs.getLong("municipality_id"));
			c.getMunicipality().setName(rs.getString("fullname"));
			c.getTaxperiod().setBeginDate(rs.getDate("begin_date"));
			c.getTaxperiod().setEndDate(rs.getDate("end_date"));
			c.setId(rs.getLong("taxperiod_id"));
			c.setSeqNo(rs.getString("seqnumber"));
			c.getMaxmassfrom().setVal(rs.getString("maxmassfrom"));
			c.getMaxmassto().setVal(rs.getString("maxmassto"));
			c.getHangingpfrom().setVal(rs.getString("hangingpfrom"));
			c.getHangingpto().setVal(rs.getString("hangingpto"));
			c.getHangotherfrom().setVal(rs.getString("hangotherfrom"));
			c.getHangotherto().setVal(rs.getString("hangotherto"));
			c.getTrasportVehicle().setId(rs.getLong("transpmeansreg_id"));
			c.getTrasportVehicle().setName(rs.getString("trname"));
			c.getTrasportVehicle().setType(rs.getString("trtype"));
			c.getHangingptax().setVal(rs.getString("hangingptax"));
			c.getHangothertax().setVal(rs.getString("hangothertax"));
			
			result.add(c);
			
		}
	}





	public List<IAbstractModel> getResult() {
		return result;
	}
	
	

}
