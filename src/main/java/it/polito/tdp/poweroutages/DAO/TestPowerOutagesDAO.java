package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.PowerOutages;

public class TestPowerOutagesDAO {

	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectDB.getConnection();
			connection.close();
			System.out.println("Connection Test PASSED");
			
			PowerOutageDAO dao = new PowerOutageDAO() ;
			
			System.out.println(dao.getNercList()) ;
			
			List<PowerOutages> lista = dao.getOutagesList();
			for(PowerOutages p: lista) {
			System.out.println(p);
			}
		} catch (Exception e) {
			System.err.println("Test FAILED");
		}

	}

}
