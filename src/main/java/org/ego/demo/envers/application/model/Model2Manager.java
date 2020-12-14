package org.ego.demo.envers.application.model;

public interface Model2Manager {
    void createData();
    void load(String name);

    void change(String name);
}
