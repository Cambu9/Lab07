package it.polito.tdp.poweroutages.model;

import java.time.temporal.ChronoUnit;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	private List<PowerOutages> allPO;
	private int min = 0;
	private int max = 2014;
	private long sommaOre = 0;
	private int best = 0;
	
	
	public Model() {
		podao = new PowerOutageDAO();
		this.allPO = podao.getOutagesList();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public String cerca2(List<PowerOutages> parziale, int anni, int ore) {
		cerca(parziale, anni, ore);
		return ""+ best + "";
	}
	
	public void cerca(List<PowerOutages> parziale, int anni, int ore) {
		int affectedPeople = 0;
	
		for(PowerOutages p: parziale) {
			affectedPeople = affectedPeople + p.getAffectedPeople();
		}
		
		if(best < affectedPeople)
			best = affectedPeople;
		
		for (PowerOutages pO: allPO) {
			if(aggiuntaValida(parziale, pO, anni, ore)) {
				parziale.add(pO);
				cerca(parziale, anni, ore);
				parziale.remove(parziale.size()-1);
			}
		}
		
	}


	private boolean aggiuntaValida(List<PowerOutages> parziale, PowerOutages pO, int anni, int ore) {
		// dataInizio.until(dataFine, ChronoUnit.hours);
		if(pO.getOutageStart().getYear() > min) {
			min = pO.getOutageStart().getYear();
		}
		if(pO.getOutageEnd().getYear() < max) {
			max = pO.getOutageEnd().getYear();
		}
		
		if((max-min) <= anni) {
			if(pO.getOutageStart().until(pO.getOutageEnd(), ChronoUnit.HOURS)+sommaOre <= ore) {
				sommaOre = sommaOre + pO.getOutageStart().until(pO.getOutageEnd(), ChronoUnit.HOURS);
				return true;
			}
		}
		return false;
	}
}
