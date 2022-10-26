/*
DiagnosisRepository.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: September 2022
 */


package za.ac.cput.repository.medical;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.medical.Diagnosis;


public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long>
{


}
