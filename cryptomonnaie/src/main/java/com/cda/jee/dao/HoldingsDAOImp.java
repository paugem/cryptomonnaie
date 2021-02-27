package com.cda.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cda.jee.connection.MyConnection;
import com.cda.jee.model.Holdings;

public class HoldingsDAOImp implements IDAO<Holdings>{

	@Override
	public ArrayList<Holdings> getAll() {
		ArrayList<Holdings> res = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		try (Statement st = c.createStatement()) {
			ResultSet r = st.executeQuery("select * from holding natural join currency");
			while (r.next()) {
				res.add(new Holdings(r.getInt("id_holding"),r.getString("name_currency"),r.getInt("quantity"),
						r.getFloat("unit_purchase_price"),r.getDate("purchase_date"),r.getFloat("current_price"),r.getFloat("current_price")-r.getFloat("unit_purchase_price")));
			}
		} catch (SQLException e) {
			//log + erreur à faire
		}
		return res;
	}

	@Override
	public Holdings add(Holdings t) {
		Connection c = MyConnection.getConnection();
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
				//log + erreur à faire + return t à virer
				return t;
			}
		}
		catch (SQLException e) {
			//log + erreur à faire + return t à virer
			return t;			
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
			//log + erreur à faire + return res à virer
			return res;
		}
		return res;
	}

	@Override
	public Holdings updateById(Holdings t) {
		Connection c = MyConnection.getConnection();
		try(PreparedStatement statement = c.prepareStatement("select id_currency from currency where currency_name = ?;")){
			statement.setString(1, t.getNameCurrency());
			ResultSet r = statement.executeQuery();
			try (PreparedStatement ps = c.prepareStatement("update holding set purchase_date=?, unit_purchase_price=?,quantity=?,id_currency=? where id_holding=?")) {
				ps.setDate(1, t.getPurchaseDate());
				ps.setFloat(2, t.getPurchasePrice());
				ps.setInt(3, t.getQuantity());
				ps.setInt(4, r.getInt("id_currency"));
				ps.executeUpdate();
				return t;
			} catch (SQLException e) {
				//log + erreur à faire + return t à virer
				return t;
			}
		}
		catch (SQLException e) {
			//log + erreur à faire + return t à virer
			return t;			
		}
	}

	@Override
	public void deleteById(int id) {
		Connection c = MyConnection.getConnection();
		try (PreparedStatement ps = c.prepareStatement("delete from holding where id_holding=?")) {
			ps.setInt(1, id);
		} 
		catch (SQLException e) {
			//log + erreur à faire
		}
	}

}
