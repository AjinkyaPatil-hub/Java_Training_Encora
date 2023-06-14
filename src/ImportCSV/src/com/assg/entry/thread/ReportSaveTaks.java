package com.assg.entry.thread;

import java.util.List;

import com.assg.model.AnnualReport;
import com.assg.service.AnnualReportService;

public class ReportSaveTaks implements Runnable {

	private AnnualReportService annualService;
	private List<AnnualReport> anuualReportList;

	public ReportSaveTaks(AnnualReportService annualService, List<AnnualReport> anuualReportList) {
		this.annualService = annualService;
		this.anuualReportList = anuualReportList;
	}

	@Override
	public void run() {
		annualService.saveDataInBatch(anuualReportList);
	}

}
