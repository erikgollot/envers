package org.ego.demo.envers.application.model;

public interface Model3Manager {
    void createData();
    void load(String name);

    void showEnterpriseVersion(Long identifier,Integer version);

    void change(String name);

    void changeDep(String name);
}
