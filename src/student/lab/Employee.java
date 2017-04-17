
package student.lab;

/**
 * Simulates a real employee in a business.
 * 
 * @author Veki Vulic, vekivulic@my.wctc.edu 
 * @version 1.00
 * @since 1.8
 */
public class Employee {
    private String lastName;
    
   /**default*/
    public Employee(){
        
    }
    /**
     * A convenience constructor that allows you to 
     * initialize employee with a last name;
     * @param lastName -the employee's last name
     */
    public Employee(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Gets the last name of employee.
     * @return the last name of the employee or empty string or null 
     */
    

    public String getLastName() {
        return lastName;
    }

    /**
     * Modifies or sets the last name of the employee 
     * 
     * @param lastName mandatory last name of employee 
     * @throws IllegalArgumentException if last name is null or empty
     */
    
    public void setLastName(String lastName)throws IllegalArgumentException {
        if(lastName==null || lastName.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }
    
    private void method3(){
        
    }
    
}
