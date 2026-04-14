package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Warehouse;

<<<<<<< HEAD
import java.util.List;

public interface WarehouseDAO {
    int addWarehouse(Warehouse warehouse);
    Warehouse getWarehouseById(int warehouseId);
    void updateWarehouse (Warehouse warehouse);
    void deleteWarehouse (int warehouseId);
    List<Warehouse> getAllWarehouse();
=======
import java.sql.SQLException;
import java.util.List;

public interface WarehouseDAO {
    int addWarehouse(Warehouse warehouse) throws SQLException;
    Warehouse getWarehouseById(int warehouseId)  throws SQLException;
    void updateWarehouse (Warehouse warehouse)  throws SQLException;
    void deleteWarehouse (int warehouseId)  throws SQLException;
    List<Warehouse> getAllWarehouse()  throws SQLException;
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8
}