class Customer {
    constructor(fullName, birthDay, identity, phoneNumber, gender, email, address, numberPeople, typeCustomer, typeService, rentDay) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.identity = identity;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.rentDay = rentDay;
        this.typeCustomer = typeCustomer;
        this.numberPeople = numberPeople;
        this.typeService = typeService;
    }

    get discount() {
        let discountRate = 0;
        switch (this.address) {
            case 'Đà Nẵng':
                discountRate += 20;
                break;
            case 'Huế':
                discountRate += 10;
                break;
            case 'Quảng Nam':
                discountRate += 5;
                break;
            default:
                break;
        }
        let day = parseInt(this.rentDay);
        if (day >= 7) {
            discountRate += 30;
        } else if (day >= 5) {
            discountRate += 20;
        } else if (day >= 2) {
            discountRate += 10;
        }
        switch (this.typeCustomer) {
            case 'Diamond':
                discountRate += 15;
                break;
            case 'Platinum':
                discountRate += 10;
                break;
            case 'Gold':
                discountRate += 5;
                break;
            case 'Silver':
                discountRate += 2;
                break;
            default:
                break;
        }

        return discountRate;

    }

    get totalMoney() {
        let total = 0;
        let price = 0;
        switch (this.typeService) {
            case 'Villa':
                price = 500;
                break;
            case 'House':
                price = 300;
                break;
            case 'Room':
                price = 200;
                break;
            default:
                break;
        }
        total = price * parseInt(this.rentDay || 0) - this.discount;
        return (total >= 0) ? total : 0;
    }
}

class Employee {
    constructor(fullName, birthDay, identity, phoneNumber, email, education, position) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.identity = identity;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.education = education;
        this.position = position;
    }

    get wage() {
        let salary = 1000;
        switch (this.position) {
            case 'Manager':
                salary += 500;
                break;
            case 'Sale':
                salary += 300;
                break;
            case 'Marketing':
                salary += 200;
                break;
            default:
                break;
        }
        return salary;
    }

}

class Model {
    constructor() {
        this.storageCustomer = new Array();
        this.storageEmployee = new Array();
    }

    validateCustomer(customer) {
        let duplicateIdentity = true;
        for (let item of this.storageCustomer) {
            if (item.identity === customer.identity) {
                duplicateIdentity = false;
                break;
            }
        }
        //Kiểm tra tên theo đúng định dạng

        let checkFullName = customer.fullName;
        if (checkFullName && !/\^s+$/.test(checkFullName)) {
            let nameArr = checkFullName.split(/\s+/);

            for (let i = 0; i < nameArr.length; i++) {
                if (nameArr[i]) {
                    nameArr[i] = nameArr[i][0].toUpperCase() + nameArr[i].substr(1);
                }
            }
            checkFullName = nameArr.join(" ");
        } else checkFullName = false;

        //Kiểm tra ngày sinh theo đúng định dạng
        let checkBirthDay = true;

        let re_birthday = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/;

        if (re_birthday.test(customer.birthDay) === false) {
            checkBirthDay = false;
        }
        //Kiểm tra số chứng minh nhân dân

        let checkIdentity = true;

        let re_identity = /^[0-9]{8}$/;
        if (re_identity.test(customer.identity) === false) {
            checkIdentity = false;
        }

        //Kiểm tra số điện thoại

        let checkPhoneNumber = true;

        let re_phoneNumber = /^[0-9]{10}$/;
        if (re_phoneNumber.test(customer.phoneNumber) === false) {
            checkPhoneNumber = false;
        }
        //Kiểm tra email

        let checkEmail = true;
        let re_email = /^[A-Za-z0-9_]+@[A-Za-z0-9_]+\.[A-Za-z0-9_]+$/;
        if (re_email.test(customer.email) === false) {
            checkEmail = false;
        }

        let checkAddress = customer.address;
        if (checkAddress) {
            checkAddress = checkAddress.split(/\s+/).join(" ");
        } else checkAddress = false;

        let checkNumberPeople = true;
        let re_checkNumberPeople = /^[0-9]+$/;
        if (re_checkNumberPeople.test(customer.numberPeople) === false) {
            checkNumberPeople = false;
        }
        let checkRentDay = true;
        let re_checkRentDay = /^[0-9]+$/;
        if (re_checkRentDay.test(customer.rentDay) === false) {
            checkRentDay = false;
        }


        let customerCheck = new Customer(checkFullName, checkBirthDay, checkIdentity, checkPhoneNumber, true, checkEmail, checkAddress, checkNumberPeople, true, true, checkRentDay)
        return {
            'duplicate': duplicateIdentity,
            'customer': customerCheck,
            'discount': customer.discount,
            'total': customer.totalMoney,
        }


    }

