package com.agus.test.dao.daoImpl;

import com.agus.test.dao.EmployeeDao;
import com.agus.test.dto.TableRequest;
import com.agus.test.entity.Employee;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        Query query = entityManager.createQuery("FROM Employee WHERE isDelete = 0");
//                .setFirstResult((tableRequest.getPage() -1) * tableRequest.getSize())
//                .setMaxResults(tableRequest.getSize());
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getById(Integer id) {
        Query query = entityManager.createQuery("FROM Employee WHERE id = :id")
                .setParameter("id", id);
        return (Employee) query.getSingleResult();
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        Query query = entityManager.createQuery("UPDATE Employee set name = :name, birthDate = :birthDate, " +
                "position = :position, idNumber = :idNumber, gender = :gender, isDelete = :isDelete WHERE id = :id")
                .setParameter("name", employee.getName())
                .setParameter("birthDate", employee.getBirthDate())
                .setParameter("position", employee.getPosition())
                .setParameter("idNumber", employee.getIdNumber())
                .setParameter("gender", employee.getGender())
                .setParameter("isDelete", employee.getIsDelete())
                .setParameter("id", employee.getId());
        query.executeUpdate();
        return employee;
    }

    @Transactional
    @Override
    public Employee delete(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        Query query = entityManager.createQuery("UPDATE Employee set isDelete=1 WHERE id = :id")
                .setParameter("id", id);
        query.executeUpdate();
        return employee;
    }

    @Override
    public List<Employee> getByidNumber(Integer id) {
        Query query = entityManager.createQuery("From Employee WHERE idNumber = :idNumber")
                .setParameter("idNumber", id);
        return query.getResultList();
    }
}
