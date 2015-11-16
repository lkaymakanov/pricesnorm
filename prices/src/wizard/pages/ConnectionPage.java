package wizard.pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.is_bg.ltf.db.common.ConnectionProperties;
import swing.utils.XMLReader;
import wizard.JComboConnection;
import wizard.Wizard;
import file.utils.UseFileDialog;

public class ConnectionPage extends Page {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2198613412978251416L;
	
	
	public enum CONTYPE{XMLFILE, SPECIFIC};
	public enum DBTYPE{ORCL, POSTGRE};
	
	//drivers 
	public final static String ORCL_DRIVER = "oracle.jdbc.OracleDriver";
	public final static String PGR_DRIVER  = "org.postgresql.Driver";
	
	//url prefixes
	private final static String URL_PGR_DRIVER_PREFIX = "jdbc:postgresql://";
	private final static String URL_ORCL_DRIVER_PREFIX = "jdbc:oracle:thin:@";
	
	ButtonGroup connRadioGrp = new ButtonGroup();
	ButtonGroup dbRadioGrp = new ButtonGroup();
	
	//oracle or postgre connections radios
	JRadioButton orclRadio = new JRadioButton("ORCL");
	JRadioButton pgrRadio = new JRadioButton("POSTGRE");
	
	//file connections or specified by user
	JRadioButton fileconRadio = new JRadioButton("File Connections");
	JRadioButton specificRadio = new JRadioButton("Specify Connection");
	JButton btnOpenFile = new JButton("...");
	
	
	JComboConnection    connectionsCombo = new JComboConnection();
	UseFileDialog  fdialog ;

	DBTYPE dbType = DBTYPE.ORCL;          //oracle default
	CONTYPE conType = CONTYPE.SPECIFIC;   //specific conn default
	
	//specific con fields
	JTextField ip = new JTextField(10);
	JTextField sid = new JTextField(10);
	JTextField port = new JTextField(10);
	JTextField user = new JTextField(10);
	JTextField pass = new JTextField(10);
	Wizard w;
	
	String dbName = "";
	
	public ConnectionPage() {
		// TODO Auto-generated constructor stub
		this.w = Wizard.getWizard();
		initPage();
	}

	
	

	@Override
	protected void initPage() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		
		//init file dlg
		fdialog = new UseFileDialog();
		
		setLayout(layout);
		
		orclRadio.setName("rOrcl");
		pgrRadio.setName("rPgr");
		
		dbRadioGrp.add(orclRadio);
		dbRadioGrp.add(pgrRadio);
		
		//radio buttons
		fileconRadio.setName("rFile");
		specificRadio.setName("rSpec");
		connectionsCombo.setName("cFile");
		
		//connections.initCombo(readConnections());
		// TODO Auto-generated method stub
		btnOpenFile.setName("openfdlg");
		
		//add listener to ctrls
		fileconRadio.addActionListener(w.getWizListener());
		specificRadio.addActionListener(w.getWizListener());
		//connections.addActionListener(w.getWizListener());
		orclRadio.addActionListener(w.getWizListener());
		pgrRadio.addActionListener(w.getWizListener());
		btnOpenFile.addActionListener(w.getWizListener());
		
		//default is file config & orcl
		fileconRadio.setSelected(true);
		orclRadio.setSelected(true);
		specificRadio.setSelected(true);
		
		//gruop radio buttons
		connRadioGrp.add(fileconRadio);
		connRadioGrp.add(specificRadio);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.CENTER;
		add(orclRadio, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.CENTER;
		add(pgrRadio, gc);
		
		
		//add radio buttons
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.CENTER;
		//add(fileconRadio, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.CENTER;
		//add(specificRadio, gc);
		
		
		//add file connections combo
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.CENTER;
		//add(connectionsCombo, gc);
		//add(btnOpenFile);
		
		//new panel  for specific connection
		//add specific conn panel
		gc.gridx = 1;
		gc.gridy = 2;
		add(initSpecificConPanel(), gc);
		
	}
	

	
	
