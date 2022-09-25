import java.rmi.RemoteException;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jeu.IJeuRemote;



public class ClientJeu {
	public static void main(String[] args) {
		try {
			Context  ctx  = new InitialContext();
			IJeuRemote stub = (IJeuRemote) ctx.lookup("JH");
			Scanner clavier = new Scanner(System.in);
			while(true) {
				System.out.println("'stop => -1' Deviner : ");
				int n = clavier.nextInt();
				if(n == -1) break;
				String rep = stub.jouer(n);
				System.out.println(rep);
			}
		} catch (NamingException | RemoteException e) {
			e.printStackTrace();
		}
	
		
	}
}
