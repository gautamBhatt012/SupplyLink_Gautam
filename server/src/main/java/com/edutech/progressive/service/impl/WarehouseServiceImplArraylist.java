package com.edutech.progressive.service.impl;

<<<<<<< HEAD
public class WarehouseServiceImplArraylist  {
=======
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

public class WarehouseServiceImplArraylist implements WarehouseService {
    private static List<Warehouse> warehouseList = new ArrayList<>();

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseList;
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        warehouseList.add(warehouse);
        return warehouseList.size();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        List<Warehouse> sortedWarehouses = warehouseList;
        sortedWarehouses.sort(Comparator.comparing(Warehouse::getCapacity));
        return sortedWarehouses;
    }

    @Override
    public void emptyArrayList() {
        warehouseList = new ArrayList<>();
    }

>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8

}