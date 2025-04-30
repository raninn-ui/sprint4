package com.ranine.applications.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ranine.applications.dto.ApplicationDTO;
import com.ranine.applications.entities.Application;
import com.ranine.applications.services.AppService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApplicationRESTController {
	
	@Autowired
	AppService appService;

	@RequestMapping(method = RequestMethod.GET)
	public List<ApplicationDTO> getAllApps(){
		return appService.getAllApps();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ApplicationDTO getApplicayionById(@PathVariable("id") Long id) {
		return appService.getApp(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ApplicationDTO createApp(@RequestBody ApplicationDTO applicationDTO) {
	return appService.saveApp(applicationDTO);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ApplicationDTO updateApp(@RequestBody ApplicationDTO applicationDTO) {
	return appService.updateApp(applicationDTO);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteApp(@PathVariable("id") Long id)
	{
		appService.deleteAppById(id);
	}

	@RequestMapping(value="/appsedit/{idEdit}",method = RequestMethod.GET)
	public List<Application> getAppsByEditId(@PathVariable("idEdit") Long idEdit) {
	return appService.findByEditeurIdEdit(idEdit);
	}
}