    addCustomer(customer) {
        this.storageCustomer.push(customer);
    }

    modifyCustomer(customer, i) {
        this.storageCustomer[i] = customer;
    }

    removeCustomer(i) {
        this.storageCustomer.splice(i, 1);
    }

    validateEmployee(employee) {
        let duplicateIdentity = true;
        for (let item of this.storageEmployee) {
            if (item.identity === employee.identity) {
                duplicateIdentity = false;
                break;
            }
        }
        //Kiểm tra tên theo đúng định dạng

        let checkFullName = employee.fullName;
        if (checkFullName && !/\^s+$/.test(checkFullName)) {
            let nameArr = checkFullName.split(/\s+/);

            for (let i = 0; i < nameArr.length; i++) {
                if (nameArr[i]) {
                    nameArr[i] = nameArr[i][0].toUpperCase() + nameArr[i].substr(1);
                }
            }
            checkFullName = nameArr.join(" ");
        } else checkFullName = false;

        //Kiểm tra ngày sinh theo đúng định dạng
        let checkBirthDay = true;

        let re_birthday = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/;

        if (re_birthday.test(employee.birthDay) === false) {
            checkBirthDay = false;
        }
        //Kiểm tra số chứng minh nhân dân

        let checkIdentity = true;

        let re_identity = /^[0-9]{8}$/;
        if (re_identity.test(employee.identity) === false) {
            checkIdentity = false;
        }

        //Kiểm tra số điện thoại

        let checkPhoneNumber = true;

        let re_phoneNumber = /^[0-9]{10}$/;
        if (re_phoneNumber.test(employee.phoneNumber) === false) {
            checkPhoneNumber = false;
        }
        //Kiểm tra email

        let checkEmail = true;
        let re_email = /^[A-Za-z0-9_]+@[A-Za-z0-9_]+\.[A-Za-z0-9_]+$/;
        if (re_email.test(employee.email) === false) {
            checkEmail = false;
        }

        let employeeCheck = new Employee(checkFullName, checkBirthDay, checkIdentity, checkPhoneNumber, checkEmail, true, true);
        return {
            'duplicate': duplicateIdentity,
            'employee': employeeCheck,
            'wage': employee.wage
        }


    }

    addEmployee(employee) {
        this.storageEmployee.push(employee);
    }

    modifyEmployee(employee, i) {
        this.storageEmployee[i] = employee;
    }

    removeEmployee(i) {
        this.storageEmployee.splice(i, 1);
    }

}

class View {
    constructor() {
        this.menu = document.getElementById('navigator');
        this.content = document.getElementById('content');
        this.addCustomerButton = this.createButton('Add Customer', 'add-customer-menu', this.menu, 'menu-div', 'div');
        this.showCustomerButton = this.createButton('Show Customer', 'show-customer-menu', this.menu, 'menu-div', 'div');

        this.addEmployeeButton = this.createButton('Add Employee', 'add-employee-menu', this.menu, 'menu-div', 'div');
        this.showEmployeeButton = this.createButton('Show Customer', 'show-customer-menu', this.menu, 'menu-div', 'div');

    }

    createButton(buttonName, buttonId, parentElement, classTag, type) {
        let button = document.createElement(type);
        button.innerText = buttonName;
        button.id = buttonId;
        button.className = classTag;
        parentElement.appendChild(button);
        return button;
    }

    createInput(inputName, inputId, parentElement, type, value) {

        let label = document.createElement('label');
        label.className = 'label-input';
        label.htmlFor = inputId;
        label.innerText = inputName;

        let input = document.createElement('input');
        input.type = type;
        input.id = inputId;
        input.className = type + '-input-content';
        input.value = value;

        let div = document.createElement('div');
        div.className = 'div-input';
        div.appendChild(label);
        div.appendChild(input);

        parentElement.appendChild(div);

        return div;

    }

