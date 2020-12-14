package org.ego.demo.envers.application.model;

import org.ego.demo.envers.domain.model.model1.Department;
import org.ego.demo.envers.domain.model.model1.Enterprise;
import org.ego.demo.envers.domain.repository.model.EntrepriseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class Model1ManagerImpl implements Model1Manager {
    private EntrepriseDAO entrepriseDAO;

    @Autowired
    public Model1ManagerImpl(EntrepriseDAO entrepriseDAO) {
        this.entrepriseDAO = entrepriseDAO;
    }

    @Override
    public void createData() {
        Enterprise ent1 = new Enterprise("BNPPARIBAS","123456");
        Department baq = new Department("BAQ");
        Department ccr = new Department("CCR");

        ent1.addDepartment(baq);
        ent1.addDepartment(ccr);

        entrepriseDAO.save(ent1);
    }

    @Override
    public void load(String name) {
        Optional<Enterprise> enterpriseOpt = entrepriseDAO.findByName(name);
        if (enterpriseOpt.isPresent()) {
            Enterprise enterprise = enterpriseOpt.get();
            enterprise.getDepartments().size();

        }
    }

    @Override
    public void change(String name) {
        Optional<Enterprise> enterpriseOpt = entrepriseDAO.findByName(name);
        if (enterpriseOpt.isPresent()) {
            Enterprise enterprise = enterpriseOpt.get();
            enterprise.setSiret(enterprise.getSiret()+"-new");
            entrepriseDAO.save(enterprise);
        }
    }
}
