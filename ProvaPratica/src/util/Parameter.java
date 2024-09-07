package util;

public class Parameter {
	
	private String name;
	private Object value;
	private Operation operation;
	
	public enum Operation {LIKE, EQUAL};
	
	public Parameter ( String name, Object value ) {
		this.name = name;
		this.value = value;
		this.operation = Operation.LIKE;
	}
	
	public Parameter ( String name, Object value, Operation operation ) {
		this.name = name;
		this.value = value;
		this.operation = operation;
	}
	
	public String getName () {
		return this.name;
	}
	
	public Object getValue () {
		return this.value;
	}
	
	public Operation getOperation () {
		return this.operation;
	}

}
