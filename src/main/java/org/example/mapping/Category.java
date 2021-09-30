package org.example.mapping;

public class Category {
    private String id;
    private String name;
    private Parent parent;
    private Options options;
    private Boolean leaf;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Parent getParent() {
        return parent;
    }

    public Options getOptions() {
        return options;
    }

    public Boolean getLeaf() {
        return leaf;
    }
}
