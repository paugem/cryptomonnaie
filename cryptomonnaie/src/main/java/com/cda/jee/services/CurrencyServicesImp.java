package com.cda.jee.services;

import java.util.ArrayList;

import com.cda.jee.dao.CurrencyDAOImp;
import com.cda.jee.model.Currency;

public class CurrencyServicesImp implements IServices<Currency> {
	CurrencyDAOImp currencyDao = new CurrencyDAOImp();

	@Override
	public ArrayList<Currency> index() {
		return currencyDao.getAll();
	}

	@Override
	public Currency create(Currency t) {
		return currencyDao.add(t);
	}

	@Override
	public Currency read(int id) {
		return currencyDao.getById(id);
	}

	@Override
	public Currency update(Currency t) {
		return currencyDao.updateById(t);
	}

	@Override
	public void delete(int id) {
		currencyDao.deleteById(id);
	}

}
