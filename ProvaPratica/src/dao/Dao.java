package dao;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Model;
import singleton.SingletonDb;
import singleton.SingletonQuery;
import util.Parameter;

public class Dao {

	protected Model model;
	protected ResultSet resultado;

	public  Dao (Model model) {
		this.model = model;
	}
	
	protected ArrayList<Model> getResultado ( ) throws Exception  {
		ArrayList<Model> list = new ArrayList<Model>();
		Model m;
		while (this.resultado.next()) {
			Field[] fl = this.model.getAttributes();
			m = this.model.getNewModel();
			for (Field field : fl) {
				m.set(field.getName(), 
						resultado.getObject(field.getName()));
			}
			list.add(m);
		}
		return list;
	}
		
	protected void executar (String sql) throws Exception {
		System.out.println(sql);
		SingletonDb.getInstance().getStatement().execute(sql);

		this.resultado = SingletonDb.getInstance().getStatement().getResultSet();
	}

	public ArrayList<Model> consultar (Parameter... params) throws Exception {
		String sql = SingletonQuery.getInstance().getSelect(model, params);
		System.out.println(sql);
		executar ( sql );
		System.out.println(sql);
		return getResultado();
	}
	
	public Integer getMysqlId() {
		try {
			this.executar("select LAST_INSERT_ID()");
			return this.resultado.getInt("LAST_INSERT_ID()");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void salvar ( Model m ) throws Exception {
		String sql = "";
		if (m.getid()==null) {
			sql = SingletonQuery.getInstance().getInsert(m);
		} else {
			sql = SingletonQuery.getInstance().getUpdate(m);
		}
		executar ( sql );
	}

	public void excluir ( Model m ) throws Exception {
		String sql = SingletonQuery.getInstance().getDelete(m);
		executar ( sql );
	}
}
