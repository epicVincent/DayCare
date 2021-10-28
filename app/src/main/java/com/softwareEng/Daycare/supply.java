package com.softwareEng.Daycare;

public class supply {
    SupplyType supplyType;
    String supplyName;
    long id;
    Supplier supplier;
    double price;

    public supply(SupplyType supplyType, String supplyName, long id, Supplier supplier, double price) {
        this.supplyType = supplyType;
        this.supplyName = supplyName;
        this.id = id;
        this.supplier = supplier;
        this.price = price;
    }
}
