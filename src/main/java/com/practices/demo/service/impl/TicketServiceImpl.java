package com.practices.demo.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.practices.demo.dto.DetailsReserveCarDto;
import com.practices.demo.dto.DetailsReserveHotelDto;
import com.practices.demo.service.HotelReserveService;
import com.practices.demo.service.ReserveCarService;
import com.practices.demo.service.TicketService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * The Class TicketServiceImpl.
 */
@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	/** The ticket template path. */
	private final String ticket_template_path = "/jasper/Ticket.jrxml";

	/** The ticket reserve template path. */
	private final String ticketReserve_template_path = "/jasper/TicketReserve.jrxml";

	/** The Constant REPORTS_RELATIVE_PATH. */
	private static final String REPORTS_RELATIVE_PATH = "/jasper/";

	/** The Constant MODULE_NAME. */
	private static final String MODULE_NAME = "classes";

	/** The hotel reserve service. */
	@Autowired
	private HotelReserveService hotelReserveService;

	/** The car reserve service. */
	@Autowired
	private ReserveCarService carReserveService;

	/**
	 * Generate PDF report.
	 *
	 * @param inputFileName the input file name
	 * @param params        the params
	 * @param dataSource    the data source
	 * @return the byte[]
	 */
	@Override
	public byte[] generatePDFReport(String inputFileName, Map<String, Object> params, JRDataSource dataSource) {

		byte[] bytes = null;

		try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {

			JasperReport jasperReport = loadTemplate(ticket_template_path);

			Locale loc = LocaleContextHolder.getLocale();

			if (loc.getLanguage().equals(new Locale("es").getLanguage())) {

				ResourceBundle bundleES = ResourceBundle.getBundle("messages_es_ES", new Locale("es", "SP"));

				params.put("REPORT_RESOURCE_BUNDLE", bundleES);
			} else {

				ResourceBundle bundleGB = ResourceBundle.getBundle("messages_en_GB", new Locale("en", "GB"));

				params.put("REPORT_RESOURCE_BUNDLE", bundleGB);
			}

			params.put("SUBREPORT_DIR", getReportsFolder());

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

			bytes = JasperExportManager.exportReportToPdf(jasperPrint);

		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
		return bytes;

	}

	/**
	 * Load template.
	 *
	 * @param nameTemplate the name template
	 * @return the jasper report
	 * @throws JRException the JR exception
	 */
	private JasperReport loadTemplate(String nameTemplate) throws JRException {

		final InputStream reportInputStream = getClass().getResourceAsStream(nameTemplate);
		final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

		return JasperCompileManager.compileReport(jasperDesign);
	}

	/**
	 * Generate PDF report.
	 *
	 * @param inputFileName the input file name
	 * @param params        the params
	 * @return the byte[]
	 */
	@Override
	public byte[] generatePDFReport(String inputFileName, Map<String, Object> params) {
		return generatePDFReport(inputFileName, params, new JREmptyDataSource());
	}

	/**
	 * Gets the reports folder.
	 *
	 * @return the reports folder
	 */
	private String getReportsFolder() {
		final String path = this.getClass().getResource(this.getClass().getSimpleName() + ".class").getPath();
		final int index = path.indexOf(MODULE_NAME) + MODULE_NAME.length();

		String result = path.substring(0, index);

		result += REPORTS_RELATIVE_PATH;

		return result;
	}

	/**
	 * Generate PDF reserve report.
	 *
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public byte[] generatePDFReserveReport() throws IOException {

		List<DetailsReserveHotelDto> reserveHotelList = hotelReserveService.findHotelReserveTomorrow();
		List<DetailsReserveCarDto> reserveCarList = carReserveService.findCarReserveTomorrow();

		byte[] bytes = null;
//		Date date = new Date();

		Map<String, Object> params = new HashMap<>();

		JRDataSource dataSource = new JREmptyDataSource();

		JRBeanCollectionDataSource carReserveCollectionList = new JRBeanCollectionDataSource(reserveCarList);
		JRBeanCollectionDataSource hotelReserveCollectionList = new JRBeanCollectionDataSource(reserveHotelList);

		// params.put("date", ;

		params.put("ticketReserveCar", carReserveCollectionList);
		params.put("ticketReserveHotel", hotelReserveCollectionList);

		try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {

			JasperReport jasperReport = loadTemplate(ticketReserve_template_path);

			Locale loc = LocaleContextHolder.getLocale();

			if (loc.getLanguage().equals(new Locale("es").getLanguage())) {

				ResourceBundle bundleES = ResourceBundle.getBundle("messages_es_ES", new Locale("es", "SP"));

				params.put("REPORT_RESOURCE_BUNDLE", bundleES);
			} else {

				ResourceBundle bundleGB = ResourceBundle.getBundle("messages_en_GB", new Locale("en", "GB"));

				params.put("REPORT_RESOURCE_BUNDLE", bundleGB);
			}

			params.put("SUBREPORT_DIR", getReportsFolder());

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

			bytes = JasperExportManager.exportReportToPdf(jasperPrint);

		} catch (JRException | IOException e) {
			e.printStackTrace();
		}

		return bytes;

	}

}
