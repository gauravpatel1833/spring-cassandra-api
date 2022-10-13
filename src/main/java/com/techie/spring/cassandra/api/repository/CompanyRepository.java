package com.techie.spring.cassandra.api.repository;

import com.techie.spring.cassandra.api.model.Company;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CassandraRepository<Company,String> {

    @AllowFiltering
    public Company findByCompanyName(String companyName);
}
