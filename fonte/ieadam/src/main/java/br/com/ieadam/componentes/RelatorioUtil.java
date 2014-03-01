package br.com.ieadam.componentes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ManagedBean
@SessionScoped
public class RelatorioUtil {

	private DriverManagerDataSource dataSource;

	@PostConstruct
	public void init() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"classpath*:META-INF/spring/applicationContext.xml");

		this.dataSource = (DriverManagerDataSource) beanFactory
				.getBean("datasource");

	}

	public FileInputStream gerarRelatorioWeb(JRDataSource jrRS, Map parametros,
			String arquivo) {
		
		FileInputStream fis = null;
		
		try {
			JasperPrint print = JasperFillManager.fillReport(new FileInputStream(new File(arquivo)), 
					parametros, this.dataSource.getConnection());
			
			File arquivoGerado = File.createTempFile("relatorio.", ".pdf");

			JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(arquivoGerado));
			
			fis = new FileInputStream(arquivoGerado);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fis;
	}
}
