package br.com.admin.cursos.testes;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.admin.residencia.dao.CategoriaDespesaDAO;
import br.com.admin.residencia.model.CategoriaDespesa;

public class TesteSelectItem {

	public static CategoriaDespesaDAO catDespDao = new CategoriaDespesaDAO();
	public static List<CategoriaDespesa> listCategoriasDesp = catDespDao.listaCategoriaDespesa();

	public static void main(String[] args) {
		List<SelectItem> listItemCatDesp = new ArrayList<SelectItem>();
		for (CategoriaDespesa itemCatDesp : listCategoriasDesp) {
			listItemCatDesp.add(new SelectItem(itemCatDesp.getNome()));
		}
		
		for (SelectItem cd : listItemCatDesp) {
			System.out.println("Label: " + cd.getClass());
		}

	}

	public List<SelectItem> getCategoriaDespesa() {
		List<SelectItem> listItemCatDesp = new ArrayList<SelectItem>();

		for (CategoriaDespesa itemCatDesp : listCategoriasDesp) {
			listItemCatDesp.add(new SelectItem(itemCatDesp.getNome()));
		}
		return listItemCatDesp;
	}

}
