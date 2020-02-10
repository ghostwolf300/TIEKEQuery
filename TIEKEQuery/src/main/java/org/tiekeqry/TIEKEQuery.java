package org.tiekeqry;

import org.tiekeqry.net.TIEKEService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.tiekeqry.dto.EAddressDTO;
import org.tiekeqry.dto.OrganizationEAddressDTO;
import org.tiekeqry.dto.ResultDTO;
import org.tiekeqry.io.Excel;
import org.tiekeqry.net.TIEKEConnector;

public class TIEKEQuery {
	
	public TIEKEQuery() {
		
	}
	
	public static void main(String[] args) {
		TIEKEQuery tieke=new TIEKEQuery();
		tieke.test();
	}
	
	public void test() {
		//List<String> ytjIds=new ArrayList<String>();
		//ytjIds.add("0201256-6");
		//ytjIds.add("2247743-2");
		
		Excel excl=new Excel();
		excl.openFile(new File("Test File.xlsx"));
		List<String> ytjIds=excl.readYTJIds();
		
		TIEKEConnector connector=new TIEKEService();
		List<ResultDTO> results=connector.fetchTIEKEData(ytjIds);
		
		for(ResultDTO result : results) {
			System.out.println(result.getOrganization().getName());
			for(OrganizationEAddressDTO oeaddr : result.geteAddresses()) {
				System.out.println(oeaddr.getIdentifier());
			}
		}
		
		excl.writeResults(results, new File("Test File - results.xlsx"));
		
	}

}
