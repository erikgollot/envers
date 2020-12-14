package org.ego.demo.envers.application.model;

import org.ego.demo.envers.domain.model3.model2.Department3;
import org.ego.demo.envers.domain.model3.model2.Enterprise3;
import org.ego.demo.envers.domain.repository.model.Department3DAO;
import org.ego.demo.envers.domain.repository.model.Entreprise3DAO;
import org.ego.demo.envers.domain.repository.version.Entreprise3RevisionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Model3ManagerImpl implements Model3Manager {
    private Entreprise3DAO entrepriseDAO;
    private Entreprise3RevisionDAO entreprise3RevisionDAO;
    private Department3DAO department3DAO;

    @Autowired
    public Model3ManagerImpl(Entreprise3DAO entrepriseDAO,
                             Entreprise3RevisionDAO entreprise3RevisionDAO,
                             Department3DAO department3DAO) {
        this.entrepriseDAO = entrepriseDAO;
        this.entreprise3RevisionDAO = entreprise3RevisionDAO;
        this.department3DAO = department3DAO;
    }

    @Override
    public void createData() {
        Enterprise3 ent1 = new Enterprise3("BNPPARIBAS","123456");
        Department3 baq = new Department3("BAQ");
        Department3 ccr = new Department3("CCR");

        ent1.addDepartment(baq);
        ent1.addDepartment(ccr);

        entrepriseDAO.save(ent1);
    }

    @Override
    public void load(String name) {
        Optional<Enterprise3> enterpriseOpt = entrepriseDAO.findByName(name);
        if (enterpriseOpt.isPresent()) {
            Enterprise3 enterprise = enterpriseOpt.get();
            enterprise.getDepartments().size();

        }
    }

    @Override
    public void changeDep(String name) {
        List<Department3> all = department3DAO.findAll();
        Optional<Department3> departmentOptional = department3DAO.findByName(name);
        if (departmentOptional.isPresent()) {
            Department3 department = departmentOptional.get();
            department.setName(department.getName()+"-new");

            department3DAO.save(department);
        }
    }

    @Override
    public void showEnterpriseVersion(Long identifier,Integer version) {
        Optional<Revision<Integer,Enterprise3>> enterpriseOpt = entreprise3RevisionDAO.findRevision(identifier,version);
        if (enterpriseOpt.isPresent()) {
            Enterprise3 enterprise = enterpriseOpt.get().getEntity();
            System.out.println(enterprise.toString());
        }
    }

    @Override
    public void change(String name) {
        Optional<Enterprise3> enterpriseOpt = entrepriseDAO.findByName(name);
        if (enterpriseOpt.isPresent()) {
            Enterprise3 enterprise = enterpriseOpt.get();
            enterprise.setSiret(enterprise.getSiret()+"-new");
            entrepriseDAO.save(enterprise);
        }
    }
}
