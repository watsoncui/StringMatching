package watsoncui.nkcms.string.matching;

import java.util.List;

public class MyMatch extends AbstractMatching {
	
	@Override
	public void runMatch() {
		int textSize =  text.length;
		int patternSize = pattern.length;
		int compareSize = textSize - patternSize + 1;
		int patternSum = 0;
		int patternDiff = 0;
		int textSum = 0;
		int textDiff = 0;
		boolean odd = ((patternSize%2)==0)?false:true;
		
		for(int i = 0; i < patternSize; i++) {
			patternSum += pattern[i];
			patternDiff = pattern[i] - patternDiff;
			textSum += text[i];
			textDiff = text[i] - textDiff;
		}
		
		for(int i = 0; i < compareSize - 1; i++) {
			if((textDiff == patternDiff) && (textSum == patternSum)) {
				for(int j = 0; j < patternSize; j++) {
					if(text[i+j] != pattern[j]) {
						break;
					}
					if(j == patternSize - 1) {
						positions.add(i);
					}
				}
			} else {
				if(odd) {
					textDiff -= text[i];
				} else {
					textDiff += text[i];
				}
				textSum += (text[i + patternSize] - text[i]);
				textDiff = text[i + patternSize] - textDiff;
			}
		}
		
		for(int j = 0; j < patternSize; j++) {
			if(text[compareSize - 1 + j] != pattern[j]) {
				break;
			}
			if(j == patternSize - 1) {
				positions.add(compareSize - 1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matching sm = new MyMatch();
		sm.match("this is an example and an exam", "exam");
		List<Integer> intList = sm.getPositions();
		for(int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
	}

}
