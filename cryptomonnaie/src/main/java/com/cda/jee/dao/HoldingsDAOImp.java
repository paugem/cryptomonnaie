package com.cda.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cda.jee.connection.MyConnection;
import com.cda.jee.model.Holdings;

public class HoldingsDAOImp implements IDAO<Holdings>{
	private static final Logger logger = LoggerFactory.getLogger(HoldingsDAOImp.class);

	@Override
	public ArrayList<Holdings> getAll() {
		ArrayList<Holdings> res = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		try (Statement st = c.createStatement()) {
			ResultSet r = st.executeQuery("select * from holding natural join currency");
			while (r.next()) {
				res.add(new Holdings(r.getInt("id_holding"),r.getString("name_currency"),r.getInt("quantity"),
						r.getFloat("unit_purchase_price"),r.getDate("purchase_date"),r.getFloat("current_price"),r.getFloat("unit_purchase_price")-r.getFloat("current_price")));
			}
		} catch (SQLException e) {
			logger.error("erreur : " + e);
		}
		return res;
	}

	@Override
	public Holdings add(Holdings t) {
		Connection c = MyConnection.getConnection();
		Holdings holding = getByName(t.getNameCurrency());
		if(holding==null) {
			try(PreparedStatement statement = c.prepareStatement("select id_currency from currency where currency_name = ?;")){
				statement.setString(1, t.getNameCurrency());
				ResultSet r = statement.executeQuery();
				try (PreparedStatement ps = c.prepareStatement("insert into holding (purchase_date,unit_purchase_price,quantity,id_currency) values (?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS)) {
					ps.setDate(1, t.getPurchaseDate());
					ps.setFloat(2, t.getPurchasePrice());
					ps.setInt(3, t.getQuantity());
					ps.setInt(4, r.getInt("id_currency"));
					ps.executeUpdate();
					ResultSet resultat = ps.getGeneratedKeys();
					if (resultat.next()) {
						t.setIdHoldings(resultat.getInt(1));
					}
					return t;
				} catch (SQLException e) {
					logger.error("erreur : " + e);
					return null;
				}
			}
			catch (SQLException e) {
				logger.error("erreur : " + e);	
				return null;	
			}
		}
		else {
			logger.error("Impossible d'ajouter l'avoir, il existe déjà en BDD");
			System.out.println("Impossible d'ajouter l'avoir, il existe déjà en BDD");
			return null;
		}
	}

	@Override
	public Holdings getById(int id) {
		Holdings res = null;
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("select * from holding natural join currency where id_holding = ? ")) {
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			if (r.next()) {
				res = new Holdings(r.getInt("id_holding"),r.getString("name_currency"),r.getInt("quantity"),
						r.getFloat("unit_purchase_price"),r.getDate("purchase_date"),r.getFloat("current_price"),r.getFloat("current_price")-r.getFloat("unit_purchase_price"));
			}
		} catch (SQLException e) {
			logger.error("erreur : " + e);
		}
		return res;
	}

	@Override
	public Holdings updateById(Holdings t) {
		Connection c = MyConnection.getConnection();
		Holdings holding = getByName(t.getNameCurrency());
		if(holding!=null) {
			try(PreparedStatement statement = c.prepareStatement("select id_currency from currency where currency_name = ?;")){
				statement.setString(1, t.getNameCurrency());
				ResultSet r = statement.executeQuery();
				try (PreparedStatement ps = c.prepareStatement("update holding set purchase_date=?, unit_purchase_price=?,quantity=?,id_currency=? where id_holding=?")) {
					ps.setDate(1, t.getPurchaseDate());
					ps.setFloat(2, t.getPurchasePrice());
					ps.setInt(3, t.getQuantity());
					ps.setInt(4, r.getInt("id_currency"));
					ps.setInt(5, t.getIdHoldings());
					ps.executeUpdate();
					return t;
				} catch (SQLException e) {
					logger.error("erreur : " + e);
				}
			}
			catch (SQLException e) {
				logger.error("erreur : " + e);	
			}
		}
		else {
			logger.error("erreur : l'avoir n'existe pas en BDD");
		}
		return t;
	}

	@Override
	public void deleteById(int id) {
		Connection c = MyConnection.getConnection();
		Holdings holding = getById(id);
		if(holding!=null) {
			try (PreparedStatement ps = c.prepareStatement("delete from holding where id_holding=?")) {
				ps.setInt(1, id);
				ps.executeUpdate();
			} 
			catch (SQLException e) {
				logger.error("erreur : " + e);
			}
		}
		else {
			logger.error("erreur : l'avoir n'existe pas en BDD");			
		}
	}

	@Override
	public Holdings getByName(String name) {
		Holdings res = null;
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("select * from holding natural join currency where name_currency = ? ")) {
			ps.setString(1, name);
			ResultSet r = ps.executeQuery();
			if (r.next()) {
				res = new Holdings(r.getInt("id_holding"),r.getString("name_currency"),r.getInt("quantity"),
						r.getFloat("unit_purchase_price"),r.getDate("purchase_date"),r.getFloat("current_price"),r.getFloat("current_price")-r.getFloat("unit_purchase_price"));
			}
		} catch (SQLException e) {
			logger.error("erreur : " + e);
		}
		return res;
	}

}
