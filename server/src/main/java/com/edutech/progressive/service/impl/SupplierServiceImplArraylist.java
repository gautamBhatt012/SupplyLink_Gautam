package com.edutech.progressive.service.impl;

<<<<<<< HEAD
public class SupplierServiceImplArraylist  {
=======
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

public class SupplierServiceImplArraylist implements SupplierService 
{
    private static List<Supplier> supplierList = new ArrayList<>();

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierList;
    }

    @Override
    public int addSupplier(Supplier supplier) {
        supplierList.add(supplier);
        return supplierList.size();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> sortedSupplier = supplierList;
        sortedSupplier.sort(Comparator.comparing(Supplier::getSupplierName)); 
        return sortedSupplier;
    }

    @Override
    public void emptyArrayList() {
        supplierList = new ArrayList<>();
    }
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8

}