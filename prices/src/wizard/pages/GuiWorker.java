package wizard.pages;

import javax.swing.SwingWorker;
import wizard.pages.IGuiWorker.TASKS;

public class GuiWorker extends SwingWorker<String, Void>{
	
	private IGuiWorker  interf;
	private TASKS  task;
	
	

	
	//constructor
	public GuiWorker(IGuiWorker i, TASKS task){
		interf = i;
		this.task = task;
	}
	
	//things done in background
	@Override
    public String doInBackground() {
		interf.enableButtons(false);
		doProcess();
        return "Done";
    }

	
	//do the actual work
	private  void doProcess(){
		System.out.println("Entered in doProcess...");
		if(task == TASKS.LOAD_DATA_TABLES) interf.LoadTables();
		if(task == TASKS.UPDATE_LEGALNORM) interf.UpdateLegalNorm();
		if(task == TASKS.UPDATE_CONFIG) interf.UpdateConfig();
		if(task == TASKS.UPDATE_TRUCK) interf.UpdateTrucks();
		if(task == TASKS.UPDATE_CARS) interf.UpdateCar();
	}
	
	
	
	//finished processing
    @Override
    public void done() {
        try {
        	System.out.println("Entered in done...");
        	//enable buttons on finish
        	interf.enableButtons(true);
        } 
        catch (Exception ignore) 
        {
        	
        }
    }
}