package controller;

import dao.Dao;
import model.Model;
import model.ModelDisciplina;
import util.Parameter;
import view.ViewConsultarDisciplina;
import view.ViewManterDisciplina;

public class ControllerDisciplina implements Controller {
	
	private Dao dao = new Dao ( new ModelDisciplina() );
	private ViewConsultarDisciplina viewConsultar = new ViewConsultarDisciplina(this);
	private ViewManterDisciplina viewManter = new ViewManterDisciplina(this);

	public ControllerDisciplina() {
		viewConsultar.mostrar();
	}
	
	@Override
	public void consultar(Parameter... params) throws Exception {
		viewConsultar.setData(dao.consultar(params));
	}

	@Override
	public void salvar(Model model) throws Exception {
		dao.salvar(model);
	}

	@Override
	public void excluir(Model model) throws Exception {
		dao.excluir(model);
	}

	@Override
	public void manter(Model model) throws Exception {
		viewManter.mostrar(model);
	}
	
}
