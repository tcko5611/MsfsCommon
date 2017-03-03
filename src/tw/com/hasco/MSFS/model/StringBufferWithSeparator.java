package tw.com.hasco.MSFS.model;

public class StringBufferWithSeparator {
	private StringBuffer buffer = new StringBuffer();
	private final String sep;
	
	public StringBufferWithSeparator(String separator) {
		sep = separator;
	}
	
	public StringBufferWithSeparator append(Object value) {
		buffer.append(value).append(sep);
		return this;
	}
	
	@Override
	public String toString() {
		return buffer.toString();
	}
	
	public StringBufferWithSeparator removeLastSeparator() {
		buffer = buffer.delete(buffer.length() - sep.length(), buffer.length());
		return this;
	}
	
	public StringBuffer toStringBuffer() {
		return buffer;
	}
}
