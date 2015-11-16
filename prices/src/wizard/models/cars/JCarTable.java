package wizard.models.cars;


import java.awt.Dimension;

import javax.swing.JPanel;

import swing.utils.JAbstractColumn;
import wizard.models.common.JCommonTable;

public class JCarTable extends JCommonTable{

	private static final long serialVersionUID = -279601542709945587L;
	//the columns
	private static JAbstractColumn col [] ={
		    new JAbstractColumn("Ред №", 10, true),
			new JAbstractColumn("Период", 10, true),
			new JAbstractColumn("Община", 10, true),
			new JAbstractColumn("Тр. Средство", 10, true),
			new JAbstractColumn("Порден №", 10, true),
			new JAbstractColumn("Мярка От", 10, true),
			new JAbstractColumn("Мярка До", 10, true),
			new JAbstractColumn("Норм. Размер ОТ", 10, true),
			new JAbstractColumn("Норм. Размер ДО", 10, true),
			new JAbstractColumn("Цена", 10, true)
	};
	
	

	public JCarTable(JPanel panel) {
		this(panel,false);
	}
	
	public JCarTable(JPanel panel, boolean superUsr) {
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
					Car obj = (Car)model.getData()[row][0];
					
					if(col == 7) { obj.getNormValueFrom().setVal(String.valueOf(value));}
		        	if(col == 8) { obj.getNormValueTo().setVal(String.valueOf(value));}
		        	
		        	//super user
		        	if(isSUPER_USER()){
		        		if(col == 9) obj.getPriceValue().setVal(String.valueOf(value));
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
		        	
		        	Car obj = (Car)model.getData()[row][0];
		        	if(col == 0) {return obj.getRownum();}
		        	if(col == 1) {return obj.getTaxperiod().getPeriod();}
		        	if(col == 2) {return obj.getMunicipality().getName();}
		        	if(col == 3) {return obj.getTrasportVehicle().getName();}
		        	if(col == 4) {return obj.getSeNo();}
		        	if(col == 5) {return obj.getMeasureFrom().getAsBigDecimalDouble();}
		        	if(col == 6) {return obj.getMeasureTo().getAsBigDecimalDouble();}
		        	if(col == 7) {return obj.getNormValueFrom().getAsBigDecimalDouble();}
		        	if(col == 8) {return obj.getNormValueTo().getAsBigDecimalDouble();}
		        	if(col == 9) {return obj.getPriceValue().getAsBigDecimalDouble();}
		        	
		            return null;
				}
			};
		}
		return model;
	}

}
