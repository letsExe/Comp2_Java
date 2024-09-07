package model;

public class ModelDisciplina extends Model {
	
	protected Integer iddisciplina;
	protected String  nome;
	protected String  sigla;
	protected String  carga_horaria;

	public ModelDisciplina() {
		super("disciplina", "iddisciplina");
		this.iddisciplina = null;
	}

	@Override
	public Model getNewModel() {
		return new ModelDisciplina();
	}
	
	public Integer getidDisciplina() {
		return iddisciplina;
	}

	public void setidDisciplina(Integer idDisciplina) {
		this.iddisciplina = idDisciplina;
	}
	
	public String getsigla() {
		return sigla;
	}

	public void setsigla(String sigla) {
		this.sigla = sigla;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getcarga_horaria() {
		return carga_horaria;
	}

	public void setcarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

}
