/*
CustomerDetails.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 07 October 2022
 */

package za.ac.cput.controller.medical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.medical.Diagnosis;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.medical.Impl.DiagnosisServiceImpl;
import java.util.List;
@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController
{
    private final DiagnosisServiceImpl diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisServiceImpl diagnosisService)
    {
        this.diagnosisService=diagnosisService;
    }

    @GetMapping
    public ResponseEntity<List<Diagnosis>> getDiagnosis() {
        List<Diagnosis> diagnosis = diagnosisService.findAll();
        return ResponseEntity.ok(diagnosis);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getContactDetailsById(@PathVariable final Long id) {
        String notFoundMessage = getNotFoundMessage(id);
        Diagnosis diagnosis = diagnosisService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(diagnosis);
    }
    @PostMapping
    public ResponseEntity<Diagnosis> addContactDetails(@RequestBody final Diagnosis diagnosis) {
        Diagnosis saveDiagnosis = diagnosisService.save(diagnosis);
        return new ResponseEntity<>(saveDiagnosis, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Diagnosis> updateContactDetailsById(@PathVariable final Long id,
                                                                   @RequestBody final Diagnosis diagnosis) {
        String notFoundMessage = getNotFoundMessage(id);
        Diagnosis updateDiagnosis = diagnosisService.update(id,diagnosis)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(updateDiagnosis);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContactDetailsById(@PathVariable final Long id) {
        if (!diagnosisService.existsById(id)) {
            String notFoundMessage = getNotFoundMessage(id);
            throw new ResourceNotFoundException(notFoundMessage);
        }
        diagnosisService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Diagnosis with id: %s not found";
        return String.format(messageNotFound, id);
    }

}
