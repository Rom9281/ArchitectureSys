package com.sp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.sp.model.Card;
import com.sp.model.User;

public interface CardRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByName(String name);
	public Optional<Card> findById(Integer id);
	public Iterable<Card> findAll();
}
