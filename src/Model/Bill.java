package Model;

public class Bill {

	@Override
	public String toString() {
		return "customer [PatienID=" + PatienID + ", BillID=" + BillID + ", Amount=" + Amount + "]";
	}

	private String PatienID;
	private String BillID;
	private int Amount;
	
	public Bill() {
	}
	
	public Bill(String patientid, String billid, int amount) {
		
		PatienID = patientid;
		BillID = billid;
		Amount = amount;
	}

	public String getPatienID() {
		return PatienID;
	}

	public String getBillID() {
		return BillID;
	}

	public int getAmount() {
		return Amount;
	}
	
}
