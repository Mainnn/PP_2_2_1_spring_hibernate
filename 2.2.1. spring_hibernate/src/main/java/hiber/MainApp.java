package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      /*carService.add(new Car("Ford",073));
      carService.add(new Car("Volga",5512));
      carService.add(new Car("Volga",551252323));
      carService.add(new Car("Volga",551645542));
      userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("Ford",0)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",carService.listCars().get(1)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",carService.listCars().get(4)));*/

      List<User> users = userService.listUsers();
      List<Car> cars = carService.listCars();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.printf(cars.get(user.getId() - 1).toString());
         System.out.println();
      }

      List<User> list = userService.getListUserFromCar("Ford",331234);
      list.stream().forEach(System.out::println);
      context.close();
   }
}
