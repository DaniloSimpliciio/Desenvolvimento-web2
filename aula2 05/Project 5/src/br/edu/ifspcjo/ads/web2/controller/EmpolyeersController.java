package br.edu.ifspcjo.ads.web2.controller;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifspcjo.ads.web2.model.Employee;

public class EmpolyeersController {
    private List<Employee> employeesList; 


    public EmpolyeersController() {
        employeesList = new ArrayList<>();
    }



public boolean save(Employee employee) {
    if (employee != null) {
    employeesList.add(employee);
    return true;
        
    }
    return false;

    }

    public void list(){
        for(Employee employee: employeesList){
            System.out.println(employee);
            System.out.println("Renda: R$ "+ employee.calculateIncome());
        }
    }
}
