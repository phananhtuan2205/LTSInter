package com.example.intern_BE.Repo;

import com.example.intern_BE.Entity.Decentralization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecentralizationRepository extends JpaRepository<Decentralization, Integer> {
}