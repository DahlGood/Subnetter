package work;

public class BtoD {
	
	//0, 2, 8, 16, 32, 64, 128
	int binary[] = {128, 64, 32, 16, 8, 2, 0};
	int placeBorrowed[] = {0, 0, 0, 0, 0, 0, 0, 0};
	int placeBorrowedTwo[] = {0, 0, 0, 0, 0, 0, 0, 0};
	int placeBorrowedThree[] = {0, 0, 0, 0, 0, 0, 0, 0};
	int sum[] = new int[3];
	
	public BtoD(int x) {
		if(x < 8) {
			for(int i = 0; i < x; i++) {
				placeBorrowed[i] = 1;
				sum[0] += binary[i];
			}
		}
		
		else if(x >= 8 && x < 16) {
			for(int i = 0; i < 8; i++) {
				placeBorrowed[i] = 1;
				sum[0] += binary[i];
			}
			for(int i = 0; i < x-8; i++) {
				placeBorrowedTwo[i] = 1;
				sum[1] += binary[i];
			}
		}
		
		else if(x >= 16) {
			for(int i = 0; i < 8; i++) {
				placeBorrowed[i] = 1;
				sum[0] += binary[i];
			}
			for(int i = 0; i < 8; i++) {
				placeBorrowedTwo[i] = 1;
				sum[1] = binary[i];
			}
			for(int i = 0; i < x-16; i++) {
				placeBorrowedTwo[i] = 1;
				sum[2] += binary[i];
			}
		}
			
	}
	
	public int[] getDecimal() {
		return sum;
	}
	
}
