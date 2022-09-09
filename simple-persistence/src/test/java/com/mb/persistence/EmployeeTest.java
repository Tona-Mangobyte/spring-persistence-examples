package com.mb.persistence;

import com.mb.persistence.models.Employee;
import com.mb.persistence.models.SkillDescription;
import com.mb.persistence.repositories.EmployeeRepository;
import com.mb.persistence.repositories.SkillDescriptionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class EmployeeTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SkillDescriptionRepository skillDescriptionRepository;


    @Test
    void insertEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Tona");
        employee.setLastName("Chheun");
        employee.setEmail("tona@mb.com");

        Set<SkillDescription> skillDescriptions = new HashSet<>();
        SkillDescription skillDescription = new SkillDescription();
        skillDescription.setDescription("REST API");
        skillDescriptions.add(skillDescription);

        skillDescription = new SkillDescription();
        skillDescription.setDescription("Data modelling");
        skillDescriptions.add(skillDescription);

        employee.setSkillDescriptions(skillDescriptions);

        employee = employeeRepository.save(employee);
        Assertions.assertEquals("Tona", employee.getFirstName());
    }
}
