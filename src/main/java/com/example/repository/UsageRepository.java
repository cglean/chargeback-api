package com.example.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Usage;

public interface UsageRepository extends CrudRepository<Usage, Serializable>{

}
