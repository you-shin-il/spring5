package com.ysi.shop;

import com.ysi.shop.vo.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Date;


/**
 * @Author 유신일
 * @since 2019-03-23
 */
@Component
public class Cashier {
	@Autowired
	private MessageSource messageSource;

	@Value("checkout")
	private String fileName;
	@Value("src/main/resources/cashier")
	private String path;
	private BufferedWriter writer;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@PostConstruct
	public void openFile() throws IOException {
		System.out.println("openFile()");
		File targetDir = new File(path);
		if(!targetDir.exists()) {
			targetDir.mkdir();
		}

		File checkoutFile = new File(path, fileName + ".txt");
		if(!checkoutFile.exists()) {
			checkoutFile.createNewFile();
		}

		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(checkoutFile, true)));
	}

	public void checkout(ShoppingCart cart) throws IOException {
		writer.write(new Date() + "t" + cart.getItems() + "\r\n");
		writer.flush();
	}

	@PreDestroy
	public void closeFile() throws IOException {
		System.out.println("closeFile()");
		writer.close();
	}
}