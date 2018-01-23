package xwq.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xwq.test.mapper.TPeopleMapper;
import xwq.test.pojo.TPeople;

//注入ioc
@Service("tpeopserviceimp")
public class TPeopServiceImp implements TPeopServiceImpDao  {
	//服务层创建需要操作的mapper接口类型的属性
	private TPeopleMapper tpeoplemapper;

	

	/* (non-Javadoc)
	 * @see xwq.test.service.TPeopServiceImpDao#getTpeoplemapper()
	 */

	public TPeopleMapper getTpeoplemapper() {
		return tpeoplemapper;
	}

	/* (non-Javadoc)
	 * @see xwq.test.service.TPeopServiceImpDao#setTpeoplemapper(xwq.test.mapper.TPeopleMapper)
	 */ //将mapper层实现的类对象赋给服务层 
	   
	//TPeopleMapper由测试类测试时产生的实现类名称决定/
	@Resource(name="TPeopleMapper")
	public void setTpeoplemapper(TPeopleMapper tpeoplemapper) {
		this.tpeoplemapper = tpeoplemapper;
	}

	/* (non-Javadoc)
	 * @see xwq.test.service.TPeopServiceImpDao#insertpeople(xwq.test.mapper.TPeopleMapper)
	 */
	@Override
	public void insertpeople(TPeople tpeople) {
		//调用mapper层的方法
		tpeoplemapper.insert(tpeople);
	}
	

}
