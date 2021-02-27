package com.cda.jee.services;

import java.util.ArrayList;

import com.cda.jee.dao.HoldingsDAOImp;
import com.cda.jee.model.Holdings;

public class HoldingsServicesImp implements IServices<Holdings> {
	HoldingsDAOImp holdingsDao = new HoldingsDAOImp();
	@Override
	public ArrayList<Holdings> index() {
		return holdingsDao.getAll();
	}

	@Override
	public Holdings create(Holdings t) {
		return holdingsDao.add(t);
	}

	@Override
	public Holdings read(int id) {
		return holdingsDao.getById(id);
	}

	@Override
	public Holdings update(Holdings t) {
		return holdingsDao.updateById(t);
	}

	@Override
	public void delete(int id) {
		holdingsDao.deleteById(id);
	}

}
