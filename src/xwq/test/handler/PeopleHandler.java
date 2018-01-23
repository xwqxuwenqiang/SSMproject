package xwq.test.handler;

import java.nio.charset.CharsetDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.ForwardRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xwq.test.exception.HandlerException;
import xwq.test.exception.ServiceException;
import xwq.test.pojo.TPeople;
import xwq.test.service.TPeopServiceImpDao;

//ע���խ��·��
@Controller("peopleHandler")
@RequestMapping("/user")
public class PeopleHandler {
	private Logger logger = Logger.getLogger(PeopleHandler.class);
	// ����service�Ľӿڵ�����
	private TPeopServiceImpDao tpeopserviceimpdao;

	// ==========================================================================================================
	// ��ͨjsp����javabean����ʱ��ǰ̨�������nameֵҪ��javabean����ֵһ��
	@RequestMapping(value = "/registerUser.do", method = RequestMethod.POST)
	
	
	public String regiester(TPeople tpeople, HttpServletRequest requst,
			HttpServletResponse response)  throws HandlerException, ServiceException{
		logger.debug("UserHandler>regiester������ʼִ�У�");
		try {
			// ʹ��service��ķ�������javabean
			tpeopserviceimpdao.insertpeople(tpeople);
		} catch (Exception e) {
				throw new HandlerException("UserHandler>uploadFile01 ����",e);
		}
	
		logger.debug("UserHandler>regiester��������ִ�У�");
		// "redirect"�����ط�
		return "redirect:/success.jsp";
	}

	// ===========================================================================================================
	// ǰ̨����key-value�ַ��� ����json�ַ���
	// @ResponseBody�ѷ���ֵת����json��ʽ�ַ���
	// ���ﴫ��Ĳ���Ҫ�ͱ��е�nameֵ��ȫһ��
	@RequestMapping(value = "/json01.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	TPeople insert(Integer id, String name, Integer age) {
		logger.debug("���=" + id + "||����=" + name+ "||����="
				+ age);
		TPeople tpeople = new TPeople();
		tpeople.setId(id);
		tpeople.setNames(name);
		tpeople.setAge(age);
		// ���÷�������
		tpeopserviceimpdao.insertpeople(tpeople);
		// "redirect"�����ط�
		return tpeople;
	}

	// ==========================================================================================================
	// ǰ̨����json�ַ���������json�ַ���
	// @ResponseBody�ѷ���ֵת����json��ʽ�ַ���
	 // @RequestBody JavaBean javabean�������json�ַ���ע�뵽javabean��
	  // ��ǰ̨json��ֵ�Ե�keyֵ����javabean
	 
	@RequestMapping(value = "/json02.do", method = { RequestMethod.GET,RequestMethod.POST })
	public @ResponseBody
	TPeople insert02(@RequestBody TPeople tpeople) {
	
		logger.debug("content01=" + tpeople.getId() + "||content02="
				+ tpeople.getNames() + "||content02=" + tpeople.getAge());
		tpeopserviceimpdao.insertpeople(tpeople);
		// ����json�ַ���
		return tpeople;

	}

	// ===========================================================================================================

	/**
	 * @return the tpeopserviceimpdao
	 */
	public TPeopServiceImpDao getTpeopserviceimpdao() {
		return tpeopserviceimpdao;
	}

	/**
	 * @param tpeopserviceimpdao
	 *            the tpeopserviceimpdao to set
	 */
	// ��������ʵ��ע������ע������൱�ڸ�tpeopserviceimpdao��ֵ
	@Resource(name = "tpeopserviceimp")
	public void setTpeopserviceimpdao(TPeopServiceImpDao tpeopserviceimpdao) {
		this.tpeopserviceimpdao = tpeopserviceimpdao;
	}

}
