package watsoncui.nkcms.string.matching;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	private List<byte[]> patterns;
	private List<State> tree;
	private State head;
	
	public Trie(List<byte[]> patterns) {
		this.patterns = patterns;
		this.head = new State();
		this.tree = new ArrayList<State>();
		head.id = 0;
		head.deep = 0;
		head.isTerminal = false;
		head.links = new ArrayList<Integer>();
		head.data = 0;
		head.fatherID = -1;
		this.tree.add(this.head);
	}
	
	public void buildTree() {
		if(null != tree) {
			for(byte[] pattern:patterns) {
				int patternLength = pattern.length;
				int treeLength = tree.size();
				int i = 0;
				State cursor = head;
				int flag = -1;
				while((flag = dataInNext(pattern[i], cursor)) != -1) {
					cursor = tree.get(cursor.links.get(flag));
					i++;
				}
				for(int j = i; j < patternLength; j++) {
					State state = new State();
					state.data = pattern[j];
					state.deep = j + 1;
					state.links = new ArrayList<Integer>();
					state.id = treeLength;
					state.fatherID = cursor.id;
					if(j == patternLength - 1) {
						state.isTerminal = true;
					} else {
						state.isTerminal = false;
					}
					tree.add(state);
					cursor.links.add(treeLength);
					cursor = state;
					treeLength++;
				}
			}
		}
	}
	
	private int dataInNext(byte data, State state) {
		int length = state.links.size();
		for(int i = 0; i < length; i++) {
			if(data == tree.get(state.links.get(i)).data) {
				return i;
			}
		}
		return -1;
	}
	
	public List<State> getTree() {
		return this.tree;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strs = new ArrayList<String>();
		List<byte[]> patterns = new ArrayList<byte[]>(); 
		strs.add("announce");
		strs.add("annual");
		strs.add("annually");
		strs.add("ATATATA");
		strs.add("TATAT");
		strs.add("ACGATAT");
		for(String str:strs) {
			patterns.add(str.getBytes());
		}
		Trie trie = new Trie(patterns);
		trie.buildTree();
		List<State> result = trie.getTree();
		
		for(int i = 0; i < result.size(); i++) {
			State temp = result.get(i);
			System.out.print(temp.id);
			System.out.print('\t');
			System.out.print(temp.data);
			System.out.print('\t');
			System.out.print(temp.deep);
			System.out.print('\t');
			System.out.print(temp.isTerminal);
			System.out.print('\t');
			System.out.print(temp.fatherID);
			System.out.print('\t');
			for(int j = 0; j < temp.links.size(); j++) {
				System.out.print(temp.links.get(j));
				System.out.print('\t');
			}
			System.out.println();
		}
	}

}
