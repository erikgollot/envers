package org.ego.demo.envers.application.model;

public interface Model1Manager {
    void createData();
    void load(String name);

    void change(String name);
}
