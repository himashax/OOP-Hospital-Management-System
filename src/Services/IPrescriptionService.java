package Services;

//IT19128696 Mandakini G.H

import java.util.ArrayList;


import Model.Prescription;

public interface IPrescriptionService {

	public ArrayList<String> getPrescriptionID();
	
	public void AddPrescription(Prescription prescription);
	
	public Prescription getPrescription(String patient_id);
	
	public Prescription UpdatePrescription(String presID,Prescription prescription);

	public ArrayList<Prescription> listPrescriptions(String patient_id);
}
