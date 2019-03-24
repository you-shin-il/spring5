import com.ysi.shop.Cashier;
import com.ysi.shop.config.ShopConfiguration;
import com.ysi.shop.vo.Product;
import com.ysi.shop.vo.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Date;
import java.util.Locale;
import java.util.Properties;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
public class Main {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
		Resource resource = new ClassPathResource("discounts.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);

		System.out.println("And don't forget our discounts!");
		System.out.println(props);

		Product aaa = context.getBean("aaa", Product.class);
		Product cdrw = context.getBean("cdrw", Product.class);
		Product dvdrw = context.getBean("dvdrw", Product.class);

		ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
		cart1.addItem(aaa);
		cart1.addItem(cdrw);
		System.out.println("Shopping cart 1 contains " + cart1.getItems());

		ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
		cart2.addItem(dvdrw);
		System.out.println("Shopping cart 2 contains " + cart2.getItems());

		String alert = context.getMessage("alert.checkout", null, Locale.US);
		String alert_inventory = context.getMessage("alert.inventory.checkout", new Object[] {"[DVD-RW 3.0]", new Date()},null, Locale.US);

		System.out.println("The I18N message for alert.checkout is " + alert);
		System.out.println("The I18N message for alert.alert_inventory is " + alert_inventory);

		Cashier cashier = context.getBean("cashier", Cashier.class);
		cashier.checkout(cart1);
	}
}