package com.example.RESTfulWebServices.Controller;

import com.example.RESTfulWebServices.Model.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getEmployees() {
        // Logic to retrieve employees
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        // Logic to create new employee
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        // Logic to update employee
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
        // Logic to delete employee
    }

    @Controller
    public static class EmployeeFormController {

        @GetMapping("/employeeForm")
        public String showForm(Model model) {
            model.addAttribute("employee", new Employee());
            return "employeeForm"; // employeeForm.html view
        }

        @PostMapping("/submitEmployeeForm")
        public String submitForm(@ModelAttribute("employee") Employee employee, Model model) {
            model.addAttribute("name", employee.getName());
            return "employeeSuccess"; // employeeSuccess.html view
        }
    }
}
