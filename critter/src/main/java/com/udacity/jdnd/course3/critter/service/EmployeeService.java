package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElseThrow(EmployeeNotFoundException::new);

    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void setAvailability(Set<DayOfWeek> days, Long employeeId){
        Employee employee = getEmployeeById(employeeId);
        employee.setDaysAvailable(days);
        employeeRepository.save(employee);
    }

    public List<Employee> getAvailableEmployees(Set<EmployeeSkill> skills, DayOfWeek day) {
        return employeeRepository.findAllBySkillsInAndDaysAvailable(skills, day, skills.size());
    }
}
