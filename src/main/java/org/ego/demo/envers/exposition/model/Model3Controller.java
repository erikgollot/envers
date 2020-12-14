package org.ego.demo.envers.exposition.model;

import org.ego.demo.envers.application.model.Model2Manager;
import org.ego.demo.envers.application.model.Model3Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Model3Controller {
    private Model3Manager manager;

    @Autowired
    public Model3Controller(Model3Manager manager) {
        this.manager = manager;
    }

    @PostMapping("/api/model3/createData")
    public void createData() {
        manager.createData();
    }

    @GetMapping("/api/model3/load/{name}")
    public void load(@PathVariable String name) {
        manager.load(name);
    }

    @GetMapping("/api/model3/show/{identifier}/{revision}")
    public void load(@PathVariable Long identifier,@PathVariable Integer revision) {
        manager.showEnterpriseVersion(identifier,revision);
    }

    @PostMapping("/api/model3/change/{name}")
    public void change(@PathVariable String name) {
        manager.change(name);
    }

    @PostMapping("/api/model3/changeDep/{name}")
    public void changeDep(@PathVariable String name) {
        manager.changeDep(name);
    }
}
