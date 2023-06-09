package com.assg.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.assg.model.AnnualReport;
import com.assg.service.AnnualReportService;
import com.assg.util.DBHelper;

public class AnnualReportServiceImpl implements AnnualReportService {

	@Override
	public void save(AnnualReport annualReport) {
		Connection conn = null;
		try {
			conn = DBHelper.getInstance().getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO emp_db.csv_data\r\n"
					+ "(`year`, industry_aggregation, industry_code, industry_name, units, var_code, var_name, var_category, value, industry_code_ANZSIC06)\r\n"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

			ps.setInt(1, annualReport.getYear());
			ps.setString(2, annualReport.getIndustryAggregationNZSIOC());
			ps.setString(3, annualReport.getIndustryCodeNZSIOC());
			ps.setString(4, annualReport.getIndustryNameNZSIOC());
			ps.setString(5, annualReport.getUnits());
			ps.setString(6, annualReport.getVariableCode());
			ps.setString(7, annualReport.getVariableName());
			ps.setString(8, annualReport.getVariableCategory());
			ps.setString(9, annualReport.getValue());
			ps.setString(10, annualReport.getIndustryCodeANZSIC06());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					DBHelper.getInstance().closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void saveDataInBatch(List<AnnualReport> anuualReportList) {
		Connection conn = null;
		try {
			conn = DBHelper.getInstance().getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO emp_db.csv_data\r\n"
					+ "(`year`, industry_aggregation, industry_code, industry_name, units, var_code, var_name, var_category, value, industry_code_ANZSIC06)\r\n"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			//set auto commit to false
			conn.setAutoCommit(false);
			int cnt = 0;
			for (AnnualReport annualReport : anuualReportList) {
				cnt++;
				ps.setInt(1, annualReport.getYear());
				ps.setString(2, annualReport.getIndustryAggregationNZSIOC());
				ps.setString(3, annualReport.getIndustryCodeNZSIOC());
				ps.setString(4, annualReport.getIndustryNameNZSIOC());
				ps.setString(5, annualReport.getUnits());
				ps.setString(6, annualReport.getVariableCode());
				ps.setString(7, annualReport.getVariableName());
				ps.setString(8, annualReport.getVariableCategory());
				ps.setString(9, annualReport.getValue());
				ps.setString(10, annualReport.getIndustryCodeANZSIC06());
				ps.addBatch();
				//it will insert after 30-30 records are added in batch 
				if(cnt%30 == 0) {
					
					ps.executeBatch();
					conn.commit();
				}
			}
			//for remaning records
			ps.executeBatch();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					
					DBHelper.getInstance().closeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
