package wizard.pages;

public interface IGuiWorker {

	public enum TASKS{
		LOAD_DATA_TABLES,
		UPDATE_TABLES,
		UPDATE_LEGALNORM,
		UPDATE_CONFIG,
		UPDATE_CARS,
		UPDATE_TRUCK
	};
	
	public void LoadTables();
	public void UpdateTables();
	public void UpdateLegalNorm();
	public void UpdateConfig();
	public void UpdateCar();
	public void UpdateTrucks();
	public void enableButtons(boolean b);
}
