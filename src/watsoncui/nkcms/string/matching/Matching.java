package watsoncui.nkcms.string.matching;

import java.util.List;

public interface Matching {
	public void match(String text, String pattern);
	public void match(String text, String pattern, String charset);
	public List<Integer> getPositions();
}
