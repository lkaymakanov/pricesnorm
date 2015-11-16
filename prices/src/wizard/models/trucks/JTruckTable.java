package wizard.models.trucks;

import java.awt.Dimension;

import javax.swing.JPanel;


import swing.utils.JAbstractColumn;
import wizard.models.common.JCommonTable;

public class JTruckTable extends JCommonTable {

	private static final long serialVersionUID = 2235091458993931742L;
		//the columns
		private static JAbstractColumn col [] ={
			    new JAbstractColumn("Ред №", 10, false), //0
				new JAbstractColumn("Период", 10, false), //1
				new JAbstractColumn("Община", 10, false), //2
				new JAbstractColumn("Тр. Средство", 10, false), //3
				new JAbstractColumn("Пореден №", 10, false), //4
				new JAbstractColumn("Доп.Макс. маса ОТ", 10, false),//5
				new JAbstractColumn("Доп.Макс. маса ДО", 10, false), //6
				new JAbstractColumn("Пневм. окачв. ОТ", 10, true), //7
				new JAbstractColumn("Пневм. окачв. ДО", 10, true), //8
				new JAbstractColumn("Др. окачв. ОТ", 10, true),//9
				new JAbstractColumn("Др. окачв. ДО", 10, true),//10
				new JAbstractColumn("Пневм. окачв. Цена", 10, true),//11
				new JAbstractColumn("Др. окачв. Цена", 10, true)	//12			
		};
		
		

		public JTruckTable(JPanel panel) {
			this(panel, false);
			// TODO Auto-generated constructor stub
		}
		
		public JTruckTable(JPanel panel, boolean superUsr) {
			super(panel, col, new Dimension(1100, 500), superUsr);
			// TODO Auto-generated constructor stub
		}

		@SuppressWarnings("unchecked")
		@Override
		public MyTableModel getTableModel() {
			// TODO Auto-generated method stub
			if(model == null){
				model = new MyTableModel() {
					
				
					private static final long serialVersionUID = -5683659865511441571L;

					@Override
					public void setValueAt(Object value, int row, int col) {
						// TODO Auto-generated method stub
						if(model.getData() == null) return ;
						// TODO Auto-generated method stub
						TruckTaxPrice object =  ((TruckTaxPrice)model.getData()[row][0]);
			            
				        if(col == 7)  object.getHangingpfrom().setVal(String.valueOf(value));
				        if(col == 8)  object.getHangingpto().setVal(String.valueOf(value));
				        if(col == 9)  object.getHangotherfrom().setVal(String.valueOf(value));
				        if(col == 10)  object.getHangotherto().setVal(String.valueOf(value));
				        
				        //super user
				        if(isSUPER_USER()){
				        	if(col == 11) { object.getHangingptax().setVal(String.valueOf(value));}
				        	if(col == 12) { object.getHangothertax().setVal(String.valueOf(value));}
				        }
			            
			            fireTableCellUpdated(row, col);
					}
					
					@Override
					protected void printDebugData() {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public Object getValueAt(int row, int col) {
						// TODO Auto-generated method stub
						if(model.getData() == null) return null;
			        	
			        	TruckTaxPrice obj = (TruckTaxPrice)model.getData()[row][0];
			        	
			        	if(col == 0) {return obj.getRownum();}
			        	if(col == 1) {return obj.getTaxperiod().getPeriod();}
			        	if(col == 2) {return obj.getMunicipality().getName();}
			        	if(col == 3) {return obj.getTrasportVehicle().getName();}
			        	if(col == 4) {return obj.getSeqNo();}
			        	    	
			        	if(col == 5) {return obj.getMaxmassfrom().getAsBigDecimalDouble();}
			        	if(col == 6) {return obj.getMaxmassto().getAsBigDecimalDouble();}
			        	if(col == 7) {return obj.getHangingpfrom().getAsBigDecimalDouble();}
			        	if(col == 8) {return obj.getHangingpto().getAsBigDecimalDouble();}
			        	
			        	if(col == 9) {return obj.getHangotherfrom().getAsBigDecimalDouble();}
			        	if(col == 10) {return obj.getHangotherto().getAsBigDecimalDouble();}
			        	if(col == 11) {return obj.getHangingptax().getAsBigDecimalDouble();}
			        	if(col == 12) {return obj.getHangothertax().getAsBigDecimalDouble();}
			        	
			            return null;
					}
				};
			}
			return model;
		}

}
