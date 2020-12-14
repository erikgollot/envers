package org.ego.demo.envers.application.model;

import org.ego.demo.envers.domain.model.model2.Department2;
import org.ego.demo.envers.domain.model.model2.Enterprise2;
import org.ego.demo.envers.domain.repository.model.Entreprise2DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class Model2ManagerImpl implements Model2Manager {
    private Entreprise2DAO entrepriseDAO;

    @Autowired
    public Model2ManagerImpl(Entreprise2DAO entrepriseDAO) {
        this.entrepriseDAO = entrepriseDAO;
    }

    @Override
    public void createData() {
        Enterprise2 ent1 = new Enterprise2("BNPPARIBAS","123456");
        Department2 baq = new Department2("BAQ");
        Department2 ccr = new Department2("CCR");

        ent1.addDepartment(baq);
        ent1.addDepartment(ccr);

        entrepriseDAO.save(ent1);
    }

    @Override
    public void load(String name) {
        Optional<Enterprise2> enterpriseOpt = entrepriseDAO.findByName(name);
        if (enterpriseOpt.isPresent()) {
            Enterprise2 enterprise = enterpriseOpt.get();
            enterprise.getDepartments().size();

        }
    }

    @Override
    public void change(String name) {
        Optional<Enterprise2> enterpriseOpt = entrepriseDAO.findByName(name);
        if (enterpriseOpt.isPresent()) {
            Enterprise2 enterprise = enterpriseOpt.get();
            enterprise.setSiret(enterprise.getSiret()+"-new");
            entrepriseDAO.save(enterprise);
        }
    }
}
