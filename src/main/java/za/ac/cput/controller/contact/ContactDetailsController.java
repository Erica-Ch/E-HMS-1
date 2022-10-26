/*
CustomerDetails.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 06 October 2022
 */


package za.ac.cput.controller.contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.contact.ContactDetails;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.contact.Impl.ContactDetailsServiceImpl;

import java.util.List;
@RestController
@RequestMapping("/api/contactdetails")
public class ContactDetailsController
{
    private final ContactDetailsServiceImpl contactDetailsService;

    @Autowired
    public ContactDetailsController(ContactDetailsServiceImpl contactDetailsService)
    {
        this.contactDetailsService=contactDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<ContactDetails>> getContactDetails() {
        List<ContactDetails> contactdetails = contactDetailsService.findAll();
        return ResponseEntity.ok(contactdetails);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getContactDetailsById(@PathVariable final Long id) {
        String notFoundMessage = getNotFoundMessage(id);
        ContactDetails contactdetails = contactDetailsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(contactdetails);
    }
    @PostMapping
    public ResponseEntity<ContactDetails> addContactDetails(@RequestBody final ContactDetails contactdetails) {
        ContactDetails saveContactDetails= contactDetailsService.save(contactdetails);
        return new ResponseEntity<>(saveContactDetails, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactDetails> updateContactDetailsById(@PathVariable final Long id,
                                                             @RequestBody final ContactDetails contactdetails) {
        String notFoundMessage = getNotFoundMessage(id);
        ContactDetails updateContactDetails = contactDetailsService.update(id, contactdetails)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(updateContactDetails);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContactDetailsById(@PathVariable final Long id) {
        if (!contactDetailsService.existsById(id)) {
            String notFoundMessage = getNotFoundMessage(id);
            throw new ResourceNotFoundException(notFoundMessage);
        }
        contactDetailsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "ContactDetails with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
