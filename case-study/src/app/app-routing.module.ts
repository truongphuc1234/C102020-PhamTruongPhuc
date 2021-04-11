import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {CustomerComponent} from './component/customer/customer.component';
import {EmployeeListComponent} from './component/employee/employee-list/employee-list.component';
import {BrowserModule} from '@angular/platform-browser';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {EmployeeCreateComponent} from './component/employee/employee-create/employee-create.component';
import {MaterialModule} from './material.module';
import {EmployeeDeleteDialogComponent} from './component/employee/employee-delete-dialog/employee-delete-dialog.component';
import {EmployeeEditComponent} from './component/employee/employee-edit/employee-edit.component';
import {MatButtonModule} from '@angular/material/button';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-create', component: EmployeeCreateComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), BrowserModule, Ng2SearchPipeModule, FormsModule, NgxPaginationModule, ReactiveFormsModule,
    MaterialModule, MatButtonModule, MatSelectModule, MatIconModule],
  exports: [RouterModule],
  declarations: [HomeComponent, PageNotFoundComponent, CustomerComponent, EmployeeListComponent, EmployeeCreateComponent,
    EmployeeDeleteDialogComponent, EmployeeEditComponent]
})
export class AppRoutingModule {
}
