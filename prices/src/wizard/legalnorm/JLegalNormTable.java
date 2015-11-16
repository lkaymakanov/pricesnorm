package wizard.legalnorm;

import java.awt.Dimension;
import javax.swing.JPanel;
import swing.utils.JAbstractColumn;
import wizard.models.common.JCommonTable;




public class JLegalNormTable extends JCommonTable{

	private static final long serialVersionUID = 4313551592747613867L;

	//the columns
	private static JAbstractColumn col [] = {
		    new JAbstractColumn("Ред №", 10, false),
			new JAbstractColumn("Дата", 10, false),
			new JAbstractColumn("Име", 10, false),
			new JAbstractColumn("Текст", 10, false),
			new JAbstractColumn("Мин. Ст.", 10, true),
			new JAbstractColumn("Макс. Ст.", 10, true)
	};
	
	

	public JLegalNormTable(JPanel panel, boolean superUsr) {
		super(panel, col, new Dimension(1100, 500), superUsr);
		
	}

	public JLegalNormTable(JPanel panel) {
		super(panel, col, new Dimension(1100, 500), false);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public MyTableModel getTableModel() {
		// TODO Auto-generated method stub
		if(model == null){
			model = new MyTableModel() {
				
				/**
				 * 
				 */
				private static final long serialVersionUID = -5422791099646542883L;

				@Override
				public void setValueAt(Object value, int row, int col) {
					// TODO Auto-generated method stub
					if(model.getData() == null) return ;
		            if (DEBUG) {
		                System.out.println("Setting value at " + row + "," + col
		                                   + " to " + value
		                                   + " (an instance of "
		                                   + value.getClass() + ")");
		            }
		 
		            //get user Object
		            LegalNorm object =  ((LegalNorm)model.getData()[row][0]);
		            
		            
		            if(col == 4) object.getMinValue().setVal(String.valueOf(value));
		            if(col == 5) object.getMaxValue().setVal(String.valueOf(value));
		            
		            
		            fireTableCellUpdated(row, col);
		 
		            if (DEBUG) {
		                System.out.println("New value of data:");
		                printDebugData();
		            }
				}
				
				@Override
				protected void printDebugData() {
					// TODO Auto-generated method stub
					
				}
			
				
				@Override
				public Object getValueAt(int row, int col) {
					// TODO Auto-generated method stub
					// TODO Auto-generated method stub
					if(model.getData() == null) return null;
		        	
		        	LegalNorm usrobj = (LegalNorm)model.getData()[row][0];
		        	if(col == 0) {return usrobj.getRownum();}
		        	if(col == 1) {return usrobj.getBegin_date();}
		        	if(col == 2) {return usrobj.getName();}
		        	if(col == 3) {return usrobj.getNote();}
		        	if(col == 4) {return usrobj.getMinValue().getAsBigDecimalDouble();}
		        	if(col == 5) {return usrobj.getMaxValue().getAsBigDecimalDouble();}
		        	
		            return null;
				}
			};
		}
		return model;
	}

}
