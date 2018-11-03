package br.com.ccee.rh;

import java.util.Collections;
import java.util.List;

import br.com.ccee.rh.dao.DescontosDao;
import br.com.ccee.rh.dao.FuncionarioDao;
import br.com.ccee.rh.model.Descontos;
import br.com.ccee.rh.model.Funcionario;

public class RhApplication {
	public static void main(String[] args) {

		FuncionarioDao funcDao = new FuncionarioDao();
		DescontosDao descDao = new DescontosDao();

		List<Funcionario> listFunc = funcDao.listFuncionarios();

		if (listFunc != null && !listFunc.isEmpty()) {
			
			
			for (Funcionario func : listFunc) {
				Descontos desc = descDao.getTotalDescontos(func.getId());
				func.setSalarioLiquido(func.getSalarioBruto()-desc.getTotal());
				
			}
			
			Collections.sort(listFunc, Collections.reverseOrder());
			for (Funcionario func : listFunc) {
				System.out.println("Nome: "+ func.getNome()+ " ||" +" Salario Liquido: " +func.getSalarioLiquido());
			}
		}

	}

}
