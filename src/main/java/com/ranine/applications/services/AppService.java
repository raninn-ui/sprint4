package com.ranine.applications.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ranine.applications.dto.ApplicationDTO;
import com.ranine.applications.entities.Application;
import com.ranine.applications.entities.Editeur;

public interface AppService {
	
	ApplicationDTO saveApp(ApplicationDTO a);
	ApplicationDTO getApp(Long id);
	List<ApplicationDTO> getAllApps();
	
	ApplicationDTO updateApp(ApplicationDTO a);
	void deleteApp(Application a);
	void deleteAppById(Long id);
	
	
	
	Page<Application> getAllAppsParPage(int page, int size);
	List<Application> findByNomApp(String nom);
	List<Application> findByNomAppContains(String nom);
	List<Application> findByNomNbtl (String nom, Double nbtl);
	List<Application> findByEditeur (Editeur editeur);
	List<Application> findByEditeurIdEdit (Long id);
	List<Application> findByOrderByNomAppAsc();
	List<Application> trierApplicationsNomsNbtl ();
	List<Editeur> getAllEditeurs();
	
	ApplicationDTO convertEntityToDto (Application a);
	
	Application convertDtoToEntity(ApplicationDTO applicationDTO);
}
