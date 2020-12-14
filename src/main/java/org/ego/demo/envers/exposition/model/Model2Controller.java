package org.ego.demo.envers.exposition.model;

import org.ego.demo.envers.application.model.Model1Manager;
import org.ego.demo.envers.application.model.Model2Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Model2Controller {
    private Model2Manager manager;

    @Autowired
    public Model2Controller(Model2Manager manager) {
        this.manager = manager;
    }

    @PostMapping("/api/model2/createData")
    public void createData() {
        manager.createData();
    }

    @GetMapping("/api/model2/load/{name}")
    public void load(@PathVariable String name) {
        manager.load(name);
    }

    @PostMapping("/api/model2/change/{name}")
    public void change(@PathVariable String name) {
        manager.change(name);
    }
}
