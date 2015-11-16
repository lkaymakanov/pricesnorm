package wizard;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.is_bg.ltf.db.common.ConnectionProperties;
import net.is_bg.ltf.db.common.DBConfig;
import net.is_bg.ltf.db.common.DBStatement;
import net.is_bg.ltf.db.common.impl.DataSourceConnectionFactoryDrManager;
import net.is_bg.ltf.db.common.impl.logging.LogFactorySystemOut;
import net.is_bg.ltf.db.common.impl.timer.ElapsedTimer;
import net.is_bg.ltf.db.common.impl.visit.VisitEmpty;
import net.is_bg.ltf.db.common.interfaces.IConnectionFactory;
import net.is_bg.ltf.db.common.interfaces.timer.IElaplsedTimer;
import net.is_bg.ltf.db.common.interfaces.timer.IElaplsedTimerFactory;
import net.is_bg.ltf.db.common.interfaces.visit.IVisit;
import net.is_bg.ltf.db.common.interfaces.visit.IVisitFactory;
import swing.utils.WizardButtons;
import wizard.legalnorm.LegalNorm;
import wizard.models.cars.Car;
import wizard.models.config.Config;
import wizard.models.trucks.TruckTaxPrice;
import wizard.pages.ConnectionPage;
import wizard.pages.GuiWorker;
import wizard.pages.IGuiWorker;
import wizard.pages.Page;
import wizard.pages.PageCallBack;
import wizard.pages.PricesNormPage;
import wizard.statements.CarUpdate;
import wizard.statements.ConfigUpdate;
import wizard.statements.TruckUpdate;
import dao.PricesDao;


public class Wizard extends JFrame implements IConnectionFactory , IGuiWorker{
	
	

	private static final long serialVersionUID = 1782579312920885244L;
	
	
	CardLayout card ;
	JPanel wizpanel;
	
	//action listener 
	ActionListenHandler wizListener;
	
	
	
	//the pages
	ConnectionPage connPage;
	PricesNormPage pricesPage;
	
	
	
	//wizard sizes
	Dimension dLittle = new Dimension(400, 260);
	Dimension dBig = new Dimension(700, 600);
	Dimension dBtabs = new Dimension(1150, 650);
	
	//the handler of page buttons click
	PageCallBackHandler pageCallBack;
	
	//the navigation buttons
	WizardButtons buttons = new WizardButtons();
	
	//navigation button panel
	JPanel buttonp = new JPanel();
	
	//the list with pages in wizard
	List<Page> pages = new ArrayList<Page>();
	
	
	PricesDao dao ;
			
	//the wizard itself
	private static Wizard wizard = null;
	private static boolean superUsr = false;
	
	
	//public  DBTYPE dbType = DBTYPE.ORCL;
	
	
	//constructor
	public Wizard() {
		// TODO Auto-generated constructor stub
		super("LAK Change Prices Norm Util ©");
	}

	//let it be a singleton pattern
	public static Wizard getWizard(){
		if(wizard == null) wizard = new Wizard();
		return wizard;
	}
		
	
	
