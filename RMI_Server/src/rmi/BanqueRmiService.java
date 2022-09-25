package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import metier.Compte;

public class BanqueRmiService extends UnicastRemoteObject implements IBanqueRemote{

	
	public BanqueRmiService() throws RemoteException {super();}

	@Override
	public double conversion(double mt) throws RemoteException {
		System.out.println("Conversion du montant "+mt);
		return 11*mt;
	}

	@Override
	public Compte consulterCompte(int code) throws RemoteException {
		System.out.println("Consultation du compte "+code);
		Compte compte = new  Compte();
		compte.setCode(1);
		compte.setDateCreation(new Date());
		compte.setSolde(Math.random()*1000);
		return compte;
	}

	@Override
	public List<Compte> listComptes() throws RemoteException {
		System.out.println("Consultation de comptes");
		List<Compte> comptes = new ArrayList<>();
		comptes.add(new Compte(2, Math.random()*1000,new Date()));
		comptes.add(new Compte(3, Math.random()*1000,new Date()));
		comptes.add(new Compte(4, Math.random()*1000,new Date()));
		comptes.add(new Compte(5, Math.random()*1000,new Date()));
		return comptes;
	}

}
