package br.com.umc.biotalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.umc.biotalk.model.EnvironmentalEducationPublish;

@Repository("environmentalEducationPublishRepository")
public interface EnvironmentalEducationPublishRepository extends JpaRepository<EnvironmentalEducationPublish, Long>, CrudRepository<EnvironmentalEducationPublish, Long>{

}
