package watsoncui.nkcms.string.matching;

import java.util.List;

public class SimpleMatching extends AbstractMatching{
	
	public SimpleMatching() {
		
	}

	@Override
	public void runMatch() {
		int textLength =  text.length;
		int patternLength = pattern.length;
		int compareLength = textLength - patternLength + 1;
		for(int i = 0; i < compareLength; i++) {
			for(int j = 0; j < patternLength; j++) {
				if(text[i+j] != pattern[j]) {
					break;
				}
				if(j == patternLength - 1) {
					positions.add(i);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleMatching sm = new SimpleMatching();
		sm.match("this is an example and an exam", "exam");
		List<Integer> intList = sm.getPositions();
		for(int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
	}
}