    createSelect(selectName, selectId, parentElement, arrayOption, value) {

        let label = document.createElement('label');
        label.className = 'label-input';
        label.htmlFor = selectId;
        label.innerText = selectName;

        let input = document.createElement('select');
        input.id = selectId;
        input.className = 'select-input-content';

        for (let item of arrayOption) {
            let option = document.createElement('option');
            option.value = item;
            option.innerText = item;
            input.appendChild(option);
        }

        input.value = value;

        let div = document.createElement('div');
        div.className = 'div-input';
        div.appendChild(label);
        div.appendChild(input);

        parentElement.appendChild(div);

        return div;
    }

    createFormInput() {
        let form = document.createElement('div');

        this.createInput('Full Name:', 'fullName', form, 'text', '');
        this.createInput('Birthday:', 'birthDay', form, 'text', '');
        this.createInput('Identity:', 'identity', form, 'text', '');
        this.createInput('Phone Number:', 'phoneNumber', form, 'text', '');
        this.createSelect('Gender:', 'gender', form, ['Male', 'Female', 'Bisexual'], 'Male');
        this.createInput('Email:', 'email', form, 'email', '');
        this.createInput('Address:', 'address', form, 'text', '');

        this.createInput('Number People:', 'numberPeople', form, 'number', '');
        this.createInput('Rent Days:', 'rentDay', form, 'number', '');

        this.createSelect('Type customer:', 'typeCustomer', form, ['Diamond', 'Platinum', 'Gold', 'Silver', 'Member'], 'Diamond');
        this.createSelect('Type Service:', 'typeService', form, ['Villa', 'House', 'Room'], 'Villa');

        this.createButton('Demo', 'demo', form, 'button-content', 'button');
        this.createButton('Validate', 'validate', form, 'button-content', 'button');
        this.createButton('Update', 'update', form, 'button-content', 'button');

        return form;
    }

    updateContent(form) {
        while (this.content.lastChild) {
            this.content.removeChild(this.content.lastChild);
        }
        this.content.appendChild(form);
    }

    getCustomerInfo() {

        let fullName = document.getElementById('fullName').value;
        let birthDay = document.getElementById('birthDay').value;
        let identity = document.getElementById('identity').value;
        let phoneNumber = document.getElementById('phoneNumber').value;
        let gender = document.getElementById('gender').value;
        let email = document.getElementById('email').value;
        let typeCustomer = document.getElementById('typeCustomer').value;
        let numberPeople = document.getElementById('numberPeople').value;
        let typeService = document.getElementById('typeService').value;
        let address = document.getElementById('address').value;
        let rentDay = document.getElementById('rentDay').value


        let customer = new Customer(fullName, birthDay, identity, phoneNumber, gender, email, address, numberPeople, typeCustomer, typeService, rentDay);

        return customer;
    }

    demoInfo() {
        document.getElementById('fullName').value = "Phạm Trường Phúc"
        document.getElementById('birthDay').value = "08/12/1992"
        document.getElementById('identity').value = "01234567"
        document.getElementById('phoneNumber').value = "0935507895"
        document.getElementById('gender').value = "Male"
        document.getElementById('email').value = "truongphucdn@gmail.com"
        document.getElementById('address').value = "Đà Nẵng"
        document.getElementById('numberPeople').value = "2"
        document.getElementById('rentDay').value = "1"
        document.getElementById('typeCustomer').value = "Gold"
        document.getElementById('typeService').value = "Room"
    }

    warningInputCustomer(validationCheck) {
        while (document.querySelector('.warning')) {
            document.querySelector('.warning').classList.remove('warning');
        }

        if (document.querySelector('#warning')) {
            document.querySelector('#warning').remove();
        }

        if (document.querySelector('#cost')) {
            document.querySelector('#cost').remove();
        }

        if (validationCheck.customer.fullName == false) {
            document.getElementById('fullName').classList.add('warning');
        } else document.getElementById('fullName').value = validationCheck.customer.fullName;

        if (validationCheck.customer.birthDay == false) {
            document.getElementById('birthDay').classList.add('warning');
        }

        if (validationCheck.customer.identity == false) {
            document.getElementById('identity').classList.add('warning');
        }

        if (validationCheck.duplicate == false) {
            let warning = document.createElement('div');
            warning.className = 'label-input'
            warning.id = 'warning';
            warning.innerText = 'Your identity has been registered!'
            this.content.appendChild(warning);
        }

        if (validationCheck.customer.phoneNumber == false) {
            document.getElementById('phoneNumber').classList.add('warning');
        }

        if (validationCheck.customer.email == false) {
            document.getElementById('email').classList.add('warning');
        }

        if (validationCheck.customer.address == false) {
            document.getElementById('address').classList.add('warning');
        } else document.getElementById('address').value = validationCheck.customer.address;

        if (validationCheck.customer.numberPeople == false) {
            document.getElementById('numberPeople').classList.add('warning');
        }

        if (validationCheck.customer.rentDay == false) {
            document.getElementById('rentDay').classList.add('warning');
        }

        let cost = document.createElement('div');
        cost.id = 'cost';
        this.createInput('Discount: ', 'discount', cost, 'text', validationCheck.discount);
        this.createInput('Total: ', 'total', cost, 'text', validationCheck.total);
        document.getElementById('content').appendChild(cost);

        document.getElementById('discount').disabled = true;
        document.getElementById('total').disabled = true;
    }

