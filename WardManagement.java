import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Low Jin Yi
 * Student ID: 22023942
 * Class:C208-2B-E65L-A
 * Date/Time Last modified:2/2/2023 9:16pm
 */


public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		wardArr[0] = new Ward("A","1 Bed, attached bath/toilet",10,535.00);
		wardArr[1] = new Ward("B1","4 Bed, attached bath/toilet",20,266.43);
		wardArr[2] = new Ward("B2","6 Bed, common bath/toilet",20,83.00);
		wardArr[3] = new Ward("C","8 Bed, common bath/toilet",50,37.00);
		
		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.add(new Patient("111A","John Lee","A",2,"01/12/2022"));
		patientList.add(new Patient("222B","Mary Jane","B1",11,"02/12/2022"));
		patientList.add(new Patient("333C","Abdul Musri","B1",12,"03/12/2022"));
		patientList.add(new Patient("444D","Jane Tan","B2",2,"12/12/2022","",3));
		patientList.add(new Patient("555E","Paul Tan","C",2,"02/11/2022","",4));
		patientList.add(new Patient("666F","Paul Ng","C",3,"03/11/2022","09/11/2022",0));
		patientList.add(new Patient("777G","Wong Kuan","C",4,"02/12/2022"));

		//display standard menu and ask for option
		int option = -99;
		publicMenu();

		
		//indefinite while loop
		while(option != 10) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
			} else if (option == 9) {
				//add emergency number
				addEmergencyno(patientList);
			} else if (option == 10) {
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}

	} // end of main



	

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");
		System.out.println("1. View all Ward Info");
		System.out.println("2. Display Patient List");
		System.out.println("3. Admit Patient");
		System.out.println("4. Discharge Patient");
		System.out.println("5. Remove Patient");
		System.out.println("6. Register Visit");
		System.out.println("7. End Visit");
		System.out.println("8. Display Ward Overview");
		System.out.println("9. Add patient emergency number");
		System.out.println("10. Logout");

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {
		Helper.line(40, "*");
		System.out.println("WARD INFO");
		Helper.line(40, "*");
		System.out.println(String.format("%-10s%-30s%-13s%-5s", "WARD","DESCRIPTION","BED COUNT","BED CHARGE"));
		for (int i = 0;i < wardArr.length;i++) {
			System.out.println(String.format("%-10s%-30s%-13d%-5.2f",wardArr[i].getWard(),wardArr[i].getDescription(),wardArr[i].getBedCount(),wardArr[i].getBedCharge()));
		}

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {
		Helper.line(40, "*");
		System.out.println("PATIENT LIST");
		Helper.line(40, "*");
		System.out.println(String.format("%-10s%-20s%-10s%-10s%-18s%-20s%-20s%s","NRIC4","NAME","WARD","BED",
				"DATE WARDED","DATE DISCHARGED","VISITOR COUNT","EMERGENCY NUMBER"));
		for (int i = 0;i < patientList.size();i++) {
			System.out.println(String.format("%-10s%-20s%-10s%-10d%-18s%-20s%-20d%s", patientList.get(i).getNric4(), patientList.get(i).getName(), 
					patientList.get(i).getWard(), patientList.get(i).getBed(), patientList.get(i).getDateWarded(), 
					patientList.get(i).getDateDischarged(), patientList.get(i).getVisitorCount(), patientList.get(i).getEmergencyno()));
		}
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {
		Helper.line(40, "*");
		System.out.println("ADMIT PATIENT");
		Helper.line(40, "*");
		boolean length = false;
		String newnric = Helper.readString("Enter patient 4 digit NRIC > ");
		String newname = Helper.readString("Enter patient name > ");
		String newward = Helper.readString("Enter ward > ");
		int newbed = Helper.readInt("Enter bed > ");
		String newdateward = Helper.readString("Enter date warded > ");
		String numberyes = Helper.readString("Emergency number (Y/N) > ");
		while(length != true) {
			if(numberyes.equalsIgnoreCase("y")){
				String number = Helper.readString("Enter emergency number > ");
				if(number.length() == 8) {
					patientList.add(new Patient(newnric,newname,newward,newbed,newdateward,number));
					patientList.get(patientList.size()-1).display();
					System.out.println("\n*** Patient has been added ***\n");
					length = true;
				}
				if(length == false) {
					System.out.println("The length of the phone number is incorrect");
				}
			}
			else {
				patientList.add(new Patient(newnric,newname,newward,newbed,newdateward));
				patientList.get(patientList.size()-1).display();
				System.out.println("\n*** Patient has been added ***\n");
				length = true;
			}
		}
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------

	public static boolean dischargePatient(ArrayList<Patient> patientList) {
		Helper.line(40, "*");
		System.out.println("DISCHARGE PATIENT");
		Helper.line(40, "*");
		boolean patientfound = false;
		String searchname = Helper.readString("Enter patient name > ");
		for (int i = 0;i < patientList.size();i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(searchname)) {
				if (patientList.get(i).getDateDischarged().isEmpty()) {
					patientList.get(i).display();
					String discharge = Helper.readString("Enter date discharged > ");
					patientList.get(i).setDateDischarged(discharge);
					patientList.get(i).setVisitorCount(0);
					System.out.println("\n*** Patient is discharged ***\n");
					patientfound = true;
				}
				else {
					System.out.println("\n*** Patient has already been discharged ***\n");
					patientfound = true;
				}
			}
		}
		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {
		Helper.line(40, "*");
		System.out.println("REMOVE PATIENT");
		Helper.line(40, "*");
		boolean patientfound = false;
		String removename = Helper.readString("Enter patient name > ");
		for(int i = 0;i < patientList.size();i++) {
			if (patientList.get(i).getName().equalsIgnoreCase(removename)) {
				patientList.get(i).display();
				patientfound = true;
				char confirm = Helper.readChar("Confirm deletion (y/n) > ");
				if (confirm == 'y') {
					patientList.remove(i);
					System.out.println("\n*** Patient has been deleted ***\n");
				}
			}
		}

		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {
		Helper.line(40, "*");
		System.out.println("REGISTER VISIT");
		Helper.line(40, "*");
		boolean patientfound = false;
		boolean morevisit = true;
		
			String registername = Helper.readString("Enter patient name > ");
			for(int i = 0;i < patientList.size();i++) {
			if (patientList.get(i).getName().equalsIgnoreCase(registername)&& patientList.get(i).getDateDischarged().isEmpty()) {
				patientList.get(i).display();
				patientfound = true;
				if (patientList.get(i).getVisitorCount() != 4) {
					int visitorallowed = 4 - patientList.get(i).getVisitorCount();
					System.out.println("\n*** Only "+ visitorallowed + " visitor(s) allowed ***\n");
					int newvisitor = Helper.readInt("Enter number of new visitors > ");
					while (morevisit != false) {
						if(newvisitor <= visitorallowed) {
							patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount() + newvisitor);
							System.out.println("\n*** Please proceed to ward***\n");
							morevisit = false;
						}
						else {
							System.out.println("\n*** Visitors exceeded ***\n");
							newvisitor = Helper.readInt("Enter number of new visitors > ");
						}
					}
				}
				else {
					System.out.println("\n*** No additonal visitor allowed ***\n");
				}
			}
			else if (patientList.get(i).getName().equalsIgnoreCase(registername)&& patientList.get(i).getDateDischarged()!= ""){
				patientList.get(i).display();
				patientfound = true;
				System.out.println("\n*** Patient has been discharged ***\n");
			}
		}	
		return patientfound;
	}
		

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//---------------------------------------- ---------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {
		Helper.line(40, "*");
		System.out.println("END VISIT");
		Helper.line(40, "*");
		boolean patientfound = false;
		String endname = Helper.readString("Enter patient name > ");
		for(int i = 0;i < patientList.size();i++) {
			if (patientList.get(i).getName().equalsIgnoreCase(endname)&& patientList.get(i).getDateDischarged().isEmpty()) {
				patientList.get(i).display();
				patientfound = true;
				if (patientList.get(i).getVisitorCount() != 0) {
					int visitleave = Helper.readInt("Enter number of visitor(s) leaving > ");
					if (visitleave <= patientList.get(i).getVisitorCount()) {
						patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount()- visitleave);
						System.out.println("\n*** No of visitor(s) still at ward : " + patientList.get(i).getVisitorCount()+ " ***\n");
					}
					else {
						System.out.println("\n*** Visitor(s) leaving is more than visited ***\n");
					}
				}
				else {
					System.out.println("\n*** There are no visitors ***\n");
				}
			}
			else if(patientList.get(i).getName().equalsIgnoreCase(endname)&& patientList.get(i).getDateDischarged() != "") {
				patientfound = true;
				patientList.get(i).display();
				System.out.println("\n*** Patient has been discharged ***\n");
			}
		}
		return patientfound;
	}

	
	
	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] wardArr) {
		Helper.line(40, "*");
		System.out.println("WARD OVERVIEW");
		Helper.line(40, "*");
		int totalbed = 0;
		int totalpatient = 0;
		int totalvisit = 0;
		System.out.println(String.format("%-10s%-30s%-35s%-35s%s","WARD","DESCRIPTION","TOTAL BED COUNT FOR EACH WARD","TOTAL PATIENTS FOR EACH WARD","TOTAL VISITORS FOR EACH WARD"));
		for(int i = 0; i < wardArr.length; i++) {
			int eachtotalpatient = 0;
			int eachtotalvisitor = 0;
			for(int x = 0; x < patientList.size(); x++) {
				if (wardArr[i].getWard().equalsIgnoreCase(patientList.get(x).getWard())&&patientList.get(x).getDateDischarged()=="") {
					eachtotalpatient ++;
					eachtotalvisitor += patientList.get(x).getVisitorCount();
				}
			}
			System.out.println(String.format("%-10s%-30s%-35d%-35d%d",wardArr[i].getWard(),wardArr[i].getDescription(),wardArr[i].getBedCount(),eachtotalpatient,eachtotalvisitor));
			totalpatient += eachtotalpatient;
			totalvisit += eachtotalvisitor;
			totalbed += wardArr[i].getBedCount();
		}
		System.out.println(String.format("%-40s%-35s%-35s%s","","TOTAL BED COUNT","TOTAL PATIENTS","TOTAL VISITORS"));
		System.out.println(String.format("%-40s%-35d%-35d%d","",totalbed, totalpatient,totalvisit));
	}
	//-------------------------------------------------------------------------------------------------------------
	//static method that keys in the emergency number for the patients
	//-------------------------------------------------------------------------------------------------------------
	public static boolean addEmergencyno(ArrayList<Patient> patientList) {
		Helper.line(40, "*");
		System.out.println("ADD EMERGENCY NUMBER FOR PATIENT");
		Helper.line(40, "*");
		String newnric = Helper.readString("Enter Patient's Nric > ");
		boolean length = false;
		boolean patientfound = false;
		while(length != true) {
			for(int i = 0; i < patientList.size(); i++) {
				if(patientList.get(i).getNric4().equalsIgnoreCase(newnric)) {
					String number = Helper.readString("Enter Patient's emergency number > ");
					patientfound = true;
					if(number.length() == 8) {
						patientList.get(i).setEmergencyno(number);
						length = true;
						System.out.println("Emergency number added");
					}
				}
			}
			if(length == false) {
				System.out.println("The length of the phone number is incorrect");
			}
		}
		return patientfound;
	}
}

