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

//注入加窄化路径
@Controller("peopleHandler")
@RequestMapping("/user")
public class PeopleHandler {
	private Logger logger = Logger.getLogger(PeopleHandler.class);
	// 创建service的接口的属性
	private TPeopServiceImpDao tpeopserviceimpdao;

	// ==========================================================================================================
	// 普通jsp传入javabean数据时，前台的输入框name值要和javabean属性值一样
	@RequestMapping(value = "/registerUser.do", method = RequestMethod.POST)
	
	
	public String regiester(TPeople tpeople, HttpServletRequest requst,
			HttpServletResponse response)  throws HandlerException, ServiceException{
		logger.debug("UserHandler>regiester方法开始执行！");
		try {
			// 使用service层的方法传入javabean
			tpeopserviceimpdao.insertpeople(tpeople);
		} catch (Exception e) {
				throw new HandlerException("UserHandler>uploadFile01 出错",e);
		}
	
		logger.debug("UserHandler>regiester方法结束执行！");
		// "redirect"请求重发
		return "redirect:/success.jsp";
	}

	// ===========================================================================================================
	// 前台传入key-value字符串 返回json字符串
	// @ResponseBody把返回值转换成json格式字符串
	// 这里传入的参数要和表单中的name值完全一样
	@RequestMapping(value = "/json01.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	TPeople insert(Integer id, String name, Integer age) {
		logger.debug("编号=" + id + "||姓名=" + name+ "||年龄="
				+ age);
		TPeople tpeople = new TPeople();
		tpeople.setId(id);
		tpeople.setNames(name);
		tpeople.setAge(age);
		// 调用方法插入
		tpeopserviceimpdao.insertpeople(tpeople);
		// "redirect"请求重发
		return tpeople;
	}

	// ==========================================================================================================
	// 前台传入json字符串，返回json字符串
	// @ResponseBody把返回值转换成json格式字符串
	 // @RequestBody JavaBean javabean将传入的json字符串注入到javabean中
	  // 以前台json键值对的key值创建javabean
	 
	@RequestMapping(value = "/json02.do", method = { RequestMethod.GET,RequestMethod.POST })
	public @ResponseBody
	TPeople insert02(@RequestBody TPeople tpeople) {
	
		logger.debug("content01=" + tpeople.getId() + "||content02="
				+ tpeople.getNames() + "||content02=" + tpeople.getAge());
		tpeopserviceimpdao.insertpeople(tpeople);
		// 返回json字符串
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
	// 将服务层的实现注入类名注入进来相当于给tpeopserviceimpdao赋值
	@Resource(name = "tpeopserviceimp")
	public void setTpeopserviceimpdao(TPeopServiceImpDao tpeopserviceimpdao) {
		this.tpeopserviceimpdao = tpeopserviceimpdao;
	}

}
