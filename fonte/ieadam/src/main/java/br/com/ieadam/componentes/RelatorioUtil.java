package br.com.ieadam.componentes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ManagedBean
@SessionScoped
public class RelatorioUtil {

	@ManagedProperty(value = "#{datasource}")
	private DriverManagerDataSource dataSource;

	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public byte[] gerarRelatorioWebBytes(Map parametros,
			String arquivo) {
		
		JasperPrint print;
		byte[] relatorio = null;
		try {
			print = JasperFillManager.fillReport(new FileInputStream(new File(arquivo)), 
						parametros, this.dataSource.getConnection());
			
			relatorio = JasperExportManager.exportReportToPdf(print);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return relatorio;
			
	}

	public FileInputStream gerarRelatorioWeb(Map parametros,
			String arquivo) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			JasperPrint print = JasperFillManager.fillReport(new FileInputStream(new File(arquivo)), 
					parametros, this.dataSource.getConnection());
			
			File arquivoGerado = File.createTempFile("relatorio.", ".pdf");

			fos = new FileOutputStream(arquivoGerado);
			
			JasperExportManager.exportReportToPdfStream(print, fos);
			
			fis = new FileInputStream(arquivoGerado);
			
			if (arquivoGerado.length() < 1024) {
				return null;
			}
			
			System.out.println("\n\n INFO [RelatorioUtil.java]: Arquivo gerado como o nome = "+arquivoGerado.getName()+" \n\n");
			
			// Verificar
//			arquivoGerado.deleteOnExit();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.flush();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return fis;
	}
}
