package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
