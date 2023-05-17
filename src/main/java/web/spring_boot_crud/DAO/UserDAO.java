package web.spring_boot_crud.DAO;

import web.spring_boot_crud.model.User;
import java.util.List;

public interface UserDAO {

    public void saveUser(User user);

    public List<User> getAllUsers();

    public User getUser(int id);

    public void updateUser(User user);

    public void deleteUser(int id);

}
