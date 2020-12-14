package org.ego.demo.envers.domain.model3.model2;


import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class Department3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise3 enterprise;

    public Department3() {}

    public Department3(String name) {
        this.name = name;
    }

    public Enterprise3 getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise3 enterprise) {
        this.enterprise = enterprise;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
