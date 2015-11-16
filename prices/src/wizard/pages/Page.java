package wizard.pages;

import javax.swing.JPanel;

public abstract class Page extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7316981366612917681L;
	private static int currentPage = 0;
	

	public Page() {
		// TODO Auto-generated constructor stub
		
	}
	
	protected abstract void initPage();
	
	
	//go to the next page
	public static void nextPage(){
		currentPage++;
	}
	
	//go to previous page
	public static void previousPage(){
		currentPage--;
	}

	
	public static int getCurrenPage(){
		return currentPage;
	}

}
