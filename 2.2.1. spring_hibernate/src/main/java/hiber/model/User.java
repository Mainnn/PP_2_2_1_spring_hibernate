package hiber.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "User.SearchByCar"
        ,query = "from User where car.model =:x and car.series =:y")
})
@Entity
@Table(name = "users")
public class User  {

   @Id
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(fetch = FetchType.LAZY)
   @MapsId
   @JoinColumn(name = "id")
   private Car car;

   public Car getCar() {
      return car;
   }

   @Override
   public String toString() {
      return "\nUser{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", car=" + car +
              '}';
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = null;
   }

   public User( String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
      this.id = id;
   }

   public int getId() {
      return Math.toIntExact(id);
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
