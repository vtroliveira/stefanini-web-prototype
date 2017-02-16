package br.com.stefanini.progress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.progress.model.Project;

@Repository("projectRepository")
public interface ProjectRepository extends JpaRepository<Project, Long> {
//	Project findById(int id);
}
