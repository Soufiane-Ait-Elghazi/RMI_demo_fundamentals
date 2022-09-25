package jeu;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IJeuRemote extends Remote {
	public String jouer(int nombre) throws RemoteException;

}
