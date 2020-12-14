package org.ego.demo.envers.exposition.model;

import org.ego.demo.envers.application.model.Model1Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Model1Controller {
    private Model1Manager manager;

    @Autowired
    public Model1Controller(Model1Manager manager) {
        this.manager = manager;
    }

    @PostMapping("/api/model1/createData")
    public void createData() {
        manager.createData();
    }

    @GetMapping("/api/model1/load/{name}")
    public void load(@PathVariable String name) {
        manager.load(name);
    }

    @PostMapping("/api/model1/change/{name}")
    public void change(@PathVariable String name) {
        manager.change(name);
    }
}
