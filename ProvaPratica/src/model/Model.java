package model;
import java.lang.reflect.Field;

public abstract class Model {

	private String table;
	private String orderBy;

	public Model ( String table, String orderBy ) {
		this.table = table;
		this.orderBy = orderBy;
	}

	public abstract Model getNewModel();

	public String getTableName () {
		return this.table;
	}
	
	public String getidname () {
		return "id" + this.table;
	}

	public Object getid () {
		return get ( getidname() );
	}

	public void setid ( Integer value ) {
		set ( getidname(), value );
	}

	public Object get ( String attrib ) {
		try {
			Field field = getClass().getDeclaredField(attrib);
			return field.get(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 
	public void set ( String attrib, Object value ) {
		try {
			Field field = getClass().getDeclaredField(attrib);
			field.set(this, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public Field[] getAttributes ( ) {
		return this.getClass().getDeclaredFields();
	}

	public Model clone ( ) {
		Model m = getNewModel();
		Field[] fields = getAttributes();
		for (Field field : fields) {
			m.set( field.getName(), this.get(field.getName()));
		}
		return m;
	}
	
	public String getOrderBy () {
		return this.orderBy;
	}
	
	@Override
	public String toString() {
		String s="";
		Field[] f = getAttributes();
		for (Field field : f) {
			s += field.getName() + "=" + this.get(field.getName())
			+ "\n";
		}
		return s;
	}

}
