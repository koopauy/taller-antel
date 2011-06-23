package com;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import ws.Ws;
import ws.WsServiceLocator;

import negocio.Ticket;

public class ConexionIMM {

	public Ticket ventaTicket (Ticket t,String usuarioAgencia,String passwordAgencia){
/*
// 		Ws (usu,pas,mat,ini,dur)
*/
		String res;
		WsServiceLocator wssl = new WsServiceLocator();
		try {  
			Ws ws = wssl.getWsPort();
			res = ws.venta(usuarioAgencia, passwordAgencia, t.getMatricula(), t.getInicioEstacionamiento(), t.getDuracionEstacionamiento());
			System.out.println(res);
			if (res.equals("")){
				t.setIdIMM(0);
				t.setMatricula("WS Timeout");
			} else {
				t = t.String2Ticket(res);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public Ticket anulaTicket(Ticket t, String usuario, String password){
		/*
		 * Invoco al  WS y retorno el Ticket
		 * 
		 * 
		 * */
		return t;
	}
	
}
