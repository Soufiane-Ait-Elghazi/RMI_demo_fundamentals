package jeu;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServeurRMI {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			JeuImp od = new JeuImp();
			System.out.println(od.toString());
			//Naming.rebind("rmi://localhost:1099/JH", od);
			Context  ctx  = new InitialContext();
			ctx.rebind("JH", od);
		} catch (RemoteException | NamingException e) {
			e.printStackTrace();
		}
	}

}
