package wizard.models.config;

import java.awt.Dimension;

import javax.swing.JPanel;

import swing.utils.JAbstractColumn;
import wizard.models.common.JCommonTable;

public class JConfigTable extends JCommonTable{


	private static final long serialVersionUID = 5364731136364337090L;
	
	//the columns
	private static JAbstractColumn col [] ={
			new JAbstractColumn("Ред №", 10, false), 
			new JAbstractColumn("Обшина", 10, false),
			new JAbstractColumn("Име", 10, true),
			new JAbstractColumn("Стойност", 10, true)
	};
	

	public JConfigTable(JPanel panel, boolean superUsr) {
		super(panel, col,  new Dimension(1100, 500), superUsr);
		// TODO Auto-generated constructor stub
	}
	
	public JConfigTable(JPanel panel){
		this(panel, false);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public MyTableModel getTableModel() {
		// TODO Auto-generated method stub
		if(model == null){
			model = new MyTableModel() {
				
				private static final long serialVersionUID = -2866736698914952914L;

				@Override
				public void setValueAt(Object value, int row, int col) {
					
					if(model.getData() == null) return ;
					// TODO Auto-generated method stub
					Config object =  ((Config)model.getData()[row][0]);
		            
			        if(col == 3)  object.setConfigValue(String.valueOf(value));
			        
			        //super user
			        if(isSUPER_USER()){
			        	if(col == 2)  object.setNote(String.valueOf(value));
			        }
		            
		            fireTableCellUpdated(row, col);
				}
				
			
				
				@Override
				public Object getValueAt(int row, int col) {
					// TODO Auto-generated method stub
					if(model.getData() == null) return null;
		        	
		        	Config obj = (Config)model.getData()[row][0];
		        	if(col == 0) {return obj.getRownum();}
		        	if(col == 1) {return obj.getM().getName();}
		        	if(col == 2) {return obj.getNote();}
		        	if(col == 3) {return obj.getConfigValue();}
		        	
		        	
		            return null;
				}



				@Override
				protected void printDebugData() {
					// TODO Auto-generated method stub
					
				}
			};
		}
		return model;
	}


}
