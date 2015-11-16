package wizard.statements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;
import net.is_bg.ltf.db.common.interfaces.IAbstractModel;
import wizard.models.cars.Car;


public class CarsSelect  extends SelectSqlStatement{
	
	List<IAbstractModel> result = new  ArrayList<IAbstractModel>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select c.cartaxprice_id, c.municipality_id, c.seqnumber, c.taxperiod_id, c.transpmeansreg_id, c.measurefrom, c.measureto, "+
				" c.normvaluefrom, c.normvallueto, "+
				" c.pricevalue, "+
				
				" tp.begin_date, tp.end_date, "+
				" m.fullname, "+
				" treg.name trname, "+
				" treg.type trtype "+
				
				" from "+
				" cartaxprice c "+
				" left join taxperiod tp "+
				" on c.taxperiod_id = tp.taxperiod_id "+
				" left join municipality m on c.municipality_id = m.municipality_id "+
				" left join transpmeansreg treg on c.transpmeansreg_id = treg.transpmeansreg_id" +
				" order by c.taxperiod_id, treg.transpmeansreg_id, c.seqnumber";
	}

	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int cnt = 1;
		while(rs.next()){
			
			Car  c = new Car();
			c.setRownum(cnt++);
			c.setId(rs.getLong("cartaxprice_id"));
			c.getMunicipality().setId(rs.getLong("municipality_id"));
			c.getMunicipality().setName(rs.getString("fullname"));
			c.getTaxperiod().setBeginDate(rs.getDate("begin_date"));
			c.getTaxperiod().setEndDate(rs.getDate("end_date"));
			c.setId(rs.getLong("taxperiod_id"));
			c.setSeNo(rs.getString("seqnumber"));
			c.getMeasureFrom().setVal(rs.getString("measurefrom"));
			c.getMeasureTo().setVal(rs.getString("measureto"));
			c.getNormValueFrom().setVal(rs.getString("normvaluefrom"));
			c.getNormValueTo().setVal(rs.getString("normvallueto"));
			c.getPriceValue().setVal(rs.getString("pricevalue"));
			c.getTrasportVehicle().setId(rs.getLong("transpmeansreg_id"));
			c.getTrasportVehicle().setName(rs.getString("trname"));
			c.getTrasportVehicle().setType(rs.getString("trtype"));
			
			result.add(c);
		}
	}

	public List<IAbstractModel> getResult() {
		return result;
	}
	
	
}