	//the specific connection panel
	private JPanel initSpecificConPanel(){
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints pgc = new GridBagConstraints();
		
		//create labels
		JLabel ipl = new JLabel("IP");
		JLabel sidl = new JLabel("SID");
		JLabel portl = new JLabel("Port");
		JLabel userl = new JLabel("User");
		JLabel passl = new JLabel("Pass");
		
		
		
		
		//add labels
		pgc.gridx = 0;
		pgc.gridy = 0;
		pgc.anchor = GridBagConstraints.WEST;
 		p.add(ipl, pgc);
 		
 		pgc.gridx = 0;
		pgc.gridy = 1;
		pgc.anchor = GridBagConstraints.WEST;
 		p.add(sidl, pgc);
 		
 		pgc.gridx = 0;
		pgc.gridy = 2;
		pgc.anchor = GridBagConstraints.WEST;
		p.add(portl, pgc);
		
		pgc.gridx = 0;
		pgc.gridy = 3;
		pgc.anchor = GridBagConstraints.WEST;
		p.add(userl, pgc);
		
		pgc.gridx = 0;
		pgc.gridy = 4;
		pgc.anchor = GridBagConstraints.WEST;
		p.add(passl, pgc);
		
		//add input fields
		pgc.gridx = 1;
		pgc.gridy = 0;
		p.add(ip, pgc);
		
		pgc.gridx = 1;
		pgc.gridy = 1;
		pgc.anchor = GridBagConstraints.WEST;
 		p.add(sid, pgc);
		
		pgc.gridx = 1;
		pgc.gridy = 2;
		p.add(port, pgc);
		
		pgc.gridx = 1;
		pgc.gridy = 3;
		p.add(user, pgc);
		
		pgc.gridx = 1;
		pgc.gridy = 4;
		p.add(pass, pgc);

		
		//init port value = 1521 default
		port.setText("1521");
		
		//enable spec connections
		enableConn(true);
		return p;
	}
	
	
	private void enableCombo(boolean b){
		connectionsCombo.setEnabled(b);
	}
	
	private void enableConn(boolean b){
		ip.setEnabled(b);
		pass.setEnabled(b);
		user.setEnabled(b);
		port.setEnabled(b);
		sid.setEnabled(b);
	}
	
	public  void radioFile(){
		enableCombo(true);
		enableConn(false);
		conType = CONTYPE.XMLFILE;
	}
	
	
    public  void radioSpec(){
    	enableCombo(false);
		enableConn(true);
		conType = CONTYPE.SPECIFIC;
	}
    
    public void radioPgr(){
    	port.setText("5432");
    	dbType = DBTYPE.POSTGRE;
    }
    
    public void radioOrcl(){
    	port.setText("1521");
    	dbType = DBTYPE.ORCL;
    }
    
    
    
    
    public ConnectionProperties getConnectionProperties(){
    	//file properties 
    	if(conType == CONTYPE.XMLFILE){
    		return getPropertiesFromFile();
    	}
    	//specified connection
    	if(conType == CONTYPE.SPECIFIC){
    		return getPropertiesFromSpecCon();
    	}	
    	return null;
    }
    
    
    
    
   
    
    
/*    public  Connection getConnection(Exception outErr){
    	ConnectionProperties prop = getConnectionProperties();
    	
    	setDbName(prop.getName_to_display());
    	DataSourceConnectionFactoryDrManager ds = new DataSourceConnectionFactoryDrManager(prop);
       	Connection c = ds.getConnection();
    	
       	if(outErr != null) return null;
       	
       	return c;
    }*/
    
    
    //get connection from input fields
    private ConnectionProperties getPropertiesFromSpecCon(){
    	ConnectionProperties prop = new ConnectionProperties();
    	prop = setDriverUrl(prop);
    	prop.setUser(user.getText());
    	prop.setPass(pass.getText());
    	return prop;
    }
    
    //set the driver when loading from text fields input
    private ConnectionProperties setDriverUrl(ConnectionProperties pr){
    	if(dbType == DBTYPE.ORCL){  
    		pr.setDriver(ORCL_DRIVER);
    		pr.setUrl(URL_ORCL_DRIVER_PREFIX + ip.getText() + ":" + port.getText() + ":" + sid.getText());
    	
    	}
    	if(dbType == DBTYPE.POSTGRE){
    		pr.setDriver(PGR_DRIVER);
    		pr.setUrl(URL_PGR_DRIVER_PREFIX +  ip.getText() + ":" + port.getText() + "/" + sid.getText());
    	}
    	return pr;
    }
    
  //get connection from file
    private ConnectionProperties getPropertiesFromFile(){
    	ConnectionProperties prop = new ConnectionProperties();
    	
    	if(connectionsCombo.getSelindex() != -1) return (ConnectionProperties)connectionsCombo.getSelObject(); 
    	
    	return prop;
    }
    
    //open the xml file for readin connections
    public void openFile(){
    	String filename = fdialog.loadFile(w, "Open...", ".\\", "*.xml");
    	connectionsCombo.initCombo(readConnections(filename));
    }
    
    
    
    private  List<ConnectionProperties> readConnections(String filename){
    	//open file
		XMLReader read = new XMLReader(filename);
		
		//parse it 
		read.parseContent();
		
		//get the result
		return read.getConnections();
    }




	public String getDbName() {
		return dbName;
	}




	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
    
    
    
}
