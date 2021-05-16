package Services;

import java.util.ArrayList;

import Model.OutPatient;

public interface IOutPatientService {

	//implemented by IT19128696 Mandakini G.H.
	public ArrayList<String> getOutPatientID();
	
	public void AddOutPatient(OutPatient out_Patient);
	
	public OutPatient getOutPatientByID(String outPatientID);
	
	
	
	//implemented by IT19127088 Senarathna A.M.M.D.N
	public OutPatient UpdateOutPatient(String outPatientID, OutPatient out_Patient);
	
	public ArrayList<OutPatient> listOutPatients(); 
	
	public void deleteOutPatient(String outPatientID);

}
