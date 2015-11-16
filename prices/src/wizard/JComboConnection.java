package wizard;

import net.is_bg.ltf.db.common.ConnectionProperties;
import swing.utils.JAbstractCombo;

public class JComboConnection extends JAbstractCombo{

	private static final long serialVersionUID = 1277684176130903529L;

	
	@Override
	public String getValToShow(int index) {
		// TODO Auto-generated method stub
		if(getSelObject() == null)
		return "No Items...";
		return ((ConnectionProperties)getSelObject()).getName_to_display();
	}
}
