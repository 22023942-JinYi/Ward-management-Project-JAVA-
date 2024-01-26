/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Low Jin Yi
 * Student ID: {22023942}
 * Class: {C208-2B-E65L-A}
 * Date/Time created: Sunday 04-12-2022 18:00
 */

/**
 * @author 22023942
 *
 */
public class Patient {
	private String nric4;
	private String name;
	private String ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged;
	private int visitorCount;
	private String emergencyno;
	
	public Patient(String nric4, String name, String ward, int bed,String dateWarded, String dateDischarged, int visitorCount) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = dateDischarged;
		this.visitorCount = visitorCount;
		emergencyno = "";
	}
	public Patient(String nric4, String name, String ward, int bed,String dateWarded) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		dateDischarged = "";
		visitorCount = 0;
		emergencyno = "";
	}
	public Patient(String nric4, String name, String ward, int bed,String dateWarded, String emergencyno) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		dateDischarged = "";
		visitorCount = 0;
		this.emergencyno = emergencyno;
	}
	
	public String getNric4() {
		return nric4;
	}
	public String getName() {
		return name;
	}
	public String getWard() {
		return ward;
	}
	public int getBed() {
		return bed;
	}
	public String getDateWarded() {
		return dateWarded;
	}
	public String getDateDischarged() {
		return dateDischarged;
	}
	public void setDateDischarged(String discharge) {
		dateDischarged = discharge;
	}
	public int getVisitorCount() {
		return visitorCount;
	}
	public void setVisitorCount(int visit) {
		visitorCount = visit;
	}
	public String getEmergencyno() {
		return emergencyno;
	}
	public void setEmergencyno(String number) {
		emergencyno = number;
	}
	public void display() {
		System.out.println(String.format("%-20s%s %s", "Patient Name",":",name));
		System.out.println(String.format("%-20s%s %s", "Ward",":",ward));
		System.out.println(String.format("%-20s%s %d", "Bed",":",bed));
		System.out.println(String.format("%-20s%s %s", "Date warded",":",dateWarded));
		System.out.println(String.format("%-20s%s %s", "Date discharged",":",dateDischarged));
		System.out.println(String.format("%-20s%s %s", "No of visitor(s)",":",visitorCount));
		System.out.println(String.format("%-20s%s %s", "Emergency number",":",emergencyno));
	}
}
