package package1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EmployeeSB {

    @PersistenceContext
    EntityManager em;

    /*------------------------
    IN : null
    OUT : return a list of object employees
    ------------------------*/
    public List getEmployees() {
        Query q = em.createQuery("SELECT e FROM Employees e");
        return q.getResultList();
    }

    /*------------------------
    IN : the id of a specific employee
    OUT : return this specific employee
    ------------------------*/
    public Employees getAnEmployee(int inputId) throws SQLException {
        List<Employees> ListOfEmployees = new ArrayList<>();
        ListOfEmployees.addAll(getEmployees());

        for (Employees anEmployee : ListOfEmployees) {
            if (anEmployee.getId() == inputId) {
                return anEmployee;
            }
        }
        return null;
    }

    /*------------------------
    IN : the login and the password of the employee who want to connect
    OUT : return the employee who want to connect if he exist OR null if he does not
    ------------------------*/
    public Employees login_check(String inputlogin, String inputpsw) {

        List<Employees> ListOfEmployees = new ArrayList<>();
        ListOfEmployees.addAll(getEmployees());

        for (Employees anEmployee : ListOfEmployees) {

            System.out.println(anEmployee);
            if (anEmployee.getLogin() != null) {
                if (anEmployee.getLogin().equals(inputlogin) && anEmployee.getPassword().equals(inputpsw)) {
                    return anEmployee;
                }
            }
        }
        return null;
    }

    /*------------------------
    IN : all the parameters of the employee that will be modify
    OUT : return none
    ------------------------*/
    public void modifyAnEmployee(int inputId, String name, String firstName, String telHome, String telMob, String telPro, String address, String postalCode, String city, String email) throws SQLException {

        Employees employee = em.find(Employees.class, inputId);

        employee.setName(name);
        employee.setFirstname(firstName);
        employee.setTelhome(telHome);
        employee.setTelmob(telMob);
        employee.setTelpro(telPro);
        employee.setAddress(address);
        employee.setPostalcode(postalCode);
        employee.setCity(city);
        employee.setEmail(email);

        em.persist(employee);
    }

    /*------------------------
    IN : all the parameters of the employee that will be add
    OUT : return none
    ------------------------*/
    public void addAnEmployee(String name, String firstName, String telHome, String telMob, String telPro, String address, String postalCode, String city, String email) throws SQLException {

        Employees employee = new Employees(null, name, firstName, telHome, telMob, telPro, address, postalCode, city, email);

        em.persist(employee);
    }

    /*------------------------
    IN : all the parameters of the employee that will be delete
    OUT : return none
    ------------------------*/
    public void deleteAnEmployee(int inputId) {

        List<Employees> ListOfEmployees = new ArrayList<>();
        ListOfEmployees.addAll(getEmployees());

        for (Employees anEmployee : ListOfEmployees) {
            if (anEmployee.getId() == inputId) {
                em.remove(anEmployee);
            }
        }
    }
}
