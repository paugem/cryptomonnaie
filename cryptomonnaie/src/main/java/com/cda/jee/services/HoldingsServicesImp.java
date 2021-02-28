package com.cda.jee.services;

import java.util.ArrayList;

import com.cda.jee.dao.HoldingDAOImp;
import com.cda.jee.model.Holding;

public class HoldingsServicesImp implements IServices<Holding> {
	HoldingDAOImp holdingsDao = new HoldingDAOImp();
	
	@Override
	public ArrayList<Holding> index() {
		return holdingsDao.getAll();
	}

	@Override
	public Holding create(Holding t) {
		return holdingsDao.add(t);
	}

	@Override
	public Holding read(int id) {
		return holdingsDao.getById(id);
	}

	@Override
	public Holding update(Holding t) {
		return holdingsDao.updateById(t);
	}

	@Override
	public void delete(int id) {
		holdingsDao.deleteById(id);
	}

}
