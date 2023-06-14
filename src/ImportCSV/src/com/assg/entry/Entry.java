package com.assg.entry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.assg.entry.thread.ReportSaveTaks;
import com.assg.model.AnnualReport;
import com.assg.service.AnnualReportService;
import com.assg.serviceImpl.AnnualReportServiceImpl;
import com.assg.util.ReaderUtil;

public class Entry {

	public static void main(String[] args) {
		// read data from csv file
		long st = System.currentTimeMillis();

		List<AnnualReport> anuualReportList = new ReaderUtil()
				.readDataFromFile("C:/Users/ajinkyap/Downloads/report.csv");
		System.out.println(anuualReportList);

		AnnualReportService annualService = new AnnualReportServiceImpl();
		/*
		 * for (AnnualReport dto : anuualReportList) { // validation can be applied here
		 * for each row i.e dto if validation fails we can return the error // message
		 * and abort saving it into db. annualService.save(dto); }
		 */
		// annualService.saveDataInBatch(anuualReportList);

		// divide the list into 1000 and assgin to each thread

		List<ReportSaveTaks> taskList = new ArrayList<>();
		int batchSize = 1000;
		List<AnnualReport> batchList = null;
		int recordCount = 0;
		int mark = 0;
		int cnt = 0;
		int startPoint = 0;
		while (recordCount <= anuualReportList.size()) {
			cnt++;
			batchList = anuualReportList.subList(startPoint, mark);
//			System.out.println("records saved.. " + batchList.size());
			startPoint = mark;
			mark = mark + batchSize;
			ReportSaveTaks task = new ReportSaveTaks(annualService, batchList);
			taskList.add(task);
			recordCount += batchSize;
		}

		System.out.println("total records iteration " + cnt);
		batchList = anuualReportList.subList((cnt - 1) * batchSize, anuualReportList.size() - 1);
		ReportSaveTaks task = new ReportSaveTaks(annualService, batchList);
		taskList.add(task);

		ExecutorService services = Executors.newFixedThreadPool(5);
		for (ReportSaveTaks reportSaveTask : taskList) {
			services.submit(reportSaveTask);
		}
		
		System.out.println("Data Saved..");
		System.out.println("End time " + (System.currentTimeMillis() - st) + "ms");
	}
}
