package xwq.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xwq.test.mapper.TPeopleMapper;
import xwq.test.pojo.TPeople;

//ע��ioc
@Service("tpeopserviceimp")
public class TPeopServiceImp implements TPeopServiceImpDao  {
	//����㴴����Ҫ������mapper�ӿ����͵�����
	private TPeopleMapper tpeoplemapper;

	

	/* (non-Javadoc)
	 * @see xwq.test.service.TPeopServiceImpDao#getTpeoplemapper()
	 */

	public TPeopleMapper getTpeoplemapper() {
		return tpeoplemapper;
	}

	/* (non-Javadoc)
	 * @see xwq.test.service.TPeopServiceImpDao#setTpeoplemapper(xwq.test.mapper.TPeopleMapper)
	 */ //��mapper��ʵ�ֵ�����󸳸������ 
	   
	//TPeopleMapper�ɲ��������ʱ������ʵ�������ƾ���/
	@Resource(name="TPeopleMapper")
	public void setTpeoplemapper(TPeopleMapper tpeoplemapper) {
		this.tpeoplemapper = tpeoplemapper;
	}

	/* (non-Javadoc)
	 * @see xwq.test.service.TPeopServiceImpDao#insertpeople(xwq.test.mapper.TPeopleMapper)
	 */
	@Override
	public void insertpeople(TPeople tpeople) {
		//����mapper��ķ���
		tpeoplemapper.insert(tpeople);
	}
	

}
