package com.example.elasticsearchtest.repository;

import com.example.elasticsearchtest.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    Page<Employee> findAll(Pageable pageable);

}
