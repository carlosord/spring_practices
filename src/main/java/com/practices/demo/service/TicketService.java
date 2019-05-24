package com.practices.demo.service;

import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;

/**
 * The Interface TicketService.
 */
public interface TicketService {

	/**
	 * Generate PDF report.
	 *
	 * @param inputFileName the input file name
	 * @param params the params
	 * @param dataSource the data source
	 * @return the byte[]
	 */
	public byte[] generatePDFReport(String inputFileName, Map<String, Object> params, JRDataSource dataSource);

	/**
	 * Generate PDF report.
	 *
	 * @param inputFileName the input file name
	 * @param params the params
	 * @return the byte[]
	 */
	public byte[] generatePDFReport(String inputFileName, Map<String, Object> params);

}
