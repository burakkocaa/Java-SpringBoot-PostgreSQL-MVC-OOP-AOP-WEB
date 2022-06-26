package calismaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calismaio.northwind.business.abstracts.UserService;
import calismaio.northwind.core.utilities.entities.User;
import calismaio.northwind.core.utilities.results.DataResult;
import calismaio.northwind.core.utilities.results.Result;
import calismaio.northwind.core.utilities.results.SuccessDataResult;
import calismaio.northwind.core.utilities.results.SuccessResult;
import calismaio.northwind.dataAccess.UserDao;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	 public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"kullanıcı bulundu");
	}

}