    createTableCustomer(customerArray) {
        let table = document.createElement('table');
        table.className = 'table-show';
        let head = this.createTableElement('thead', table, 'thead', '');
        let row_header = this.createTableElement('tr', head, 'row_header', '', 'header-show');
        this.createTableElement('th', row_header, 'head_fullName', 'Full Name', 'cell-show');
        this.createTableElement('th', row_header, 'head_birthDay', 'Birthday', 'cell-show');
        this.createTableElement('th', row_header, 'head_identity', 'Identity', 'cell-show');
        this.createTableElement('th', row_header, 'head_phoneNumber', 'Phone Number', 'cell-show');
        this.createTableElement('th', row_header, 'head_gender', 'Gender', 'cell-show');
        this.createTableElement('th', row_header, 'head_email', 'Email', 'cell-show');
        this.createTableElement('th', row_header, 'head_address', 'Address', 'cell-show');
        this.createTableElement('th', row_header, 'head_typeCustomer', 'Type Customer', 'cell-show');
        this.createTableElement('th', row_header, 'head_numberPeople', 'Number People', 'cell-show');
        this.createTableElement('th', row_header, 'head_typeService', 'Type Service', 'cell-show');
        this.createTableElement('th', row_header, 'head_rentDay', 'Rent Days', 'cell-show');

        this.createTableElement('th', row_header, 'head_discount', 'Discount', 'cell-show');
        this.createTableElement('th', row_header, 'head_total', 'Total', 'cell-show');
        this.createTableElement('th', row_header, '', 'Action', 'cell-show');

        let tbody = this.createTableElement('tbody', table, 'tbody', '');

        for (let i = 0; i < customerArray.length; i++) {
            let row = this.createTableElement('tr', tbody, 'row' + '-' + i, '', 'row-show');
            this.createTableElement('td', row, 'fullName' + '-' + i, customerArray[i].fullName, 'cell-show');
            this.createTableElement('td', row, 'birthDay' + '-' + i, customerArray[i].birthDay, 'cell-show');
            this.createTableElement('td', row, 'identity' + '-' + i, customerArray[i].identity, 'cell-show');
            this.createTableElement('td', row, 'phoneNumber' + '-' + i, customerArray[i].phoneNumber, 'cell-show');
            this.createTableElement('td', row, 'gender' + '-' + i, customerArray[i].gender, 'cell-show');
            this.createTableElement('td', row, 'email' + '-' + i, customerArray[i].email, 'cell-show');
            this.createTableElement('td', row, 'address' + '-' + i, customerArray[i].address, 'cell-show');
            this.createTableElement('td', row, 'typeCustomer' + '-' + i, customerArray[i].typeCustomer, 'cell-show');
            this.createTableElement('td', row, 'numberPeople' + '-' + i, customerArray[i].numberPeople, 'cell-show');
            this.createTableElement('td', row, 'typeService' + '-' + i, customerArray[i].typeService, 'cell-show');
            this.createTableElement('td', row, 'rentDay' + '-' + i, customerArray[i].rentDay, 'cell-show');
            this.createTableElement('td', row, 'discount' + '-' + i, customerArray[i].discount, 'cell-show');
            this.createTableElement('td', row, 'discount' + '-' + i, customerArray[i].totalMoney, 'cell-show');

            let cell_button = this.createTableElement('td', row, 'cell-button' + '-' + i, '', 'cell-show');
            this.createTableElement('i', cell_button, 'edit' + '-' + i, 'edit', "material-icons");
            this.createTableElement('i', cell_button, 'delete' + '-' + i, 'delete', "material-icons");
        }
        return table;
    }

