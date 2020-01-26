package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.dto.view.EmployeeView;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class EmployeeMapper {

    @Inject TeamMapper teamMapper;

    public Employee mapRequestToEntity(EmployeeRequest request) {

        Employee employee = new Employee();

        employee.setId(request.getId());
        employee.setFirstName(request.getFirstName());
        employee.setSurname(request.getSurname());
        employee.setHireDate(request.getHireDate());
        employee.setHolidayEntitlement(request.getHolidayEntitlement());
        employee.setAdditionalEntitlement(request.getAdditionalEntitlement());
        employee.setEmail(request.getEmail());
        employee.setLogin(request.getLogin());
        employee.setPosition(request.getPosition());
        employee.setTeam(request.getTeam());
        employee.setRole(request.getRole());

        return employee;
    }

    public EmployeeView mapEntityToView(Employee employee){
        EmployeeView employeeView = new EmployeeView();

        employeeView.setId(employee.getId());
        employeeView.setFirstName(employee.getFirstName());
        employeeView.setSurname(employee.getSurname());
        employeeView.setHireDate(employee.getHireDate());
        employeeView.setHolidayEntitlement(employee.getHolidayEntitlement());
        employeeView.setAdditionalEntitlement(employee.getAdditionalEntitlement());
        employeeView.setEmail(employee.getEmail());
        employeeView.setTeamView(teamMapper.mapEntityToView(employee.getTeam()));
        employeeView.setRole(employee.getRole());

        return employeeView;

    }
}
