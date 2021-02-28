package com.cda.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cda.jee.connection.MyConnection;
import com.cda.jee.model.Currency;
public class CurrencyDAOImp implements IDAO<Currency>{
	private static final Logger logger = LoggerFactory.getLogger(CurrencyDAOImp.class);

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
			logger.error("erreur : " + e);
		}
		return res;
	}

	@Override
	public Currency add(Currency t) {
		Connection c = MyConnection.getConnection();
		Currency cur = getByName(t.getNameCurrency());
		if(cur==null) {
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
				logger.error("erreur : " + e);
				return null;
			}
		}
		else {
			logger.error("Impossible d'ajouter la cryptomonnaie, elle existe déjà en BDD");
			return null;
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
			logger.error("erreur : " + e);
		}
		return res;
	}

	@Override
	public Currency updateById(Currency t) {
		Connection c = MyConnection.getConnection();
		Currency cur = getByName(t.getNameCurrency());
		if(cur!=null) {
			try (PreparedStatement ps = c.prepareStatement("update currency set current_price=? where id_currency=?")) {
				ps.setFloat(1, t.getCurrentPrice());
				ps.setInt(2, t.getIdCurrency());
				ps.executeUpdate();
			} catch (SQLException e) {
				logger.error("erreur : " + e);
			}
		}
		else {
			logger.error("erreur : la cryptomonnaie n'existe pas en BDD");			
		}
		return t;
	}

	@Override
	public void deleteById(int id) {
		Connection c = MyConnection.getConnection();
		Currency cur = getById(id);
		if(cur!=null) {
			try (PreparedStatement ps = c.prepareStatement("delete from currency where id_currency=?")) {
				ps.setInt(1, id);
				ps.executeUpdate();
			} 
			catch (SQLIntegrityConstraintViolationException sqle) {
				logger.error("erreur : " + sqle);
			}
			catch(SQLException e) {
				logger.error("erreur : " + e);
			}
		}
		else {
			logger.error("erreur : la cryptomonnaie n'existe pas en BDD");			
		}
	}

	@Override
	public Currency getByName(String name) {
		Currency res = null;
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("select * from currency where name_currency = ? ")) {
			ps.setString(1, name);
			ResultSet r = ps.executeQuery();
			if (r.next()) {
				res = new Currency(r.getInt("id_currency"),r.getString("name_currency"),r.getString("label_currency"),r.getFloat("current_price"));
			}
		} catch (SQLException e) {
			logger.error("erreur : " + e);
		}
		return res;
	}

}