    createTableElement(tag, parent, id, inner, classTag) {
        let item = document.createElement(tag);
        item.id = id;
        item.className = classTag;
        item.innerText = inner;
        parent.appendChild(item);
        return item;

    }

    createDetailCustomer(customer) {
        let form = document.createElement('div');

        this.createInput('Full Name:', 'fullName', form, 'text', customer.fullName);
        this.createInput('Birthday:', 'birthDay', form, 'text', customer.birthDay);
        this.createInput('Identity:', 'identity', form, 'text', customer.identity);
        this.createInput('Phone Number:', 'phoneNumber', form, 'text', customer.phoneNumber);
        this.createSelect('Gender:', 'gender', form, ['Male', 'Female', 'Bisexual'], customer.gender);
        this.createInput('Email:', 'email', form, 'email', customer.email);
        this.createInput('Address:', 'address', form, 'text', customer.address);

        this.createInput('Number People:', 'numberPeople', form, 'number', customer.numberPeople);
        this.createInput('Rent Days:', 'rentDay', form, 'number', customer.rentDay);
        this.createSelect('Type customer:', 'typeCustomer', form, ['Diamond', 'Platinum', 'Gold', 'Silver', 'Member'], customer.typeCustomer);
        this.createSelect('Type Service:', 'typeService', form, ['Villa', 'House', 'Room'], customer.typeService);

        this.createButton('Validate', 'validate', form, 'button-content', 'button');
        this.createButton('Update', 'update', form, 'button-content', 'button');

        return form;
    }

    createFormEmployee() {
        let form = document.createElement('div');

        this.createInput('Full Name:', 'fullName', form, 'text', '');
        this.createInput('Birthday:', 'birthDay', form, 'text', '');
        this.createInput('Identity:', 'identity', form, 'text', '');
        this.createInput('Phone Number:', 'phoneNumber', form, 'text', '');
        this.createSelect('Gender:', 'gender', form, ['Male', 'Female', 'Bisexual'], 'Male');
        this.createInput('Email:', 'email', form, 'email', '');

        this.createSelect('Education:', 'education', form, ['Intermediate-Degree', 'College', 'University', 'Post-graduate'], 'University');
        this.createSelect('Position:', 'position', form, ['Sale', 'Marketing', 'Manager'], 'Sale');

        this.createButton('Demo', 'demo', form, 'button-content', 'button');
        this.createButton('Validate', 'validate', form, 'button-content', 'button');
        this.createButton('Update', 'update', form, 'button-content', 'button');

        return form;
    }

    getEmployeeInfo() {

        let fullName = document.getElementById('fullName').value;
        let birthDay = document.getElementById('birthDay').value;
        let identity = document.getElementById('identity').value;
        let phoneNumber = document.getElementById('phoneNumber').value;
        let email = document.getElementById('email').value;
        let education = document.getElementById('education').value;
        let position = document.getElementById('position').value;

        let employee = new Employee(fullName, birthDay, identity, phoneNumber, email, education, position);

        return employee;
    }

    demoEmployeeInfo() {
        document.getElementById('fullName').value = "Phạm Trường Phúc"
        document.getElementById('birthDay').value = "08/12/1992"
        document.getElementById('identity').value = "01234567"
        document.getElementById('phoneNumber').value = "0935507895"
        document.getElementById('email').value = "truongphucdn@gmail.com"
        document.getElementById('education').value = "University"
        document.getElementById('position').value = "Sale"
    }

    warningInputEmployee(validationCheck) {
        while (document.querySelector('.warning')) {
            document.querySelector('.warning').classList.remove('warning');
        }

        if (document.querySelector('#warning')) {
            document.querySelector('#warning').remove();
        }

        if (document.querySelector('#wage')) {
            document.querySelector('#wage').remove();
        }

        if (validationCheck.employee.fullName == false) {
            document.getElementById('fullName').classList.add('warning');
        } else document.getElementById('fullName').value = validationCheck.employee.fullName;

        if (validationCheck.employee.birthDay == false) {
            document.getElementById('birthDay').classList.add('warning');
        }

        if (validationCheck.employee.identity == false) {
            document.getElementById('identity').classList.add('warning');
        }

        if (validationCheck.duplicate == false) {
            let warning = document.createElement('div');
            warning.className = 'label-input'
            warning.id = 'warning';
            warning.innerText = 'Your identity has been registered!'
            this.content.appendChild(warning);
        }

        if (validationCheck.employee.phoneNumber == false) {
            document.getElementById('phoneNumber').classList.add('warning');
        }

        if (validationCheck.employee.email == false) {
            document.getElementById('email').classList.add('warning');
        }

        let wage = document.createElement('div');
        wage.id = 'wage';
        this.createInput('Wage', 'wage_salary', wage, 'text', validationCheck.wage);
        document.getElementById('content').appendChild(wage);

        document.getElementById('wage_salary').disabled = true;
    }

