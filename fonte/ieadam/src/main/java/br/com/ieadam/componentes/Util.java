package br.com.ieadam.componentes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class Util {

	public static int definirTamanhoColuna(int tamanho) {

		if (tamanho < 5) {
			return tamanho;
		} else {
			double col = Math.sqrt(tamanho);
			int colunas = (int) col;
			if (colunas < col)
				colunas++;
			return colunas;
		}

	}
	
	public static byte[] getBytes(InputStream is) throws IOException {
		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}

	public static StreamedContent converterBytesToStreamedContent(byte[] bytes) {
		if (bytes != null) {
			InputStream is = new ByteArrayInputStream(bytes);
			System.out.println("size file : " + bytes.length);
			StreamedContent image = new DefaultStreamedContent(is);
			System.out.println("dans le convertisseur : "
					+ image.getContentType());
			return image;
		} else
			return null;
	}

}
