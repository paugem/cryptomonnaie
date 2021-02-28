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
import com.cda.jee.model.Holding;

public class HoldingDAOImp implements IDAO<Holding>{
	private static final Logger logger = LoggerFactory.getLogger(HoldingDAOImp.class);

	@Override
	public ArrayList<Holding> getAll() {
		ArrayList<Holding> res = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		try (Statement st = c.createStatement()) {
			ResultSet r = st.executeQuery("select * from holding natural join currency");
			while (r.next()) {
				res.add(new Holding(r.getInt("id_holding"),r.getString("name_currency"),r.getInt("quantity"),
						r.getFloat("unit_purchase_price"),r.getDate("purchase_date"),r.getFloat("current_price"),r.getFloat("unit_purchase_price")-r.getFloat("current_price")));
			}
		} catch (SQLException e) {
			logger.error("erreur : " + e);
		}
		return res;
	}

	@Override
	public Holding add(Holding t) {
		Connection c = MyConnection.getConnection();
		Holding holding = getByName(t.getNameCurrency());
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
						t.setIdHolding(resultat.getInt(1));
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
	public Holding getById(int id) {
		Holding res = null;
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("select * from holding natural join currency where id_holding = ? ")) {
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			if (r.next()) {
				res = new Holding(r.getInt("id_holding"),r.getString("name_currency"),r.getInt("quantity"),
						r.getFloat("unit_purchase_price"),r.getDate("purchase_date"),r.getFloat("current_price"),r.getFloat("current_price")-r.getFloat("unit_purchase_price"));
			}
		} catch (SQLException e) {
			logger.error("erreur : " + e);
		}
		return res;
	}

	@Override
	public Holding updateById(Holding t) {
		Connection c = MyConnection.getConnection();
		Holding holding = getByName(t.getNameCurrency());
		if(holding!=null) {
			try(PreparedStatement statement = c.prepareStatement("select id_currency from currency where currency_name = ?;")){
				statement.setString(1, t.getNameCurrency());
				ResultSet r = statement.executeQuery();
				try (PreparedStatement ps = c.prepareStatement("update holding set purchase_date=?, unit_purchase_price=?,quantity=?,id_currency=? where id_holding=?")) {
					ps.setDate(1, t.getPurchaseDate());
					ps.setFloat(2, t.getPurchasePrice());
					ps.setInt(3, t.getQuantity());
					ps.setInt(4, r.getInt("id_currency"));
					ps.setInt(5, t.getIdHolding());
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
		Holding holding = getById(id);
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
	public Holding getByName(String name) {
		Holding res = null;
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("select * from holding natural join currency where name_currency = ? ")) {
			ps.setString(1, name);
			ResultSet r = ps.executeQuery();
			if (r.next()) {
				res = new Holding(r.getInt("id_holding"),r.getString("name_currency"),r.getInt("quantity"),
						r.getFloat("unit_purchase_price"),r.getDate("purchase_date"),r.getFloat("current_price"),r.getFloat("current_price")-r.getFloat("unit_purchase_price"));
			}
		} catch (SQLException e) {
			logger.error("erreur : " + e);
		}
		return res;
	}

}
