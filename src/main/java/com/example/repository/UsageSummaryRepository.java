package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UsageSummary;

public interface UsageSummaryRepository extends JpaRepository<UsageSummary, Serializable>{

}
