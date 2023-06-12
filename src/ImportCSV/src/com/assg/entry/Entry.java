package com.assg.entry;

import java.util.List;

import com.assg.model.AnnualReport;
import com.assg.service.AnnualReportService;
import com.assg.serviceImpl.AnnualReportServiceImpl;
import com.assg.util.ReaderUtil;

public class Entry {

	public static void main(String[] args) {
		// read data from csv file
		List<AnnualReport> anuualReportList = new ReaderUtil()
				.readDataFromFile("C:/Users/ajinkyap/Downloads/reportCopy.csv");
		System.out.println(anuualReportList);

		AnnualReportService annualService = new AnnualReportServiceImpl();
		for (AnnualReport dto : anuualReportList) {
			annualService.save(dto);
		}
		System.out.println("Data Saved..");
	}
}
