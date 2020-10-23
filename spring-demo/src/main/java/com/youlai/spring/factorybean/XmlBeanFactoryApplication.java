<<<<<<< HEAD:spring-demo/src/main/java/com/youlai/spring/factorybean/XmlBeanFactoryApplication.java
package com.youlai.spring.factorybean;
=======
package com.youlai.spring.ch05.factorybean;
>>>>>>> 690f2356eb1b94bf424194b8287d793bdb818aa6:spring-demo/src/main/java/com/youlai/spring/ch05/factorybean/XmlBeanFactoryApplication.java

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class XmlBeanFactoryApplication {

	public static void main(String[] args) {

		ClassPathResource resource = new ClassPathResource("spring-config.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);

		Object car1 = beanFactory.getBean("car");
		Object car2 = beanFactory.getBean("car");
		System.out.println(car1 == car2);

		Object bean = beanFactory.getBean("&car");
		System.out.println(bean);

	}

}
