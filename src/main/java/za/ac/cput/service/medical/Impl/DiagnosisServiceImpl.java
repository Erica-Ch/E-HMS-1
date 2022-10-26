package za.ac.cput.service.medical.Impl;


import za.ac.cput.service.medical.IDiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.medical.Diagnosis;
import za.ac.cput.factory.medical.DiagnosisFactory;
import za.ac.cput.repository.medical.DiagnosisRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
public class DiagnosisServiceImpl implements IDiagnosisService
{
    private final DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }
    @Override
    public Diagnosis save(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public Optional<Diagnosis> update(Long id, Diagnosis newDiagnosis) {
        return findById(id).map(diagnosis -> {
            String diagnosisName = newDiagnosis.getDiagnosisName();
            String diagnosisType = newDiagnosis.getDiagnosisType();
            LocalDate diagnosisDate = newDiagnosis.getDiagnosisDate();
            diagnosis = DiagnosisFactory.createDiagnosis(id, diagnosisName, diagnosisType,diagnosisDate);
            return save(diagnosis);
        });
    }

    @Override
    public List<Diagnosis> findAll() {
        return diagnosisRepository.findAll();
    }

    @Override
    public Optional<Diagnosis> findById(Long id) {
        return diagnosisRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        diagnosisRepository.deleteById(id);
    }


    @Override
    public boolean existsById(Long id) {
        return diagnosisRepository.existsById(id);
    }
}

