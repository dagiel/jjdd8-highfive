package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.dto.view.EmployeeView;
import com.infoshare.academy.highfive.mapper.entity.EmployeeMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class EmployeeService {

    @Inject
    private EmployeeMapper employeeMapper;

    @Inject
    private EmployeeDao employeeDao;

    public void addNewEmployee(EmployeeRequest request) {
        employeeDao.addEmployee(employeeMapper.mapRequestToEntity(request));
    }

    public void editEmployee(Long id, EmployeeRequest request) {
        employeeDao.editEmployee(employeeMapper.mapRequestToEntity(request));
    }

    public EmployeeView deleteEmployee(Long id) {
        return employeeMapper.mapEntityToView(employeeDao.deleteEmployee(id));
    }

    public Employee getById(Long id) {
        return this.employeeDao.getEmployeeById(id);
    }

    public List<EmployeeView> listAll() {
        List<EmployeeView> employeeViewList = new ArrayList<>();
        employeeDao.findAll().forEach(
                employee -> employeeViewList.add(employeeMapper.mapEntityToView(employee))
        );

        return employeeViewList;
    }

}