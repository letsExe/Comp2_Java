package singleton;

import java.lang.reflect.Field;

import model.Model;
import util.Parameter;

public class SingletonQuery {

	private static SingletonQuery instance=null;

	private SingletonQuery () {
	}

	public static SingletonQuery getInstance () {
		if (instance==null) instance = new SingletonQuery();
		return instance;
	}

	public String getFields (  Model m ) {
		String s = "";
		Object value;
		Field[] f = m.getAttributes();
		Boolean first=true;
		for (Field field : f) {
			value = m.get(field.getName());
			if(value==null && field.getName().contains("id")) continue;
			if (!first) {
				s += ",";

			}
			s += field.getName();
			first = false;
		}
		return s;
	}

	public String getValues (  Model m ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String s = "";
		Field[] f = m.getAttributes();
		Boolean first=true;
		Object value;
		for (Field field : f) {
			if (!first) {
				s += ",";
			}
			value = m.get(field.getName());
			if(value==null) {
				continue;
			} else {
				s += "'" + value +"'";
			}
			first = false;
		}
		return s;
	}

	public String getFieldsValues (  Model m ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String s = "";
		Field[] f = m.getAttributes();
		Boolean first=true;
		for (Field field : f) {
			if (!first) {
				s += ",";
			}
			s += field.getName() + "=" + "'" + m.get(field.getName()) +"'";
			first = false;
		}
		return s;
	}

	public String getWHERE ( Parameter... params ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String s = "";
		Boolean first=true;
		for (Parameter param : params ) {
			if (!param.getValue().equals("")) {
				if (!first) {
					s += " AND ";
				}
				switch (param.getOperation()) {
				case EQUAL: s += param.getName() + "=" + "'" + param.getValue() +"'";
				break;
				case LIKE:  s += param.getName() + " LIKE " + "'%" + param.getValue() +"%'";
				break;

				}
				first = false;
			} 
		}
		return (s.equals("")? "" : " WHERE " + s);
	}

	public String getSelect (  Model m, Parameter... params ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return "SELECT " + "*" +
				" FROM " + m.getTableName() +
				getWHERE (params) +
				" ORDER BY " + m.getOrderBy();
	}

	public String getInsert ( Model m ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return "INSERT INTO " + m.getTableName() +
				" ("+ getFields(m)+") " +
				" VALUES ("+getValues(m)+")";
	}

	public String getUpdate ( Model m ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return "UPDATE " + m.getTableName() +
				" SET "+ getFieldsValues(m)+
				" WHERE "+m.getidname() + "=" + m.getid();
	}

	public String getDelete ( Model m ) {
		return "DELETE " +
				" FROM " + m.getTableName() +
				" WHERE " + m.getidname() + "=" + m.getid();
	}
}
