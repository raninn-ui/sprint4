package com.ranine.applications.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ranine.applications.dto.ApplicationDTO;
import com.ranine.applications.entities.Application;
import com.ranine.applications.entities.Editeur;
import com.ranine.applications.repos.AppRepository;
import com.ranine.applications.repos.EditeurRepository;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	AppRepository appRepository;
	
	@Autowired
	EditeurRepository editRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ApplicationDTO saveApp(ApplicationDTO a) {
		return convertEntityToDto(appRepository.save(convertDtoToEntity(a)));
	}

	@Override
	public ApplicationDTO updateApp(ApplicationDTO a) {
		return convertEntityToDto(appRepository.save(convertDtoToEntity(a)));
	}

	@Override
	public void deleteApp(Application a) {
		appRepository.delete(a);
		
	}

	@Override
	public void deleteAppById(Long id) {
		appRepository.deleteById(id);
		
	}

	@Override
	public ApplicationDTO getApp(Long id) {
		return convertEntityToDto(appRepository.findById(id).get());
	}

	@Override
	public List<ApplicationDTO> getAllApps() {
		return appRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
		
		/*List<Application> apps = appRepository.findAll();
		List<ApplicationDTO> listappDto = new ArrayList<>(apps.size());
		for (Application a : apps)
		listappDto.add(convertEntityToDto(a));
		return listappDto;*/
	}

	@Override
	public Page<Application> getAllAppsParPage(int page, int size) {
		return appRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Application> findByNomApp(String nom) {
		return appRepository.findByNomApp(nom);
	}

	@Override
	public List<Application> findByNomAppContains(String nom) {
		return appRepository.findByNomAppContains(nom);
	}

	@Override
	public List<Application> findByNomNbtl(String nom, Double nbtl) {
		return appRepository.findByNomNbtl(nom,nbtl);
	}

	@Override
	public List<Application> findByEditeur(Editeur editeur) {
		return appRepository.findByEditeur(editeur);
	}

	@Override
	public List<Application> findByEditeurIdEdit(Long id) {
		return appRepository.findByEditeurIdEdit(id);
	}

	@Override
	public List<Application> findByOrderByNomAppAsc() {
		return appRepository.findByOrderByNomAppAsc();
	}

	@Override
	public List<Application> trierApplicationsNomsNbtl() {
		return appRepository.trierApplicationsNomsNbtl();
	}

	@Override
	public List<Editeur> getAllEditeurs() {
		return editRepository.findAll();
	}

	@Override
	public ApplicationDTO convertEntityToDto(Application a) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ApplicationDTO applicationDTO = modelMapper.map(a, ApplicationDTO.class);
		 return applicationDTO;
		
		/*ApplicationDTO applicationDTO = new ApplicationDTO();
		
		applicationDTO.setIdApp(a.getIdApp());
		applicationDTO.setNomApp(a.getNomApp());
		applicationDTO.setNbtl(a.getNbtl());
		applicationDTO.setReleasedate(a.getReleasedate());
		applicationDTO.setEditeur(a.getEditeur());

		return applicationDTO;*/
		
		/*return ApplicationDTO.builder()
				.idApp(a.getIdApp())
				.nomApp(a.getNomApp())
				.nbtl(a.getNbtl())
				.releasedate(a.getReleasedate())
				//.nomEdit(a.getEditeur().getNomEdit())
				.editeur(a.getEditeur())
				.build();*/
	}

	@Override
	public Application convertDtoToEntity(ApplicationDTO applicationDTO) {
		/*Application application = new Application();
		application.setIdApp(applicationDTO.getIdApp());
		application.setNomApp(applicationDTO.getNomApp());
		application.setNbtl(applicationDTO.getNbtl());
		application.setReleasedate(applicationDTO.getReleasedate());
		application.setEditeur(applicationDTO.getEditeur());
		 return application;*/
		
		Application application = new Application();
		application= modelMapper.map(applicationDTO, Application.class);
		return application;
	}

}
