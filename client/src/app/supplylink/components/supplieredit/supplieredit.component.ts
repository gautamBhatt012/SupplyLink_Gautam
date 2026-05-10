// import { Component, OnInit } from '@angular/core';
// import { Supplier } from '../../types/Supplier';
// import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import { of } from 'rxjs';
// import { SupplyLinkService } from '../../services/supplylink.service';
// import { HttpErrorResponse } from '@angular/common/http';
// import { ActivatedRoute, Router } from '@angular/router';

// @Component({
//     selector: 'app-supplieredit',
//     templateUrl: './supplieredit.component.html',
//     styleUrls: ['./supplieredit.component.scss'],
// })
// export class SupplierEditComponent implements OnInit {
//     successMessage: string | null = null;
//     errorMessage: string | null = null;
//     supplierForm!: FormGroup;
//     supplier: Supplier | null = null;
//     supplierId!: number;

//     constructor(
//         private formBuilder: FormBuilder,
//         private supplyLinkService: SupplyLinkService,
//         private route: ActivatedRoute,
//         private router: Router
//     ) { }

//     ngOnInit(): void {
//         this.supplierForm = this.formBuilder.group({
//             supplierName: ["", [Validators.required]],
//             email: [{ value: '', disabled: true }, [Validators.required, Validators.email]],
//             phone: [""],
//             address: [""],
//             username: ["", [Validators.required, this.noSpecialCharacters]],
//             role: ["", [Validators.required]]
//         });
//         this.route.params.subscribe(params => {
//             this.supplierId = params['supplierId'];
//             this.loadSupplierDetails();
//         });
//     }

//     loadSupplierDetails(): void {
//         this.supplyLinkService.getSupplierById(this.supplierId).subscribe({
//             next: (supplier) => {
//                 this.supplier = supplier;
//                 this.supplierForm.patchValue({
//                     supplierName: supplier.supplierName,
//                     email: supplier.email,
//                     phone: supplier.phone,
//                     address: supplier.address,
//                     username: supplier.username,
//                     role: supplier.role
//                 });
//             },
//             error: (error) => {
//                 this.errorMessage = 'Error loading supplier details.';
//                 console.log(this.errorMessage);
//             }
//         })
//     }

//     private noSpecialCharacters(control: any): { [key: string]: boolean } | null {
//         const SPECIAL_CHARACTERS_REGEX = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;
//         if (SPECIAL_CHARACTERS_REGEX.test(control.value)) {
//             return { specialCharacters: true };
//         }
//         return null;
//     }

//     onSubmit(): void {
//         if (this.supplierForm.valid) {

//             const formData = this.supplierForm.getRawValue();

//             const updatedSupplier: Supplier = {
//                 supplierId: this.supplierId,
//                 supplierName: formData.supplierName,
//                 email: this.supplier!.email ?? "",
//                 phone: formData.phone,
//                 address: formData.address,
//                 username: formData.username,
//                 password: formData.password,
//                 role: formData.role
//             };

//             console.log("Sending Supplier:", updatedSupplier);

//             this.supplyLinkService.editSupplier(updatedSupplier).subscribe({
//                 next: (response) => {
//                     this.successMessage = 'Supplier updated successfully';
//                     this.errorMessage = null;

//                     this.router.navigate(['/supplylink']);
//                 },
//                 error: (error) => {
//                     if (error.status === 400) {
//                         this.errorMessage = error.error;
//                     } else {
//                         this.errorMessage = 'Please check the entered data.';
//                     }
//                     console.log(error);
//                 }
//             });

//         } else {
//             this.errorMessage = 'Please fill out all required fields correctly.';
//             this.successMessage = null;
//         }
//     }

// }



import { Component, OnInit } from '@angular/core';
import { Supplier } from '../../types/Supplier';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SupplyLinkService } from '../../services/supplylink.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-supplieredit',
  templateUrl: './supplieredit.component.html',
  styleUrls: ['./supplieredit.component.scss'],
})
export class SupplierEditComponent implements OnInit {

  successMessage: string | null = null;
  errorMessage: string | null = null;

  supplierForm!: FormGroup;
  supplier!: Supplier;
  supplierId!: number;

  constructor(
    private formBuilder: FormBuilder,
    private supplyLinkService: SupplyLinkService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {

    this.supplierForm = this.formBuilder.group({
      supplierName: ['', Validators.required],
      email: [{ value: '', disabled: true }, [Validators.required, Validators.email]],
      phone: [''],
      address: [''],
      username: ['', Validators.required],
      password: [''], // IMPORTANT FIX
      role: ['', Validators.required]
    });

    // this.route.params.subscribe(params => {
    //   this.supplierId = Number(params['supplierId']);
    //   this.loadSupplierDetails();
    // });

    this.route.paramMap.subscribe(params => {

    this.supplierId = Number(params.get('supplierId'));

    console.log("Supplier ID:", this.supplierId);

    this.loadSupplierDetails();
});
  }

  loadSupplierDetails(): void {

    this.supplyLinkService.getSupplierById(this.supplierId).subscribe({
      next: (supplier) => {

        this.supplier = supplier;

        this.supplierForm.patchValue({
          supplierName: supplier.supplierName,
          email: supplier.email,
          phone: supplier.phone,
          address: supplier.address,
          username: supplier.username,
          password: supplier.password, // IMPORTANT FIX
          role: supplier.role
        });
      },

      error: () => {
        this.errorMessage = 'Error loading supplier details.';
      }
    });
  }

  onSubmit(): void {

    if (this.supplierForm.invalid) {
      this.errorMessage = 'Please fill all required fields';
      return;
    }

    const formData = this.supplierForm.getRawValue();

    // const updatedSupplier: Supplier = {
    //   supplierId: this.supplierId,
    //   supplierName: formData.supplierName,
    //   email: formData.email,
    //   phone: formData.phone,
    //   address: formData.address,
    //   username: formData.username,
    //   password: formData.password,
    //   role: formData.role
    // };

    const updatedSupplier: Supplier = {
    supplierId: this.supplierId,
    supplierName: formData.supplierName,
    email: this.supplier.email,
    phone: formData.phone,
    address: formData.address,
    username: formData.username,
    password: this.supplier.password,
    role: formData.role
};

    console.log('Updated Supplier:', updatedSupplier);

    this.supplyLinkService.editSupplier(updatedSupplier).subscribe({

      next: () => {

        this.successMessage = 'Supplier updated successfully';

        // IMPORTANT FIX
        // Force dashboard refresh
        this.router.navigateByUrl('/supplylink');
      },

      error: (error) => {
        console.log(error);
        this.errorMessage = 'Error updating supplier';
      }
    });
  }
}