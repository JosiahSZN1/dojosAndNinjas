package com.codingdojo.dojosandninjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
}
