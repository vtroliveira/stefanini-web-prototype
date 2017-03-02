package br.com.stefanini.progress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.progress.model.Profile;

@Repository("profileRepository")
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
//	Profile findById(int id);
}
