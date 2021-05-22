package Services;

import java.util.ArrayList;

import Model.OutPatient;

public interface IOutPatientService {

	//implemented by
	public ArrayList<String> getOutPatientID();
	
	public void AddOutPatient(OutPatient out_Patient);
	
	public OutPatient getOutPatientByID(String outPatientID);
	
	
	
	//implemented by 
	public OutPatient UpdateOutPatient(String outPatientID, OutPatient out_Patient);
	
	public ArrayList<OutPatient> listOutPatients(); 
	
	public void deleteOutPatient(String outPatientID);

}
