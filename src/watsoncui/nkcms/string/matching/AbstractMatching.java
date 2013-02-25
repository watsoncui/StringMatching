package watsoncui.nkcms.string.matching;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMatching implements Matching {

	protected List<Integer> positions;
	protected byte[] text;
	protected byte[] pattern;
	protected String charset;
	
	
	@Override
	public void match(String text, String pattern) {
		match(text, pattern, "UTF-8");
	}
	
	@Override
	public void match(String text, String pattern, String charset) {
		this.positions = new ArrayList<Integer>();
		this.charset = charset;
		try {
			this.text = text.getBytes(charset);
			this.pattern = pattern.getBytes(charset);
			runMatch();
		} catch(UnsupportedEncodingException UEe) {
			UEe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Integer> getPositions() {
		return positions;
	}
	
	public abstract void runMatch();
}
