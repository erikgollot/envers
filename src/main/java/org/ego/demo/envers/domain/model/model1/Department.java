package org.ego.demo.envers.domain.model.model1;


import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise enterprise;

    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
