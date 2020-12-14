package org.ego.demo.envers.domain.model3.model2;


import org.hibernate.envers.AuditMappedBy;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Audited
public class Enterprise3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(columnDefinition = "VARCHAR(32)")
    private String siret;

    @OneToMany(mappedBy = "enterprise",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @AuditMappedBy(mappedBy = "enterprise")
    private List<Department3> departments;

    public Enterprise3() {}

    public Enterprise3(String name, String siret) {
        this.name = name;
        this.siret = siret;
    }

    public void addDepartment(Department3 department) {
        if (getDepartments()==null) {
            this.departments = new ArrayList<>();
        }
        getDepartments().add(department);
        department.setEnterprise(this);
    }

    public List<Department3> getDepartments() {
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

    @Override
    public String toString() {
        final StringBuffer s = new StringBuffer();
        s.append("id=").append(getId())
                .append(" , name=").append(getName())
                .append(" , siret=").append(getSiret())
                .append("\n");
        if (getDepartments()!=null) {
            s.append("Départements : \n");
            getDepartments().forEach(d->{
                s.append("  id=").append(d.getId())
                        .append(" , name=").append(d.getName());
            });
        }
        return  s.toString();
    }
}
