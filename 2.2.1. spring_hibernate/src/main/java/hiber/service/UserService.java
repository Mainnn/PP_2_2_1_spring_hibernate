package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService<T> {
    void add(User user);
    List<User> listUsers();
    List<User> getListUserFromCar(String model,int series);
}
