package com.bbm.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbm.entity.Specimen;
import com.bbm.repo.SpecimenRepository;

@Service
public class SpecimenServiceImpl implements SpecimenService{
	
	@Autowired
	SpecimenRepository bbmSpecimenRepository;

	@Override
	public Specimen addSpecimen(Specimen bbmSpecimen) {
		return bbmSpecimenRepository.save(bbmSpecimen);
	}

	@Override
	public Specimen findSpecimentByOID(Long OID)
	{
		return bbmSpecimenRepository.findByOID(OID);
	}

	@Override
	public List<Specimen> getAllSpecimen()
	{
		return (List<Specimen>)bbmSpecimenRepository.findAll();
	}

	@Override
	public Specimen updateSpecimen(Specimen oSpecimen,Long lSpecimenOID) {
		try{
			
			Specimen bbmspeci = bbmSpecimenRepository.findById(lSpecimenOID).get();
			
		//Unit Received Update
		if (Objects.nonNull(oSpecimen.getUNITSRECEIVED())) {
			bbmspeci.setUNITSRECEIVED(oSpecimen.getUNITSRECEIVED());
		}
		// Blodd Group Update
		if (Objects.nonNull(oSpecimen.getBLOODGROUP()) && !"".equalsIgnoreCase(oSpecimen.getBLOODGROUP())) {
			bbmspeci.setBLOODGROUP(oSpecimen.getBLOODGROUP());
		}
		// Expiry Date Update
		if (Objects.nonNull(oSpecimen.getEXPIRYDATE())) {
			bbmspeci.setEXPIRYDATE(oSpecimen.getEXPIRYDATE());
		}
		//RH Factor Update
		if (Objects.nonNull(oSpecimen.getRHFACTOR()) && !"".equalsIgnoreCase(oSpecimen.getRHFACTOR())) {
			bbmspeci.setRHFACTOR(oSpecimen.getRHFACTOR());
		}
		//Status Update
		if (Objects.nonNull(oSpecimen.getSTATUS()) && !"".equalsIgnoreCase(oSpecimen.getSTATUS())) {
			bbmspeci.setSTATUS(oSpecimen.getSTATUS());
		}
		//Comments Update
		if (Objects.nonNull(oSpecimen.getCOMMENTS()) && !"".equalsIgnoreCase(oSpecimen.getCOMMENTS())) {
			bbmspeci.setCOMMENTS(oSpecimen.getCOMMENTS());
		}
		//Performed by Update
		if (Objects.nonNull(oSpecimen.getPERFORMEDBY())) {
			bbmspeci.setPERFORMEDBY(oSpecimen.getPERFORMEDBY());
		}
		
		return bbmSpecimenRepository.save(bbmspeci);
		}
		catch(Exception ex)
		{
			System.out.println("outside"+ex.getStackTrace());
			return null;
		}
		
	}
}
