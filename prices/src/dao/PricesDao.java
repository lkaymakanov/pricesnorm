package dao;

import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.AbstractMainDao;
import net.is_bg.ltf.db.common.DBStatement;
import net.is_bg.ltf.db.common.interfaces.IAbstractModel;
import net.is_bg.ltf.db.common.interfaces.IConnectionFactory;
import wizard.legalnorm.LegalNorm;
import wizard.statements.CarsSelect;
import wizard.statements.ConfigSelect;
import wizard.statements.LegalnormSelect;
import wizard.statements.TruckSelect;

public class PricesDao extends AbstractMainDao{

	public PricesDao(IConnectionFactory c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	
	//load legal norm table
	public List<IAbstractModel> LoadLegalNorm(){
		LegalnormSelect sel = new LegalnormSelect();
		execute(sel);
		return sel.getResult();
	}
	
	//update legal norm
	public void UpdateLegalNorm(List<IAbstractModel> list){
		if(list == null) return;
 		List<DBStatement> dbst = new ArrayList<DBStatement>();
		
		for(int i =0 ; i < list.size(); i++)
		dbst.add(new wizard.statements.LegalNormUpdate((LegalNorm)list.get(i)));
	
		execute(dbst);
	}

	//update legal norm
	public void UpdateTable(List<DBStatement> list){
		if(list == null) return;
		execute(list);
	}
	

	
	
	//load config table
	public List<IAbstractModel> LoadConfig(){
		ConfigSelect sel = new ConfigSelect();
		execute(sel);
		return sel.getResult();
	}
	

	//load cartaxprice table
	public List<IAbstractModel> LoadCarTaxPrice(){
		CarsSelect sel = new CarsSelect();
		execute(sel);
		return sel.getResult();
	}
	
	
	//load truck taxprice table
	public List<IAbstractModel> LoadTruckTaxPrice(){
		TruckSelect sel = new TruckSelect();
		execute(sel);
		return sel.getResult();
	}
	

	

}
