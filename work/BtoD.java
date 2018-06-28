package work;

public class BtoD {
	
	//0, 2, 8, 16, 32, 64, 128
	int binary[] = {128, 64, 32, 16, 8, 4, 2, 1};
	int placeBorrowed[] = {0, 0, 0, 0, 0, 0, 0, 0};
	int placeBorrowedTwo[] = {0, 0, 0, 0, 0, 0, 0, 0};
	int placeBorrowedThree[] = {0, 0, 0, 0, 0, 0, 0, 0};
	int sum[] = new int[3];
	
	public BtoD(int bb) {
		if(bb < 8) {
			for(int i = 0; i < bb; i++) {
				placeBorrowed[i] = 1;
				sum[0] += binary[i];
			}
		}
		
		else if(bb >= 8 && bb < 16) {
			for(int i = 0; i < 8; i++) {
				placeBorrowed[i] = 1;
				sum[0] += binary[i];
			}
			for(int i = 0; i < bb-8; i++) {
				placeBorrowedTwo[i] = 1;
				sum[1] += binary[i];
			}
		}
		
		else if(bb >= 16) {
			for(int i = 0; i < 8; i++) {
				placeBorrowed[i] = 1;
				sum[0] += binary[i];
			}
			for(int i = 0; i < 8; i++) {
				placeBorrowedTwo[i] = 1;
				sum[1] = binary[i];
			}
			for(int i = 0; i < bb-16; i++) {
				placeBorrowedTwo[i] = 1;
				sum[2] += binary[i];
			}
		}
			
	}
	
	public int[] getDecimal() {
		return sum;
	}
	
}
