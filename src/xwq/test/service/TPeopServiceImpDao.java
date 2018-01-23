/**
 * 
 */
package xwq.test.service;

import xwq.test.mapper.TPeopleMapper;
import xwq.test.pojo.TPeople;

/** 
 * @ClassName: TPeopServiceImpDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2018年1月19日 下午4:55:54 
 * 
 */
/**
 * @author Administrator
 *
 */
public interface TPeopServiceImpDao {
	//创建mapper层的抽象方法传入javabean
     public abstract void insertpeople(TPeople tpeople);
}