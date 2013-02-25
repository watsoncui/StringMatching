package watsoncui.nkcms.string.matching;

import java.util.List;

public class KMPMatching extends AbstractMatching {
	
	private int[] support;
	
	public KMPMatching() {
		
	}

	@Override
	public void runMatch() {
		// TODO Auto-generated method stub
		prefix();
		realMatch();
	}
	
	private void realMatch() {
		int textSize =  text.length;
		int patternSize = pattern.length;
		int compareSize = textSize - patternSize + 1;
		int position = 0;
		while(position < compareSize) {
			for(int i = 0; i < patternSize; i++) {
				if(text[position + i] != pattern[i]) {
					position += support[i];
					break;
				}
				if(i == patternSize - 1) {
					positions.add(position);
					position += support[i];
				}
			}
		}
	}
	
	private void prefix() {
		int patternSize = pattern.length;
		support = new int[patternSize];
		support[0] = 0;
		int k = 0;
		for(int i = 2; i < patternSize; i++) {
			while((k > 0) && (pattern[k] != pattern[i - 1])) {
				k = support[k - 1];
			}
			if(pattern[k] == pattern[i - 1]) {
				k++;
			}
			support[i - 1] = k;
		}
		
		for(int i = 0; i < patternSize; i++) {
			support[i] = (support[i] == 0)?(1):(i - support[i]);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Matching sm = new KMPMatching();
		sm.match("this is an example and an exam", "exam");
		List<Integer> intList = sm.getPositions();
		for(int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
	}
}