    createTableEmployee(employeeArray) {
        let table = document.createElement('table');
        table.className = 'table-show';

        let head = this.createTableElement('thead', table, 'thead', '');
        let row_header = this.createTableElement('tr', head, 'row_header', '', 'header-show');
        this.createTableElement('th', row_header, 'head_fullName', 'Full Name', 'cell-show');
        this.createTableElement('th', row_header, 'head_birthDay', 'Birthday', 'cell-show');
        this.createTableElement('th', row_header, 'head_identity', 'Identity', 'cell-show');
        this.createTableElement('th', row_header, 'head_phoneNumber', 'Phone Number', 'cell-show');
        this.createTableElement('th', row_header, 'head_email', 'Email', 'cell-show');
        this.createTableElement('th', row_header, 'head_education', 'Education', 'cell-show');
        this.createTableElement('th', row_header, 'head_position', 'Position', 'cell-show');

        this.createTableElement('th', row_header, 'head_Wage', 'Wage', 'cell-show');

        this.createTableElement('th', row_header, '', 'Action', 'cell-show');

        let tbody = this.createTableElement('tbody', table, 'tbody', '');

        for (let i = 0; i < employeeArray.length; i++) {
            let row = this.createTableElement('tr', tbody, 'row' + '-' + i, '', 'row-show');

            this.createTableElement('td', row, 'fullName' + '-' + i, employeeArray[i].fullName, 'cell-show');
            this.createTableElement('td', row, 'birthDay' + '-' + i, employeeArray[i].birthDay, 'cell-show');
            this.createTableElement('td', row, 'identity' + '-' + i, employeeArray[i].identity, 'cell-show');
            this.createTableElement('td', row, 'phoneNumber' + '-' + i, employeeArray[i].phoneNumber, 'cell-show');
            this.createTableElement('td', row, 'email' + '-' + i, employeeArray[i].email, 'cell-show');
            this.createTableElement('td', row, 'education' + '-' + i, employeeArray[i].education, 'cell-show');
            this.createTableElement('td', row, 'position' + '-' + i, employeeArray[i].position, 'cell-show');

            this.createTableElement('td', row, 'wage' + '-' + i, employeeArray[i].wage, 'cell-show');

            let cell_button = this.createTableElement('td', row, 'cell-button' + '-' + i, '', 'cell-show');
            this.createTableElement('i', cell_button, 'edit' + '-' + i, 'edit', "material-icons");
            this.createTableElement('i', cell_button, 'delete' + '-' + i, 'delete', "material-icons");
        }
        return table;
    }

    createDetailEmployee(employee) {
        let form = document.createElement('div');

        this.createInput('Full Name:', 'fullName', form, 'text', employee.fullName);
        this.createInput('Birthday:', 'birthDay', form, 'text', employee.birthDay);
        this.createInput('Identity:', 'identity', form, 'text', employee.identity);
        this.createInput('Phone Number:', 'phoneNumber', form, 'text', employee.phoneNumber);
        this.createInput('Email:', 'email', form, 'email', employee.email);

        this.createSelect('Education:', 'education', form, ['Intermediate-Degree', 'College', 'University', 'Post-graduate'], employee.education);
        this.createSelect('Position:', 'position', form, ['Sale', 'Marketing', 'Manager'], employee.position);

        this.createButton('Validate', 'validate', form, 'button-content', 'button');
        this.createButton('Update', 'update', form, 'button-content', 'button');

        return form;
    }
}

