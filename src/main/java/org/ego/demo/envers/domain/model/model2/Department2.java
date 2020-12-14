package org.ego.demo.envers.domain.model.model2;


import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class Department2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise2 enterprise;

    public Department2() {}

    public Department2(String name) {
        this.name = name;
    }

    public Enterprise2 getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise2 enterprise) {
        this.enterprise = enterprise;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
