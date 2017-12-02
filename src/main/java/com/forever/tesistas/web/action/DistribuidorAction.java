package com.forever.tesistas.web.action;

import com.forever.tesistas.web.hibernate.Distribuidor;
import com.forever.tesistas.web.hibernate.DistribuidorDAO;

public class DistribuidorAction {
	private Distribuidor distribuidor;
	private Integer distribuidorId;

	public String deleteDistribuidor() {
		DistribuidorDAO distribuidorDAO = new DistribuidorDAO();
		distribuidor = distribuidorDAO.getById(distribuidorId);
		if (distribuidor == null || distribuidor.getId() == null) {
			return "nothingToDelete";
		} else {
			distribuidorDAO.deleteDistribuidor(distribuidor);
			return "success";
		}
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public Integer getDistribuidorId() {
		return distribuidorId;
	}

	public void setDistribuidorId(Integer distribuidorId) {
		this.distribuidorId = distribuidorId;
	}

}
