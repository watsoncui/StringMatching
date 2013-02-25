package watsoncui.nkcms.string.matching;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMultipleMatching implements MultipleMatching {

	protected List<Integer> positionsEnd;
	protected List<Integer> positionsStart;
	protected byte[] text;
	protected List<byte[]> patterns;
	protected String charset;
	
	@Override
	public void match(String text, List<String> patterns) {
		// TODO Auto-generated method stub
		match(text, patterns, "UTF-8");
	}

	@Override
	public void match(String text, List<String> patterns, String charset) {
		// TODO Auto-generated method stub
		this.positionsStart = new ArrayList<Integer>();
		this.positionsEnd = new ArrayList<Integer>();
		this.patterns = new ArrayList<byte[]>();
		this.charset = charset;
		try {
			this.text = text.getBytes(charset);
			for(String pattern:patterns) {
				this.patterns.add(pattern.getBytes(charset));
			}
			runMatch();
		} catch(UnsupportedEncodingException UEe) {
			UEe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void runMatch();

	@Override
	public List<Integer> getPositionsStart() {
		// TODO Auto-generated method stub
		return positionsStart;
	}

	@Override
	public List<Integer> getPositionsEnd() {
		// TODO Auto-generated method stub
		return positionsEnd;
	}

}
