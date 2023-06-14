package com.assg.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.assg.model.AnnualReport;

public class ReaderUtil {

	public List<AnnualReport> readDataFromFile(String filePath) {
		List<AnnualReport> annualReportList = new ArrayList<>();
		try {
			Path pathToFile = Paths.get(filePath);
			BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
//				System.out.println(Arrays.toString(attributes));
				AnnualReport report = createAnnualReport(attributes);
				annualReportList.add(report);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return annualReportList;

	}

	private AnnualReport createAnnualReport(String[] metadata) {

		int year = Integer.parseInt(metadata[0]);

		return new AnnualReport(year, metadata[1], metadata[2], metadata[3], metadata[4], metadata[5], metadata[6],
				metadata[7], metadata[8], metadata[9]);
	}
}
