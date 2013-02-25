package watsoncui.nkcms.string.matching;

import java.util.ArrayList;
import java.util.List;

public class AhoCorasick extends AbstractMultipleMatching {

	private final static int INITIAL = -1;
	private final static int HEADID = 0;
	private Trie tree;
	private int[] supplyChain;
	private State[] trieTree;
	
	@Override
	public void runMatch() {
		// TODO Auto-generated method stub
		fillTree();
		makeMatch();
	}
	
	private void makeMatch() {
		int textLength = text.length;
		State state = trieTree[HEADID];
		for(int i = 0; i < textLength; i++) {
			int next = findNext(state, text[i]);
			if(next == HEADID) {
				while(state.id != HEADID) {
					state = trieTree[supplyChain[state.id]];
					next = findNext(state, text[i]);
					if(next != HEADID) {
						state = trieTree[next];
						break;
					}
				}
			} else {
				state = trieTree[next];
			}
			if(state.isTerminal) {
				positionsEnd.add(i);
				positionsStart.add(i - state.deep + 1);
			}
		}
	}
	
	private int findNext(State state, byte ch) {
		List<Integer> nexts = state.links;
		for(int next:nexts) {
			if(trieTree[next].data == ch) {
				return next;
			}
		}
		return HEADID;
	}
	
	private void fillTree() {
		tree = new Trie(patterns);
		tree.buildTree();
		List<State> states = tree.getTree();
		int size = states.size();
		supplyChain = new int[size];
		trieTree = new State[size];
		for(int i = 0; i < size; i++) {
			supplyChain[i] = INITIAL;
			trieTree[i] = states.get(i);
			
		}
		for(int i = 0; i < size; i++) {
			if(!isChanged(supplyChain[i])) {
				int fatherId = trieTree[i].fatherID;
				if(fatherId > HEADID) {
					int index = supplyChain[fatherId];
					List<Integer> nexts = trieTree[index].links;
					for(int next:nexts) {
						if(trieTree[i].data == trieTree[next].data) {
							supplyChain[i] = trieTree[next].id;
							if(trieTree[next].isTerminal) {
								trieTree[i].isTerminal = true;
							}
							break;
						}
					}
					if(!isChanged(supplyChain[i])) {
						supplyChain[i] = HEADID;
					}
				} else {
					supplyChain[i] = HEADID;
				}
			}
		}
	}
	
	private boolean isChanged(int supply) {
		return (supply != INITIAL);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "annually_announce";
		List<String> patterns = new ArrayList<String>();
		patterns.add("announce");
		patterns.add("annual");
		patterns.add("annually");
		MultipleMatching multm = new AhoCorasick();
		multm.match(text, patterns);
		List<Integer> starts = multm.getPositionsStart();
		List<Integer> ends = multm.getPositionsEnd();
		
		for(int i = 0; i < starts.size(); i++) {
			System.out.println(starts.get(i) + " " + ends.get(i));
		}
		
		text = "AGATACGATATATAC";
		multm.match(text, patterns);
		starts = multm.getPositionsStart();
		ends = multm.getPositionsEnd();
		for(int i = 0; i < starts.size(); i++) {
			System.out.println(starts.get(i) + " " + ends.get(i));
		}
		
		
	}

}
