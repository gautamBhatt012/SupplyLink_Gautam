package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.service.SupplierService;

@Service
public class SupplierServiceImplJpa  implements SupplierService{

    
    private SupplierRepository supplierRepository;

    
    @Autowired
    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public int addSupplier(Supplier supplier){
        if(supplierRepository.findByUsername(supplier.getUsername()) != null){
            throw new SupplierAlreadyExistsException("Supplier already exists");
        }
        if(supplierRepository.findByEmail(supplier.getEmail()) != null){
            throw new SupplierAlreadyExistsException("Supplier already exists");
        }
        Supplier savedSupplier = supplierRepository.save(supplier);
        return savedSupplier.getSupplierId();
    }

    public List<Supplier> getAllSuppliersSortedByName(){
        List<Supplier> result = supplierRepository.findAll();
        Collections.sort(result);
        return result;
    }

    public void updateSupplier(int supplierId, Supplier supplier){
        if(supplierRepository.findByUsername(supplier.getUsername()) != null){
            throw new SupplierAlreadyExistsException("Supplier Already exists");
        } 
        Supplier updatedSupplier = supplierRepository.findBySupplierId(supplierId);
        if(updatedSupplier != null){
            
            updatedSupplier.setSupplierName(supplier.getSupplierName());
            updatedSupplier.setEmail(supplier.getEmail());
            updatedSupplier.setPhone(supplier.getPhone());
            updatedSupplier.setAddress(supplier.getAddress());
            updatedSupplier.setUsername(supplier.getUsername());
            updatedSupplier.setPassword(supplier.getPassword());
            updatedSupplier.setRole(supplier.getRole());
            supplierRepository.save(supplier);
        }
        
    }

    public void deleteSupplier(int supplierId){
        supplierRepository.deleteById(supplierId);
    }

    public Supplier getSupplierById(int supplierId){
        if(!supplierRepository.existsById(supplierId)){
            throw new SupplierDoesNotExistException("Supplier does not exist");
        }
        return supplierRepository.findBySupplierId(supplierId);
    }

}




// package com.edutech.progressive.service.impl;

// import java.util.Comparator;
// import java.util.List;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.edutech.progressive.entity.Supplier;
// import com.edutech.progressive.exception.SupplierAlreadyExistsException;
// import com.edutech.progressive.exception.SupplierDoesNotExistException;
// import com.edutech.progressive.repository.SupplierRepository;
// import com.edutech.progressive.service.SupplierService;

// @Service
// public class SupplierServiceImplJpa implements SupplierService {

//     private final SupplierRepository supplierRepository;

//     public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
//         this.supplierRepository = supplierRepository;
//     }

//     @Override
//     public List<Supplier> getAllSuppliers() {
//         return supplierRepository.findAll();
//     }

//     @Override
//     public int addSupplier(Supplier supplier) {
//         validateRole(supplier);

//         Supplier existingByUsername = supplierRepository.findByUsername(supplier.getUsername());
//         if (existingByUsername != null) {
//             throw new SupplierAlreadyExistsException("Username already exists");
//         }

//         Supplier existingByEmail = supplierRepository.findByEmail(supplier.getEmail());
//         if (existingByEmail != null) {
//             throw new SupplierAlreadyExistsException("Email already exists");
//         }

//         Supplier savedSupplier = supplierRepository.save(supplier);
//         return savedSupplier.getSupplierId();
//     }

//     @Override
//     public List<Supplier> getAllSuppliersSortedByName() {
//         List<Supplier> suppliers = supplierRepository.findAll();
//         suppliers.sort(Comparator.comparing(Supplier::getSupplierName));
//         return suppliers;
//     }

//     @Override
//     public Supplier getSupplierById(int supplierId) {
//         Supplier supplier = supplierRepository.findBySupplierId(supplierId);
//         if (supplier == null) {
//             throw new SupplierDoesNotExistException("Supplier does not exist with ID: " + supplierId);
//         }
//         return supplier;
//     }

//     @Override
//     public void updateSupplier(Supplier supplier) {
//         validateRole(supplier);

//         Supplier existingSupplier = supplierRepository.findBySupplierId(supplier.getSupplierId());
//         if (existingSupplier == null) {
//             throw new SupplierDoesNotExistException("Supplier does not exist with ID: " + supplier.getSupplierId());
//         }

//         Supplier existingByUsername = supplierRepository.findByUsername(supplier.getUsername());
//         if (existingByUsername != null && existingByUsername.getSupplierId() != supplier.getSupplierId()) {
//             throw new SupplierAlreadyExistsException("Username already exists");
//         }

//         Supplier existingByEmail = supplierRepository.findByEmail(supplier.getEmail());
//         if (existingByEmail != null && existingByEmail.getSupplierId() != supplier.getSupplierId()) {
//             throw new SupplierAlreadyExistsException("Email already exists");
//         }

//         supplierRepository.save(supplier);
//     }

//     @Override
//     @Transactional
//     public void deleteSupplier(int supplierId) {
//         Supplier existingSupplier = supplierRepository.findBySupplierId(supplierId);
//         if (existingSupplier == null) {
//             throw new SupplierDoesNotExistException("Supplier does not exist with ID: " + supplierId);
//         }

//         // If your entity relationships are set with CascadeType.REMOVE / ALL,
//         // then deleting the supplier may automatically remove child records.
//         // If not, you must also delete related shipments/products/warehouses
//         // using their repositories before deleting the supplier.

//         supplierRepository.deleteBySupplierId(supplierId);
//     }

//     private void validateRole(Supplier supplier) {
//         if (supplier.getRole() == null || supplier.getRole().trim().isEmpty()) {
//             throw new IllegalArgumentException("Role cannot be null or empty");
//         }

//         String role = supplier.getRole().trim().toUpperCase();

//         if (!role.equals("USER") && !role.equals("ADMIN")) {
//             throw new IllegalArgumentException("Role must be either USER or ADMIN");
//         }

//         supplier.setRole(role);
//     }
// }



