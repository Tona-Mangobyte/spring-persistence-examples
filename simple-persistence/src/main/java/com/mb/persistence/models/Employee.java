package com.mb.persistence.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_skill",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_description_id")
    )
    private Set<SkillDescription> skillDescriptions = new HashSet<>();

    public void addSkillDescription(SkillDescription skillDescription) {
        this.skillDescriptions.add(skillDescription);
        skillDescription.getEmployees().add(this);
    }

    public void removeSkillDescription(SkillDescription skillDescription) {
        this.skillDescriptions.remove(skillDescription);
        skillDescription.getEmployees().remove(this);
    }

    public void removeSkillDescriptions() {
        Iterator<SkillDescription> iterator = this.skillDescriptions.iterator();
        while (iterator.hasNext()) {
            SkillDescription skillDescription = iterator.next();
            skillDescription.getEmployees().remove(this);
            iterator.remove();
        }
    }

    public Long getId() {
        return id;
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

    public Set<SkillDescription> getSkillDescriptions() {
        return skillDescriptions;
    }

    public void setSkillDescriptions(Set<SkillDescription> skillDescriptions) {
        this.skillDescriptions = skillDescriptions;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return id != null && id.equals(((Employee) obj).id);
    }

    @Override
    public int hashCode() {
        return 20212;
    }
}
