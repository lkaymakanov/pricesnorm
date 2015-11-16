package wizard.models.common;

import net.is_bg.ltf.db.common.interfaces.IAbstractModel;


public class CommonTableModel implements IAbstractModel{

	/**
	 * 
	 */
	private boolean edited = false;
	private long id;
	
	private int rownum ;
	
	public boolean isEdited() {
		return edited;
	}
	public void setEdited(boolean edited) {
		this.edited = edited;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public long getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setId(long arg0) {
		// TODO Auto-generated method stub
		this.id = arg0;
	}
	@Override
	public void setIndex(long arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
