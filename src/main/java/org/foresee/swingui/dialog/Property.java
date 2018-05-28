package org.foresee.swingui.dialog;

public class Property {
	public Object key;
	public Object value;
	public Property(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public String toString() {
		return "key = "+key+", value = "+value;
	}
}
