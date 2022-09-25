package jeu;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public class JeuImp extends UnicastRemoteObject implements IJeuRemote {

	private int nombreSucret ;
	private boolean fin;
	
	
	public JeuImp() throws RemoteException {
		super();
		genererSecret();
	}
	
	
	private void genererSecret() {
		nombreSucret =(int)( Math.random()*10);
	}

	@Override
	public String jouer(int nombre) throws RemoteException {
		if(!fin) {
			
			if(nombre > nombreSucret) {
				return " Votre nombre est plus grand !";
			}else if(nombre < nombreSucret) {
				return " Votre nombre est plus petit !";
			}else {
				fin = true;
				try {
					System.out.println(this.getClientHost());
				} catch (ServerNotActiveException e) {
					e.printStackTrace();
				}
				return " Félicitation BRAVO !!";
			}
			
		}else {
			return "Jeu est terminer , le nobre secret est :" + nombreSucret;
		}
	}

}
