package org.tiekeqry.net;

import java.util.List;

import org.tiekeqry.dto.ResultDTO;

public interface TIEKEConnector {
	
	public List<ResultDTO> fetchTIEKEData(List<String> ytjIds);
}
