package calismaio.northwind.business.abstracts;

import calismaio.northwind.core.utilities.entities.User;
import calismaio.northwind.core.utilities.results.DataResult;
import calismaio.northwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
