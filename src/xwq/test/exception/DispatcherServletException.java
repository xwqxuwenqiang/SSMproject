package xwq.test.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//自定义了异常处理器
@Component("dispatcherServletException")
public class DispatcherServletException implements HandlerExceptionResolver {
	Logger logger = Logger.getLogger(DispatcherServletException.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception exception) {
		String message = exception.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error", message);
		modelAndView.setViewName("/error");
		return modelAndView;
	}

}
