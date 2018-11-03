package br.com.ccee.rh.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ccee.rh.model.Descontos;

public class DescontosDao {

	public Descontos getTotalDescontos(Integer idFunc) {
		ConectionManager conectionManager = new ConectionManager();
		Connection connection = conectionManager.getConnection();

		Descontos desc = new Descontos();

		try {

			Statement stmt = connection.createStatement();

			ResultSet result = stmt.executeQuery(
					"select id_funcionario, SUM(vl_desconto_number) as total from descontos where id_funcionario="
							+ idFunc + " group by id_funcionario");
			while (result.next()) {

				desc.setIdFuncionario(idFunc);
				desc.setTotal(result.getDouble("total"));

			}

			result.close();

			stmt.close();

			connection.close();

		} catch (SQLException sqle) {

			sqle.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return desc;

	}

}
