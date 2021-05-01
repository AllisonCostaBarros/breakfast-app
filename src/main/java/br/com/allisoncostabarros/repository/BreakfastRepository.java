package br.com.allisoncostabarros.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.allisoncostabarros.model.Breakfast;

public interface BreakfastRepository extends CrudRepository<Breakfast, String> {
	Breakfast findById (long id);
}
