/*
CustomerDetails.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: October 2022
IDiagnosisService.java{

 */

package za.ac.cput.service.medical;
import za.ac.cput.entity.medical.Diagnosis;
import za.ac.cput.service.IService;

public interface IDiagnosisService extends IService<Diagnosis, Long>  {
        boolean existsById(Long id);

}
