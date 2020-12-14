package org.ego.demo.envers.domain.model.model1;


import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Audited
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(columnDefinition = "VARCHAR(32)")
    private String siret;

    @OneToMany(mappedBy = "enterprise",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Department> departments;

    public Enterprise() {}

    public Enterprise(String name, String siret) {
        this.name = name;
        this.siret = siret;
    }

    public void addDepartment(Department department) {
        if (getDepartments()==null) {
            this.departments = new ArrayList<>();
        }
        getDepartments().add(department);
        department.setEnterprise(this);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSiret() {
        return siret;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }
}
