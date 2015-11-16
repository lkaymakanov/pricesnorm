package wizard;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenHandler implements ActionListener{

	Wizard w;
	
	public ActionListenHandler(){
		w = Wizard.getWizard();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 Component c = (Component)arg0.getSource();
		 handleAction(c);
	}
	
	
	//handle actions of components
	public void handleAction(Component c) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 if(c.getName() == null) return;
		
		 //wizard button
		 if(c.getName().equals("btnConnect") || c.getName().equals("btnBack") || c.getName().equals("btnNext")){
			 w.wizbuttonPushed(c.getName());
		 }
		
		 
		 if(c.getName().equals("rFile")){
			 w.getConnPage().radioFile();
		 }
		 
		 if(c.getName().equals("rSpec")){
			 w.getConnPage().radioSpec();
		 }
		 
		 if(c.getName().equals("rOrcl")){
			 w.getConnPage().radioOrcl();
		 }
		 if(c.getName().equals("rPgr")){
			 w.getConnPage().radioPgr();
		 }
		
		 if(c.getName().equals("openfdlg")){
			 w.getConnPage().openFile();
		 }
			 
	}

	
	
	
}
