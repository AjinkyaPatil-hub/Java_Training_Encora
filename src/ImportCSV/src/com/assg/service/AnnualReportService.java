package com.assg.service;

import java.util.List;

import com.assg.model.AnnualReport;

public interface AnnualReportService {

	public void save(AnnualReport annualReport);
	
	public void saveDataInBatch(List<AnnualReport> anuualReport);
}
