package db;

import net.is_bg.ltf.db.common.interfaces.IAbstractModel;

public class AbstractModel implements IAbstractModel {
	
	private long id;
	private long index;
	
	public AbstractModel() {
		// TODO Auto-generated constructor stub
	}
	

	public AbstractModel(long id) {
		// TODO Auto-generated constructor stub
		this.id= id;
	}
	

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public long getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public void setId(long arg0) {
		// TODO Auto-generated method stub
		this.id = arg0;
	}

	@Override
	public void setIndex(long arg0) {
		// TODO Auto-generated method stub
		this.index = arg0;
	}

}
