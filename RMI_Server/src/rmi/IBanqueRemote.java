package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import metier.Compte;

public interface IBanqueRemote extends Remote {
	
	public double conversion(double mt) throws RemoteException;
	public Compte consulterCompte(int code) throws RemoteException ;
	public List<Compte> listComptes() throws RemoteException;

}
