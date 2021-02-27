package com.cda.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cda.jee.connection.MyConnection;
import com.cda.jee.model.Currency;
public class CurrencyDAOImp implements IDAO<Currency>{

	@Override
	public ArrayList<Currency> getAll() {
		ArrayList<Currency> res = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		try (Statement st = c.createStatement()) {
			ResultSet r = st.executeQuery("select * from currency");
			while (r.next()) {
				res.add(new Currency(r.getInt("id_currency"),r.getString("name_currency"),r.getString("label_currency"),r.getFloat("current_price")));
			}
		} catch (SQLException e) {
			//log + erreur à faire
		}
		return res;
	}

	@Override
	public Currency add(Currency t) {
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("insert into currency (name_currency,label_currency,current_price) values (?,?,?); ",
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, t.getNameCurrency());
			ps.setString(2, t.getLabel());
			ps.setFloat(3, t.getCurrentPrice());
			ps.executeUpdate();
			ResultSet resultat = ps.getGeneratedKeys();
			if (resultat.next()) {
				t.setIdCurrency(resultat.getInt(1));
			}
			return t;
		} catch (SQLException e) {
			//log + erreur à faire + return t à virer
			return t;
		}
		
	}

	@Override
	public Currency getById(int id) {
		Currency res = null;
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("select * from currency where id_currency = ? ")) {
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			if (r.next()) {
				res = new Currency(r.getInt("id_currency"),r.getString("name_currency"),r.getString("label_currency"),r.getFloat("current_price"));
			}
		} catch (SQLException e) {
			//log + erreur à faire + return res à virer
			return res;
		}
		return res;
	}

	@Override
	public Currency updateById(Currency t) {
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("update currency set current_price=? where id_currency=?")) {
			ps.setFloat(1, t.getCurrentPrice());
			ps.setInt(2, t.getIdCurrency());
			ps.executeUpdate();
			return t;
		} catch (SQLException e) {
			//log + erreur à faire + return t à virer
			return t;
		}
	}

	@Override
	public void deleteById(int id) {
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("delete from currency where id_currency=?")) {
			ps.setInt(1, id);
		} 
		catch (SQLException e) {
			//log + erreur à faire
		}
	}

}
