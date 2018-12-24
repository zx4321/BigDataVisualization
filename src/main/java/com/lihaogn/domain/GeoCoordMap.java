package com.lihaogn.domain;

import java.util.List;

public class GeoCoordMap {
    private String name;
    private List list;

    public GeoCoordMap(String name, List list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getList() {
        return list;
    }

    public void setList(List value) {
        this.list = value;
    }
}
