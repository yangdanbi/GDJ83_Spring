package com.winter.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	@Autowired
	private LocationDAO locationDAO;

	public List<LocationDTO> getList() throws Exception {
		System.out.println("locationService 실행");
		return locationDAO.getList();
		// return "department/list";

	}

	public LocationDTO getDetail(int num) throws Exception {
		return locationDAO.getDetail(num);

	}

	public int add(LocationDTO locationDTO) throws Exception {
		return locationDAO.add(locationDTO);
	}

}
