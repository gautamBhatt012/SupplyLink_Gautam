package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Supplier;

<<<<<<< HEAD
import java.util.List;

public interface SupplierDAO {
    int addSupplier(Supplier supplier);
    Supplier getSupplierById(int supplierId);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(int supplierId) ;
    List<Supplier> getAllSuppliers();
}
=======
import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO {
    int addSupplier(Supplier supplier) throws SQLException;
    Supplier getSupplierById(int supplierId)  throws SQLException;
    void updateSupplier(Supplier supplier)  throws SQLException;
    void deleteSupplier(int supplierId)  throws SQLException;
    List<Supplier> getAllSuppliers()  throws SQLException;
}
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8
