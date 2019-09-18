package org.tiekeqry;

import org.tiekeqry.net.TIEKEService;
import org.tiekeqry.net.TIEKEConnector;

public class TIEKEQuery {
	
	public TIEKEQuery() {
		
	}
	
	public static void main(String[] args) {
		TIEKEQuery tieke=new TIEKEQuery();
		tieke.test();
	}
	
	public void test() {
		TIEKEConnector connector=new TIEKEService();
		connector.fetchTIEKEData(null);
	}

}
