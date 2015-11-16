package wizard.statements;

import net.is_bg.ltf.db.common.UpdateSqlStatement;
import wizard.models.cars.Car;

public class CarUpdate extends UpdateSqlStatement{
	
	private Car c;
	
	public CarUpdate(Car c){
		this.c = c;
	}

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		String sql = "";
		sql = "  update  cartaxprice "+
               " set normvaluefrom = " + c.getNormValueFrom().getAsDouble()+
               " ,normvallueto = "+ c.getNormValueTo().getAsDouble() +
               " where cartaxprice_id = " + 	c.getId();
		return sql;
	}

}
