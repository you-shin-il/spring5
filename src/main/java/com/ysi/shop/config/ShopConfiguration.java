package com.ysi.shop.config;

import com.ysi.shop.BannerLoder;
import com.ysi.shop.Cashier;
import com.ysi.shop.vo.Battery;
import com.ysi.shop.vo.Disc;
import com.ysi.shop.vo.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
@Configuration
@PropertySource("classpath:discounts.properties")
@ComponentScan("com.ysi.shop")
public class ShopConfiguration {

	@Value("${endofyear.discount:0}")
	private double specialEndofyearDiscountField;

	@Value("classpath:banner.txt")
	private Resource banner;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Product aaa() {
		Battery p1 = new Battery("AAA", 2.5);
		p1.setRechargeble(true);
		return p1;
	}

	@Bean
	public Product cdrw() {
		Disc p2 = new Disc("CD-RW", 1.5);
		p2.setCapacity(700);
		return p2;
	}

	@Bean
	public Product dvdrw() {
		Disc p2 = new Disc("DVD-RW", 3.0);
		p2.setCapacity(700);
		return p2;
	}

	@Bean
	public BannerLoder bannerLoader() {
		BannerLoder b1 = new BannerLoder();
		b1.setBanner(banner);
		return b1;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:message");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

//	@Bean(initMethod = "openFile", destroyMethod = "closeFile")
	public Cashier cashier() {
//		String path = "src/main/resources/cashier";
//		System.out.println("==path==");
//		System.out.println(path);
//		System.out.println("==path==");
		Cashier c1 = new Cashier();
//		c1.setFileName("checkout");
//		c1.setPath(path);
		return c1;
	}
}