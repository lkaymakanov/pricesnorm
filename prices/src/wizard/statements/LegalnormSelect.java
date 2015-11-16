package wizard.statements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;
import net.is_bg.ltf.db.common.interfaces.IAbstractModel;
import wizard.legalnorm.LegalNorm;


public class LegalnormSelect extends SelectSqlStatement{
	
	List<IAbstractModel> result = new  ArrayList<IAbstractModel>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select t.legalnorm_id, " +
				" t.name name1, " +
				" t.note n1,  " +
				" t.minvalue mval, " +
				" t.maxvalue maxval," +
				" t.begindate begdate "+
			" from legalnorm t order by t.begindate, t.note ";
	}
	
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int cnt = 1;
		while(rs.next()){
			LegalNorm l = new LegalNorm();
			l.setRownum(cnt++);
			l.setId(rs.getLong("legalnorm_id"));
			l.setName(rs.getString("name1"));
			l.setNote(rs.getString("n1"));
			l.getMinValue().setVal(rs.getString("mval"));
			l.getMaxValue().setVal(rs.getString("maxval"));
			l.setBegin_date(rs.getDate("begdate"));
			result.add(l);
		}
	}


	public List<IAbstractModel> getResult() {
		// TODO Auto-generated method stub
		return result;
	}

}
