package br.com.admin.cursos.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.admin.residencia.dao.DespesaDAO;
import br.com.admin.residencia.model.Contabilidade;

public class TesteConvertDate {
	
	public static void main(String[] args) throws ParseException {
		DespesaDAO dao = new DespesaDAO();
		Contabilidade c = new Contabilidade();
		List<Contabilidade> lista = dao.listaDespesa();
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		String strData = "1989-31-12";
 		
 		String novaData = sdf.format(now);
 		System.out.println(novaData);
		
		// Date novaData = sdf.parse(strData);
				
		// c.setData(new java.sql.Date(now.getTime()));
		
		// System.out.println(novaData);
		
	}

	/*
	 * public static void main(String[] args) throws ParseException { Scanner scan =
	 * new Scanner(System.in); DespesaDAO dao = new DespesaDAO(); Date hoje = new
	 * Date(); Contabilidade c = new Contabilidade(); int cont = 0; do {
	 * System.out.println("Nome: "); c.setNome(scan.nextLine());
	 * System.out.println("Valor: "); c.setValor(scan.nextDouble());
	 * System.out.println("Descrição: "); c.setDescricao(scan.nextLine());
	 * System.out.println("Cod. Despesa: ");
	 * c.setIdCategoriaDespesa(scan.nextInt()); // System.out.println("Data: "); //
	 * c.setData(hoje); System.out.println("Confirma registro: 1.SIM - 0.NÃO \n" +
	 * c.toString()); cont = scan.nextInt(); } while (cont != 1); if(cont == 1) {
	 * if(dao.salvaContabilidadeDAO(c)) { c = new Contabilidade(); } }
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); String strHoje =
	 * sdf.format(hoje);
	 * 
	 * List<Contabilidade> listContabil = dao.listaDespesa(); for (Contabilidade ct:
	 * listContabil) { System.out.println(c.toString()); } c.setData(hoje);
	 * c.setData(hoje); dao.salvaContabilidadeDAO(c);
	 * 
	 * System.out.println("Antes: " + c.getData()); System.out.println("Depois: " +
	 * strHoje); }
	 */

}
