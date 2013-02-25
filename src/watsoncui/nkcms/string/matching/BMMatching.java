package watsoncui.nkcms.string.matching;

public class BMMatching extends AbstractMatching {
	
	private int[] distanceOne;
	private int[] distanceTwo;
	private int textSize;
	private int patternSize;

	@Override
	public void runMatch() {
		// TODO Auto-generated method stub
		textSize =  text.length;
		patternSize = pattern.length;
		int compareSize = textSize - patternSize + 1;
		distanceOne = new int[patternSize];
		distanceTwo = new int[patternSize];
		calcDistanceOne();
		calcDistanceTwo();
	}

	private void calcDistanceOne() {
		distanceOne[0] = 0;
		int flag = patternSize - 2;
		for(int i = 1; i < patternSize; i++) {
			if(flag >= 0) {
				if(pattern[patternSize - i] == pattern[flag]) {
					distanceOne[i] = patternSize - i - flag;
					flag--;
					continue;
				} else {
					int j = flag - 1;
					for(; j > 0; j--) {
						if(pattern[patternSize - i] == pattern[j]) {
							boolean success = true;
							int tempJ = j + 1;
							for(int temp = patternSize - i + 1; temp < patternSize; temp++,tempJ++) {
								if(pattern[temp] != pattern[tempJ]) {
									success = false;
									break;
								}
							}
							if(success) {
								flag = j - 1;
								distanceOne[i] = patternSize - i - flag;
								break;
							}
						}
					}
					if(j == 0) {
						distanceOne[i] = patternSize;
						flag = -1;
					}
				}
			} else {
				distanceOne[i] = patternSize;
			}
		}
	}
	
	private void calcDistanceTwo() {
		distanceTwo[0] = 0;
		for(int i = 1; i < patternSize; i++) {
			if(pattern[0] == pattern[patternSize - i]) {
				boolean success = true;
				for(int j = 1; j < i; j++) {
					if(pattern[i] != pattern[patternSize - i + j]) {
						success = false;
						break;
					}
				}
				if(success == true) {
					distanceTwo[i] = i;
				} else {
					distanceTwo[i] = distanceTwo[i - 1];
				}
			} else {
				distanceTwo[i] = distanceTwo[i - 1];
			}
		}
	}
	
	private int compareMove(byte b) {
		
	}
	
	public void printDistances() {
		for(int i = 0; i < patternSize; i++) {
			System.out.println(distanceOne[i]);
		}
		System.out.println();
		for(int i = 0; i < patternSize; i++) {
			System.out.println(distanceTwo[i]);
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
