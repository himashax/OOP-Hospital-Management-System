package Services;

import java.util.ArrayList;


import Model.Nurse;

public interface INurseService {

	public void addNurse(Nurse nurse);
	
	public Nurse getNurse(String nurseID);
	
	public Nurse updateNurse(String nurseID, Nurse nurse);
	
	public void deleteNurse(String nurseID);

	ArrayList<Nurse> listNurses();
	
}
