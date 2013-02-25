package watsoncui.nkcms.string.matching;

import java.util.List;

public class State {
	public int id;
	public byte data;
	public List<Integer> links;
	public boolean isTerminal;
	public int deep;
	public int fatherID;
}
