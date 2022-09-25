import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import metier.Compte;
import rmi.IBanqueRemote;

public class ClientRMI {

	public static void main(String[] args) {
		try {
			IBanqueRemote  stub = (IBanqueRemote) 
					Naming.lookup("rmi://localhost:1099/BK");
			System.out.println("Conversion de 10 Euro est : "+stub.conversion(10)+" DHs");
			System.out.println("--------------------------------------------------------------");
			Compte cp = stub.consulterCompte(1);
			System.out.println("Code : "+ cp.getCode());
			System.out.println("Solde : "+ cp.getSolde()+ " DHs");
			System.out.println("Date : "+ cp.getDateCreation());
			System.out.println("--------------------------------------------------------------");
			List<Compte> comptes = stub.listComptes();
			comptes.forEach(c->{
				System.out.println("Code : "+ c.getCode());
				System.out.println("Solde : "+ c.getSolde()+ " DHs");
				System.out.println("Date : "+ c.getDateCreation());
				System.out.println("------------------");
			});
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}

}
