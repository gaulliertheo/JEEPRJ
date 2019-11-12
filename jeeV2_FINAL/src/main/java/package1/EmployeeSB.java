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

    public List getEmployees() {
        Query q = em.createQuery("SELECT e FROM Employees e");
        return q.getResultList();
    }

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

    public Employees login_check(String inputlogin, String inputpsw) {

        List<Employees> ListOfEmployees = new ArrayList<>();
        ListOfEmployees.addAll(getEmployees());

        for (Employees anEmployee : ListOfEmployees) {

            if (anEmployee.getLogin().equals(inputlogin) && anEmployee.getPassword().equals(inputpsw)) {
                return anEmployee;
            }
        }
        return null;
    }

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

    public void addAnEmployee(String name, String firstName, String telHome, String telMob, String telPro, String address, String postalCode, String city, String email) throws SQLException {
        
        Employees employee = new Employees(null, name, firstName, telHome, telMob, telPro, address, postalCode, city, email);
        
        em.persist(employee);
    }
    
    public void deleteAnEmployee(int inputId){
        
        List<Employees> ListOfEmployees = new ArrayList<>();
        ListOfEmployees.addAll(getEmployees());

        for (Employees anEmployee : ListOfEmployees) {
            if (anEmployee.getId() == inputId) {
                em.remove(anEmployee);
            }
        }  
    }
}