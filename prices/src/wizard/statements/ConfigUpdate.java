package wizard.statements;

import net.is_bg.ltf.db.common.UpdateSqlStatement;
import wizard.models.config.Config;

public class ConfigUpdate extends UpdateSqlStatement{
	
	private Config c;
	
	public ConfigUpdate(Config c){
		this.c = c;
	}

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		String sql = "";
		sql+=   " update config "+ 
				" set configvalue = '" + c.getConfigValue() + "'" +
				" where coalesce(municipality_id, -1) || coalesce(name, '-1') = '" + c.getM().getId() + c.getName()+"'";
		
		return sql;
	}
	
}
