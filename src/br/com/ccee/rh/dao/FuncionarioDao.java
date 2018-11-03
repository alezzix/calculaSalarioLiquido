package br.com.ccee.rh.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ccee.rh.model.Funcionario;

public class FuncionarioDao {

	public List<Funcionario> listFuncionarios() {
		ConectionManager conectionManager = new ConectionManager();
		Connection connection = conectionManager.getConnection();
		
		List<Funcionario> listFunc = new ArrayList<Funcionario>();

		try {
			

			Statement stmt = connection.createStatement();

			ResultSet result = stmt.executeQuery("select * from funcionario"); 

			while (result.next()) { 
				
				Funcionario func = new Funcionario();
				
				func.setId(result.getInt("id_funcionario"));
				func.setNome(result.getString("nm_cliente"));
				func.setSalarioBruto(result.getDouble("vl_salario_bruto"));
				
				listFunc.add(func);

			}

			result.close();

			stmt.close();

			connection.close();

		} catch (SQLException sqle) {

			sqle.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return listFunc;

	}

}
