package Services;

import java.util.ArrayList;


import Model.Receptionist;

public interface IReceptionistService {

	public void addReceptionist(Receptionist receptionist);
	
	public Receptionist updateReceptionist(String recepID, Receptionist receptionist);

	public Receptionist getReceptionist(String recepID);
	
	public void deleteReceptionist(String recepID);

	ArrayList<Receptionist> listReceptionists();

}
