/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Low Jin Yi
 * Student ID: {22023942}
 * Class: {C208-2B-E65L-A}
 * Date/Time created: Sunday 04-12-2022 17:31
 */

/**
 * @author 22023942
 *
 */
public class Ward {
	private String ward;
	private String description;
	private int bedCount;
	private double bedCharge;
	
	public Ward(String ward, String description, int bedCount, double bedCharge) {
		this.ward = ward;
		this.description = description;
		this.bedCount = bedCount;
		this.bedCharge = bedCharge;
	}
	public String getWard() {
		return ward;
	}
	public String getDescription() {
		return description;
	}
	public int getBedCount() {
		return bedCount;
	}
	public double getBedCharge() {
		return bedCharge;
	}
}
