package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private EntityManager entityManager;
   @Autowired
   private UserDao userDao;
   @Autowired
   private SessionFactory sessionFactory;
   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   public List<User> getListUserFromCar(String model,int series){
      return sessionFactory.createEntityManager().createNamedQuery("User.SearchByCar").setParameter("x",model).setParameter("y",series).getResultList();
   }

}
