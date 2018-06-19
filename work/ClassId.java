package work;

public class ClassId {
	
	public static char addC = 'x';
	
	//Constructor // giving birth to ClassId
	public ClassId(int oct) {
		if(oct > 0 && oct <= 127) {
			addC = 'A';
		}
		else if(oct >= 128 && oct <= 191) {
	         addC = 'B';
	      }
		else if(oct >= 192 && oct <= 223) {
	         addC = 'C';
	      }
	}
	
	//Accessor
	public char getClassId() {
		return addC;
	}
	
}