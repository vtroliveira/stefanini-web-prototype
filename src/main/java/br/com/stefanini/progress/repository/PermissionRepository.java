package br.com.stefanini.progress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.progress.model.Permission;

@Repository("permissionRepository")
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
	Permission findByPermission(String permission);
}
