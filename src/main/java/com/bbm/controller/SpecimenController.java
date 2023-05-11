package com.bbm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbm.entity.Procedure;
import com.bbm.entity.Specimen;
import com.bbm.repo.SpecimenRepository;
import com.bbm.service.SpecimenService;
import java.util.*;

@RestController
public class SpecimenController {
	@Autowired
	SpecimenService bbmService;
	
	@Autowired
	SpecimenRepository bbmSpecimenRepository;
	
	@GetMapping("/welcome")
	public String helloAppln() {
		return "Hi Blood Bank Management";
	}
	
	@PostMapping("/specimen")	
	public Specimen addSpecimen(@RequestBody Specimen bbmSpecimen) {
		return bbmService.addSpecimen(bbmSpecimen);
	}

	@GetMapping("/specimen/{OID}")
	public Specimen getSpecimenByOID(@PathVariable Long OID)
	{
		return bbmService.findSpecimentByOID(OID);
	}

	@GetMapping("/specimen")
	public List<Specimen> getSpecimen()
	{
		return bbmService.getAllSpecimen();
	}

	// Update operation
    @PutMapping("/specimen/{oid}")
    public Specimen updateSpecimen(@RequestBody Specimen bbmSpecimen,
                     @PathVariable("oid") Long oid)
    {
		System.out.println("******OID"+oid);
          return bbmService.updateSpecimen(bbmSpecimen,oid);
    }
    //Delete Specimen
	@DeleteMapping("/deletespecimen/{OID}")
	public void deleteSpecimen(@PathVariable("OID") Long OID){
		Specimen deletespec = bbmSpecimenRepository.findByOID(OID);
		deletespec.setSTATUS("D");
		bbmSpecimenRepository.save(deletespec);
}
}
