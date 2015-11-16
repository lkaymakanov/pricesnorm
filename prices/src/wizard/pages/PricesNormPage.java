package wizard.pages;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import wizard.legalnorm.JLegalNormTable;
import wizard.models.cars.JCarTable;
import wizard.models.config.JConfigTable;
import wizard.models.trucks.JTruckTable;
import wizard.pages.IGuiWorker.TASKS;



public class PricesNormPage extends Page {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5386176858014746524L;
	private boolean superUsr = false;
	
	//the object tabs for procedures, function, packages, schemas
	JTabbedPane tabs = new JTabbedPane();
	JButton legalupdateButton;
	JButton configupdateButton;
	JButton truxckupdateButton;
	JButton carupdateButton;
	
	
	//panels for each tab
	//legalnorm
	JPanel legalnormPanel = new JPanel();
	JPanel configPanel = new JPanel();
	JPanel truckPanel = new JPanel();
	JPanel carPanel = new JPanel();
	
	IGuiWorker workerint;
	
	
	//the tables in each panel
	JLegalNormTable leagalNorm;
	JConfigTable config;
	JCarTable car;
	JTruckTable truck;
	
	
	public PricesNormPage(){
		this(false);
	}
	
	
	public PricesNormPage(boolean superUsr){
		this.superUsr = superUsr;
		initPage();
	}
	

	@Override
	protected void initPage() {
		// TODO Auto-generated method stub
		//lay outs
		
		
		JPanel paneLabel = new JPanel();
		//JPanel panelTabs = new JPanel();
		
		
		//pack.setVisible(false);

		//setlay out
		//panelTabs.setLayout(new GridLayout(1, 1));
		
		//add label to label panel
		paneLabel.add(new JLabel("Please select Objects To export"));
		//tabs.setLayout(new GridLayout(1, 1));
		
		//add tabs
		tabs.addTab("Legalnorm", null, legalnormPanel, "Legalnorm");
		tabs.addTab("Config", null, configPanel, "Config");
		tabs.addTab("CarsPrices", null, carPanel, "CarsPrices");
		tabs.addTab("TruckPrices", null, truckPanel, "TruckPrices");
		
		tabs.setTabPlacement(JTabbedPane.TOP);
		
		//add tabs to tabpanel panel
		//panelTabs.add(tabs);
		
		//add data tables to panels
		leagalNorm = new JLegalNormTable(legalnormPanel, superUsr);
		config = new JConfigTable(configPanel,superUsr);
		car = new JCarTable(carPanel,superUsr);
		truck = new JTruckTable(truckPanel,superUsr);
		
		
		//init update buttons
		legalupdateButton  = new JButton("Update");
		configupdateButton  = new JButton("Update");
		truxckupdateButton  = new JButton("Update");
		carupdateButton  = new JButton("Update");
		
		
		
		//register listener to legalnorm update button
		legalupdateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiWorker wk = new GuiWorker(workerint, TASKS.UPDATE_LEGALNORM);
				wk.execute();
			}
		});
		
		//register listener to config update button
		configupdateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiWorker wk = new GuiWorker(workerint, TASKS.UPDATE_CONFIG);
				wk.execute();
			}
		});
		
		
		//register listener to truck update button
		truxckupdateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiWorker wk = new GuiWorker(workerint, TASKS.UPDATE_TRUCK);
				wk.execute();
			}
		});
				
		
		//register listener to cars update button
		carupdateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiWorker wk = new GuiWorker(workerint, TASKS.UPDATE_CARS);
				wk.execute();
			}
		});
		
		
		
		
		//add button to panel
		legalnormPanel.add(legalupdateButton);
		configPanel.add(configupdateButton);
		truckPanel.add(truxckupdateButton);
		carPanel.add(carupdateButton);
		
		//set layout
		setLayout(new GridLayout(1,1));
		
		//add label & tabs to page panel
		//add(paneLabel, BorderLayout.NORTH);
		//add(panelTabs,BorderLayout.CENTER);
		add(tabs);
	}


	public JTabbedPane getTabs() {
		return tabs;
	}

	public JLegalNormTable getLeagalNorm() {
		return leagalNorm;
	}

	public JButton getLegalupdateButton() {
		return legalupdateButton;
	}

	public JButton getConfigupdateButton() {
		return configupdateButton;
	}

	public JButton getTruxckupdateButton() {
		return truxckupdateButton;
	}

	public JButton getCarupdateButton() {
		return carupdateButton;
	}

	public JConfigTable getConfig() {
		return config;
	}

	public JCarTable getCar() {
		return car;
	}

	public JTruckTable getTruck() {
		return truck;
	}
	

	
}
