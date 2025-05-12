package Worksheet.A9ChainedExceptionDemo.Service;

import Worksheet.A9ChainedExceptionDemo.Exception.ServiceLayerException;
import Worksheet.A9ChainedExceptionDemo.Repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private final UserRepository repository = new UserRepository();

    public String getUser(int id) throws ServiceLayerException {
        try {
            return repository.fetchUserById(id);
        } catch (SQLException e) {
            throw new ServiceLayerException("Service failed while fetching user", e);
        }
    }
}
