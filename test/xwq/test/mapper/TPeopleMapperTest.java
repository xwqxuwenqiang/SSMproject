/**
 * 
 */
package xwq.test.mapper;



import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * @ClassName: TPeopleMapperTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2018年1月19日 下午2:27:20 
 * 
 */
/**
 * @author Administrator
 *
 */
public class TPeopleMapperTest {

	@Test //测试jdbc的记载数据源是否配置成功
	public void testDataSource() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		DataSource bean = classPathXmlApplicationContext.getBean("dataSource", DataSource.class);
		System.out.println("测试JDBC数据源"+bean);
	}
	@Test//测试自动生成mapper层接口实现类
	public void testMapper() {
		ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		TPeopleMapper bean = classPathXmlApplicationContext.getBean("TPeopleMapper", TPeopleMapper.class);
		System.out.println(bean);
	}
	



}
