package wizard.models.common;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import swing.utils.JAbstractColumn;
import swing.utils.JAbstractTable;

public abstract class JCommonTable extends JAbstractTable{

	private static final long serialVersionUID = -6183069482558704642L;
	private int selRow = -1;  //index of selected Row
	private boolean SUPER_USER = false;   //change almost everything + insert or delete
	
	public JCommonTable(JPanel panel, JAbstractColumn[] cols, Dimension d) {
		this(panel, cols, d, false);
	}
	
	public JCommonTable(JPanel panel, JAbstractColumn[] cols, Dimension d, boolean superUser) {
		super(panel, cols, d);
		
		getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				 selRow  =  getSelectedRow();
			}
		});
		SUPER_USER = superUser;
		// TODO Auto-generated constructor stub
	}
	
	
	


	@Override
	public void editingStopped(ChangeEvent e) {
		// TODO Auto-generated method stub
		super.editingStopped(e);
		
		System.out.println("Selected row = " + selRow);
		
		if(selRow == -1) return;
		
		//get table model model
		MyTableModel model = getTableModel();
		
		//get model in row & set to edited
		((CommonTableModel)model.getData()[selRow][0]).setEdited(true);
		
	}

	public boolean isSUPER_USER() {
		return SUPER_USER;
	}
	
}
