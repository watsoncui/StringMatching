package watsoncui.nkcms.string.matching;

import java.util.List;

public class HorspoolMatching extends AbstractMatching {

	@Override
	public void runMatch() {
		// TODO Auto-generated method stub
		int textSize =  text.length;
		int patternSize = pattern.length;
		int compareSize = textSize - patternSize + 1;
		int position = 0;
		while (position < compareSize) {
			boolean success = true;
			for(int i = patternSize - 1; i >= 0 ; i--) {
				if(text[i + position] != pattern[i]) {
					success = false;
					position += compareMove(text[patternSize + position - 1]);
					break;
				}
			}
			if(success) {
				positions.add(position);
				position += compareMove(text[patternSize + position - 1]);
			}
		}
	}
	
	private int compareMove(byte b) {
		for(int i = pattern.length - 2; i >= 0; i--) {
			if(pattern[i] == b) {
				return pattern.length - i - 1;
			}
		}
		return pattern.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matching sm = new HorspoolMatching();
		sm.match("eexamxeamamemexam", "exam");
		List<Integer> intList = sm.getPositions();
		for(int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		
	}
}
