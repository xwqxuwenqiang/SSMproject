package xwq.test.mapper;

import org.apache.log4j.Logger;

import xwq.test.exception.DaoException;



public class UserDaoImp implements UserDao {
	Logger logger = Logger.getLogger(UserDaoImp.class);

	/* (non-Javadoc)
	 * @see edu.chinasoft.dao.UserDao#add()
	 */
	@Override
	public void add() throws DaoException {
		try {
              int i=6/3;
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException("UserDaoImp>add ³ö´í£¡", e);
		}
	}

}
