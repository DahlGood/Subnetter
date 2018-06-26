package work;

public class ClassId {
	
	public static String addC = "x";
	
	//Constructor // giving birth to ClassId
	public ClassId(int[] oct) {
		if(oct[0] > 0 && oct[0] <= 127) {
			addC = "A";
		}
		else if(oct[0] >= 128 && oct[0] <= 191) {
	         addC = "B";
	      }
		else if(oct[0] >= 192 && oct[0] <= 223) {
	         addC = "C";
	      }
	}
	
	//Accessor
	public String getClassId() {
		return addC;
	}
	
}