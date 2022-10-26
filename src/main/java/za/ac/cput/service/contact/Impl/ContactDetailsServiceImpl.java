/*
CustomerDetails.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: October 2022
ContactDetailsServiceImpl.java{

 */

package za.ac.cput.service.contact.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.contact.ContactDetails;
import za.ac.cput.factory.contact.ContactDetailsFactory;
import za.ac.cput.repository.contact.ContactDetailsRepository;
import za.ac.cput.service.contact.IContactDetailsService;

import java.util.List;
import java.util.Optional;


public class ContactDetailsServiceImpl implements IContactDetailsService
{
    private final ContactDetailsRepository contactdetailsRepository;

    @Autowired
    public ContactDetailsServiceImpl(ContactDetailsRepository contactdetailsRepository) {
        this.contactdetailsRepository = contactdetailsRepository;
    }
    @Override
    public ContactDetails save(ContactDetails contactdetails) {
        return contactdetailsRepository.save(contactdetails);
    }

    @Override
    public Optional<ContactDetails> update(Long id, ContactDetails newContactDetails) {
        return findById(id).map(contactdetails -> {
            String phoneNumber = newContactDetails.getPhoneNumber();
            contactdetails = ContactDetailsFactory.createContactDetails(id,phoneNumber);
            return save(contactdetails);
        });
    }

    @Override
    public List<ContactDetails> findAll() {
        return contactdetailsRepository.findAll();
    }

    @Override
    public Optional<ContactDetails> findById(Long id) {
        return contactdetailsRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        contactdetailsRepository.deleteById(id);
    }


    @Override
    public boolean existsById(Long id) {
        return contactdetailsRepository.existsById(id);
    }
}
