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
 * @Description: TODO(������һ�仰��������������) 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2018��1��19�� ����2:27:20 
 * 
 */
/**
 * @author Administrator
 *
 */
public class TPeopleMapperTest {

	@Test //����jdbc�ļ�������Դ�Ƿ����óɹ�
	public void testDataSource() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		DataSource bean = classPathXmlApplicationContext.getBean("dataSource", DataSource.class);
		System.out.println("����JDBC����Դ"+bean);
	}
	@Test//�����Զ�����mapper��ӿ�ʵ����
	public void testMapper() {
		ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		TPeopleMapper bean = classPathXmlApplicationContext.getBean("TPeopleMapper", TPeopleMapper.class);
		System.out.println(bean);
	}
	



}
