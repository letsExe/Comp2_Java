package controller;

import model.Model;
import util.Parameter;

public interface Controller {

    void consultar (Parameter... params) throws Exception;

    void salvar (Model model) throws Exception;
    void excluir(Model model) throws Exception;

    void manter(Model model) throws Exception;
}