	//Program Entry 
	public static void main(String []args){
		
		if(args != null && args.length > 0){
			for(int i =0 ; i< args.length; i++){
				if(args[i] != null && args[i].toLowerCase().contains("super")){
					superUsr = true;
					
					break;
				}
			}
		}
		
		if(superUsr == true){
			System.out.println("SuperUser");
		}else{
			System.out.println("not SuperUser");
		}
		//use the system style for GUI
	    final boolean  SYSTEM_LOOK_AND_FEEL = true;
		try {
			if(SYSTEM_LOOK_AND_FEEL)
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Wizard.getWizard();  //invoke this to initialize wizard reference
		wizard.init();
	}
	
	
	//set sizes & show wizard frame
	public void showWiz(){
		setSize(dLittle);
		setResizable(false);
		setVisible(true);
	}
	
	//init wizard
	private void init(){
		wizListener = new ActionListenHandler();
		
		wizpanel = new JPanel();
		
		card = new CardLayout();   //use card layout to switch panels
		wizpanel.setLayout(card);
		getContentPane().add(BorderLayout.CENTER, wizpanel);
		
		//this isn't probably the best GUI face made :)
	    getContentPane().add(BorderLayout.SOUTH,buttonp);
	    
	    //register buttons listener
	    buttons.AddActionListenter(wizListener);
	    
	    //init to first page
	    getCallBack().setStateFirstPage();
	    
	    //add the buttons to panel
		buttonp.add(buttons.getBtnBack());
		buttonp.add(buttons.getBtnConnect());
		buttonp.add(buttons.getBtnNext());
		
		
		//create pages
		connPage = new ConnectionPage();
		pricesPage = new PricesNormPage(superUsr);
		
		//set to dao the console in export page
		//Dao.SetConsole(/*exPage.getConsole()*/null);
		
		//add pages to page list
		pages.add(connPage);
		pages.add(pricesPage);
		
		
		//add pages to wizard
		for(int i = 0; i< pages.size() ; i++){
			wizpanel.add(String.valueOf(i), pages.get(i));
		}
		
		
		
		//hide next button
		buttons.getBtnNext().setVisible(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DBConfig.initDBConfig(new LogFactorySystemOut(), new IVisitFactory() {
			@Override
			public IVisit getVist() {
				// TODO Auto-generated method stub
				return new VisitEmpty();
			}
		}, this, new IElaplsedTimerFactory() {
			
			@Override
			public IElaplsedTimer getElapsedTimer() {
				// TODO Auto-generated method stub
				return new ElapsedTimer();
			}
		});
		
		//show the wizard
		showWiz();
	}
	
	//navigation button is pushed  -- handler
	public  void wizbuttonPushed(String btnName){
		
		//hadle connect
		if(btnName.equals("btnConnect")){
			btnConnectCliked();
		}
		
		//back button pushed
		if(btnName.equals("btnBack")){
			btnBackCliked();
		}
		
		
		//next button pushed
		if(btnName.equals("btnNext")){
			btnNextCliked();
		}
	}
	
	
	//handle btn connect
	private void btnConnectCliked(){
		System.out.println("btnConnect clicked... ");
		ConnectionProperties prop =  connPage.getConnectionProperties();
		
		//init DAOS
		dao = new PricesDao(this);
		
		//check if connection is postgre or oracle
		if(prop == null || prop.getUrl() == null){
			//datObjInterface = null;
			return;
		}
		
		if(prop.getUrl().contains("@")){
			//oracle connection
			//dbType = DBTYPE.ORCL;
			//datObjInterface = dbObjectsOrcl;			
		}
		else
		if(prop.getUrl().contains("//")){
			//postgre connection
			//dbType = DBTYPE.POSTGRE;
			//datObjInterface = dbObjectsPostgre;
		}
		else{
			//datObjInterface = null;
			return;
		}
		
		
		
		//start load table  TASK
		GuiWorker wk = new GuiWorker(this, TASKS.LOAD_DATA_TABLES);
		wk.execute();
		
	}
	

	//handle btn back
	private void btnBackCliked(){
		System.out.println("btn Back clicked... ");
		
		//we are on tabs
		if(Page.getCurrenPage() == 1){
			setSize(dLittle); //set small size
		}
		
		//goto previous page
		card.previous(wizpanel);
		
		//set state to previous page
		getCallBack().toPrevious();
	}
	
	//handle btn next
	private void btnNextCliked(){
		System.out.println("btn Next clicked... ");
		
		//we reached last page
		if(Page.getCurrenPage() == pages.size() - 1){
			System.out.println("Last Page... ");
			
			//DO THE EXPORT HERE
			//start export TASK
			//GuiWorker wk = new GuiWorker(this, TASKS.EXPORT);
			//wk.execute();
		}
		
		//we are on tabs page
		if(Page.getCurrenPage()  == 1){
			//start get user Objects TASK
			//GuiWorker wk = new GuiWorker(this, TASKS.GET_USEROBJECTS);
			//wk.execute();
		}
		
		
}
	
	//now invoke in the thread routine
	private void goToNextPage(){
			//check for error first
			//if(isErr())  return;
	
			//goto next  page
			card.next(wizpanel);
			
			//set state to next page
			getCallBack().toNext();
	}

	
	//getters & setters
	public ActionListenHandler getWizListener() {		
		return wizListener;
	}


	public ConnectionPage getConnPage() {
		return connPage;
	}



	
	//pages call back implementation  class
	class PageCallBackHandler implements PageCallBack{
		
		//remove all buttons from panel
		private  void removeAllButtons(){
			buttons.getBtnConnect().setVisible(false);
			buttons.getBtnBack().setVisible(false);
			buttons.getBtnNext().setVisible(false);
		}
		
		//we go to first page
		private void setStateFirstPage(){
			removeAllButtons();
			
			//add only  connect button
			buttons.getBtnConnect().setVisible(true);
		}
		
		//we go to some page between first and last page
		private void setStateMiddlePage(){
			//remove connect  button
			removeAllButtons();
			buttons.getBtnBack().setVisible(true);
			//buttons.getBtnNext().setVisible(true);
			//buttons.getBtnNext().setText("Next>>");
		}
		
		//we go to last page
		private void setStateLastPage(){
			setStateMiddlePage();
		}
		

		//go to next page
		@Override
		public void toNext() {
			// TODO Auto-generated method stub
			Page.nextPage();   //increase page counter
			if(Page.getCurrenPage() > 0 && Page.getCurrenPage() <  pages.size() - 1){
				setStateMiddlePage();
			}else{
				setStateLastPage();
			}
		}

		
		//go to previous page
		@Override
		public void toPrevious() {
			// TODO Auto-generated method stub
			Page.previousPage();   //decrease page counter
			if(Page.getCurrenPage() == 0){
				setStateFirstPage();
			}else{
				setStateMiddlePage();
			}
		}

	
		
	}
	

	//implementation of pages call back interface
	public  PageCallBackHandler getCallBack (){
		if(pageCallBack == null)  return new PageCallBackHandler();
		return pageCallBack;
	}


	//implementation of connection factory getConnection
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return new DataSourceConnectionFactoryDrManager(connPage.getConnectionProperties()).getConnection();
	}

	@Override
	public void LoadTables() {
		// TODO Auto-generated method stub
		 
		 //load legalnorm
		 pricesPage.getLeagalNorm().setTableDataFromObjecs(dao.LoadLegalNorm());
		 
		 //load cartaxprice
		 pricesPage.getCar().setTableDataFromObjecs(dao.LoadCarTaxPrice());
		 
		 //load truck taxprice
		 pricesPage.getTruck().setTableDataFromObjecs(dao.LoadTruckTaxPrice());
		 
		 //load config
		 pricesPage.getConfig().setTableDataFromObjecs(dao.LoadConfig());
		
		 //check error
		 //if(isErr("Connection to DB not established..."))  return;
		 
		//resize to big
		 setSize(dBtabs);
		 
		 //next page
		 goToNextPage();
	}

	@Override
	public void UpdateTables() {
		// TODO Auto-generated method stub
		System.out.println("Entered in Update tables...");
	}

	@Override
	public void enableButtons(boolean b) {
		// TODO Auto-generated method stub
		buttons.Enable(b);
		pricesPage.getLegalupdateButton().setEnabled(b);
		pricesPage.getConfigupdateButton().setEnabled(b);
		pricesPage.getTruxckupdateButton().setEnabled(b);
		pricesPage.getCarupdateButton().setEnabled(b);
	}

	@Override
	public void UpdateLegalNorm() {
		// TODO Auto-generated method stub
		System.out.println("Entered in Update Legalnorm...");
		
		//get the data each row is Legalnorm Object
		Object [][] data = pricesPage.getLeagalNorm().getTableModel().getData();
		
		if(data == null) return;
		List<DBStatement> l = new ArrayList<DBStatement>();
		
		//get update statements
		for(int i =0; i < data.length; i++){
			LegalNorm obj = (LegalNorm)data[i][0];
			if(obj.isEdited())  l.add(new wizard.statements.LegalNormUpdate(obj));
		}
		
		//update table
		dao.UpdateTable(l);
		
		//isErr("Error occurred in Updating Legalnorm!");
	}



	/*//check for error
	private boolean isErr(String msgToShow){
		//get Error - print to console  or show msg
		if(Dao.getErrCodeMsg().getErr() != ERRCODE.OK){
			
			String msg;  // msgToShow;
			if(msgToShow != null) msg = msgToShow;
			else msg = Dao.getErrCodeMsg().getErrMsg();
				Utils.showErrMsg(null, msg);
					return true;
		}		
		return false;
	}*/

	@Override
	public void UpdateConfig() {
		// TODO Auto-generated method stub
		System.out.println("Entered in Update Config...");
		
		//get the data each row is Config Object
		Object [][] data = pricesPage.getConfig().getTableModel().getData();
		
		if(data == null) return;
		List<DBStatement> l = new ArrayList<DBStatement>();
		
		//get update statements
		for(int i =0; i < data.length; i++){
			Config obj = (Config)data[i][0];
			if(obj.isEdited())  l.add(new ConfigUpdate(obj));
		}
		
		//update table
		dao.UpdateTable(l);
		
		//isErr("Error occurred in Updating Config!");
	}

	@Override
	public void UpdateCar() {
		// TODO Auto-generated method stub
		System.out.println("Entered in Update Config...");
		
		//get the data each row is Car Object
		Object [][] data = pricesPage.getCar().getTableModel().getData();
		
		if(data == null) return;
		List<DBStatement> l = new ArrayList<DBStatement>();
		
		//get update statements
		for(int i =0; i < data.length; i++){
			Car obj = (Car)data[i][0];
			if(obj.isEdited())  l.add(new CarUpdate(obj));
		}
		
		//update table
		dao.UpdateTable(l);
		
		//isErr("Error occurred in Updating CarPrices!");
	}

	@Override
	public void UpdateTrucks() {
		// TODO Auto-generated method stub
		System.out.println("Entered in Update Config...");
		
		//get the data each row is TruckTaxPrice Object
		Object [][] data = pricesPage.getTruck().getTableModel().getData();
		
		if(data == null) return;
		List<DBStatement> l = new ArrayList<DBStatement>();
		
		//get update statements
		for(int i =0; i < data.length; i++){
			TruckTaxPrice obj = (TruckTaxPrice)data[i][0];
			if(obj.isEdited())  l.add(new TruckUpdate(obj));
		}
		
		//update table
		dao.UpdateTable(l);
		
		//isErr("Error occurred in Updating TruckPrices!");
	}
	

}



