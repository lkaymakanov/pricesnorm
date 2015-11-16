package wizard.statements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;
import net.is_bg.ltf.db.common.interfaces.IAbstractModel;
import wizard.models.config.Config;


public class ConfigSelect extends SelectSqlStatement{
	
	List<IAbstractModel> result = new ArrayList<IAbstractModel>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return "  select t.municipality_id , t.name n1, t.configvalue, "+
				"	m.fullname "+
				"	from config t "+
				"	left join municipality m "+
				"	on t.municipality_id = m.municipality_id "+
				"	order by t.name ";
	}
	
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int cnt = 1;
		while(rs.next()){
			Config c = new Config();
			c.setRownum(cnt++);
			c.getM().setId(rs.getLong("municipality_id"));
			c.getM().setName(rs.getString("fullname"));
			c.setNote(rs.getString("n1"));
			c.setName(rs.getString("n1"));
			c.setConfigValue(rs.getString("configvalue"));
			
			result.add(c);
		}
	}


	public List<IAbstractModel> getResult() {
		return result;
	}
	
	

}