class Controller {
    constructor() {
        this.model = new Model();
        this.view = new View();

        this.view.addCustomerButton.addEventListener('click', evt => {
            let form = this.view.createFormInput();
            this.view.updateContent(form);
            document.getElementById('demo').addEventListener('click', evt => {
                this.view.demoInfo();
            });

            document.getElementById('validate').addEventListener('click', evt => {
                this.view.warningInputCustomer(this.model.validateCustomer(this.view.getCustomerInfo()));
            });

            document.getElementById('update').addEventListener('click', evt => {
                let customer = this.view.getCustomerInfo();

                let checking = this.model.validateCustomer(customer);
                this.view.warningInputCustomer(checking);
                if (checking.duplicate
                    && checking.customer.fullName
                    && checking.customer.birthDay
                    && checking.customer.identity
                    && checking.customer.phoneNumber
                    && checking.customer.email
                    && checking.customer.address
                    && checking.customer.numberPeople) {
                    this.model.addCustomer(customer);
                }
            })
        })

        this.view.showCustomerButton.addEventListener('click', evt => {
            this.view.updateContent(this.view.createTableCustomer(this.model.storageCustomer));

            for (let i = 0; i < this.model.storageCustomer.length; i++) {
                document.getElementById('edit-' + i).addEventListener('click', evt => {
                    this.view.updateContent(this.view.createDetailCustomer(this.model.storageCustomer[i]));

                    document.getElementById('validate').addEventListener('click', evt => {
                        let checking = this.model.validateCustomer(this.view.getCustomerInfo());
                        checking.duplicate = true;
                        this.view.warningInputCustomer(checking);
                    });

                    document.getElementById('update').addEventListener('click', evt => {
                        let customer = this.view.getCustomerInfo();

                        let checking = this.model.validateCustomer(customer);
                        checking.duplicate = true;
                        console.log(checking);
                        this.view.warningInputCustomer(checking);
                        if (checking.customer.fullName
                            && checking.customer.birthDay
                            && checking.customer.identity
                            && checking.customer.phoneNumber
                            && checking.customer.email
                            && checking.customer.address
                            && checking.customer.numberPeople) {
                            this.model.modifyCustomer(customer, i);
                        }
                    })
                })

                document.getElementById('delete-' + i).addEventListener('click', evt => {
                    this.model.removeCustomer(i);
                    this.view.updateContent(this.view.createTableCustomer(this.model.storageCustomer));
                })
            }
        })

        this.view.addEmployeeButton.addEventListener('click', evt => {
            let form = this.view.createFormEmployee();
            this.view.updateContent(form);

            document.getElementById('demo').addEventListener('click', evt => {
                this.view.demoEmployeeInfo();
            });

            document.getElementById('validate').addEventListener('click', evt => {
                this.view.warningInputEmployee(this.model.validateEmployee(this.view.getEmployeeInfo()));
            });

            document.getElementById('update').addEventListener('click', evt => {
                let employee = this.view.getEmployeeInfo();

                let checking = this.model.validateEmployee(employee);
                this.view.warningInputEmployee(checking);
                if (checking.duplicate
                    && checking.employee.fullName
                    && checking.employee.birthDay
                    && checking.employee.identity
                    && checking.employee.phoneNumber
                    && checking.employee.email) {
                    this.model.addEmployee(employee);
                }
            })
        })

        this.view.showEmployeeButton.addEventListener('click', evt => {
            this.view.updateContent(this.view.createTableEmployee(this.model.storageEmployee));

            for (let i = 0; i < this.model.storageEmployee.length; i++) {
                document.getElementById('edit-' + i).addEventListener('click', evt => {
                    this.view.updateContent(this.view.createDetailEmployee(this.model.storageEmployee[i]));

                    document.getElementById('validate').addEventListener('click', evt => {
                        let checking = this.model.validateEmployee(this.view.getEmployeeInfo());
                        checking.duplicate = true;
                        this.view.warningInputEmployee(checking);
                    });

                    document.getElementById('update').addEventListener('click', evt => {
                        let customer = this.view.getEmployeeInfo();

                        let checking = this.model.validateEmployee(customer);
                        checking.duplicate = true;
                        console.log(checking);
                        this.view.warningInputEmployee(checking);
                        if (checking.employee.fullName
                            && checking.employee.birthDay
                            && checking.employee.identity
                            && checking.employee.phoneNumber
                            && checking.employee.email) {
                            this.model.modifyEmployee(customer, i);
                        }
                    })
                })

                document.getElementById('delete-' + i).addEventListener('click', evt => {
                    this.model.removeEmployee(i);
                    this.view.updateContent(this.view.createTableEmployee(this.model.storageEmployee));
                })

            }
        })
    }
}

const app = new Controller();