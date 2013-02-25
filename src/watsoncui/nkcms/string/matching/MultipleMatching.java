package watsoncui.nkcms.string.matching;

import java.util.List;

public interface MultipleMatching {
	public void match(String text, List<String> patterns);
	public void match(String text, List<String> patterns, String charset);
	public List<Integer> getPositionsStart();
	public List<Integer> getPositionsEnd();
}
