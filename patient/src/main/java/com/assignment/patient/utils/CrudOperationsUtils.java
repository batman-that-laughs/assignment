package com.assignment.patient.utils;

import com.assignment.patient.exceptions.DataNotFoundException;
import com.assignment.patient.exceptions.NoDataPresentException;
import com.assignment.patient.repositories.PatientRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/*
    * class to use dozer bean mapping to convert objects
 */

@Component
public class CrudOperationsUtils {

    private DozerBeanMapper beanMapper;

    @Autowired
    private PatientRepository patientRepository;

    public <T> T map(Object from, Class<T> toClass) {
        beanMapper = new DozerBeanMapper();
        return this.beanMapper.map(from, toClass);
    }

    public <F,T> List<T> mapList(List<F> fromList, final Class<T> toClass) {
        beanMapper = new DozerBeanMapper();
        return fromList.stream().map(from -> this.beanMapper.map(from, toClass)).collect(Collectors.toList());
    }

    public void checkIfAnyDataIsPresent() throws NoDataPresentException {
        if(patientRepository.anyDataExists() == 0)
            throw new NoDataPresentException("No data present in patient table", null);
    }

    public void checkIfParticularDataIsPresent(Integer id) throws DataNotFoundException {
        if(!patientRepository.existsById(id))
            throw new DataNotFoundException("Data for patient id " + id + " not found.", null);

    }

}
