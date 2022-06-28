package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;

public class PowerOutages {
	
	private int id;
	private Nerc nerc;
	private LocalDateTime outageStart;
	private LocalDateTime outageEnd;
	private int affectedPeople;
	
	public PowerOutages(int id, Nerc nerc, LocalDateTime outageStart, LocalDateTime outageEnd, int affectedPeople) {
		super();
		this.id = id;
		this.nerc = nerc;
		this.outageStart = outageStart;
		this.outageEnd = outageEnd;
		this.affectedPeople = affectedPeople;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Nerc getNerc() {
		return nerc;
	}

	public void setNerc(Nerc nerc) {
		this.nerc = nerc;
	}

	public LocalDateTime getOutageStart() {
		return outageStart;
	}

	public void setOutageStart(LocalDateTime outageStart) {
		this.outageStart = outageStart;
	}

	public LocalDateTime getOutageEnd() {
		return outageEnd;
	}

	public void setOutageEnd(LocalDateTime outageEnd) {
		this.outageEnd = outageEnd;
	}

	public int getAffectedPeople() {
		return affectedPeople;
	}

	public void setAffectedPeople(int affectedPeople) {
		this.affectedPeople = affectedPeople;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + affectedPeople;
		result = prime * result + id;
		result = prime * result + ((nerc == null) ? 0 : nerc.hashCode());
		result = prime * result + ((outageEnd == null) ? 0 : outageEnd.hashCode());
		result = prime * result + ((outageStart == null) ? 0 : outageStart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutages other = (PowerOutages) obj;
		if (affectedPeople != other.affectedPeople)
			return false;
		if (id != other.id)
			return false;
		if (nerc == null) {
			if (other.nerc != null)
				return false;
		} else if (!nerc.equals(other.nerc))
			return false;
		if (outageEnd == null) {
			if (other.outageEnd != null)
				return false;
		} else if (!outageEnd.equals(other.outageEnd))
			return false;
		if (outageStart == null) {
			if (other.outageStart != null)
				return false;
		} else if (!outageStart.equals(other.outageStart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PowerOutages [id=" + id + ", nerc=" + nerc + ", outageStart=" + outageStart + ", outageEnd=" + outageEnd
				+ ", affectedPeople=" + affectedPeople + "] ";
	}
	

}
