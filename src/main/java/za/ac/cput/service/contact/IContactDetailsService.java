/*
CustomerDetails.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: October 2022
 IContactDetailsService .java{

 */
package za.ac.cput.service.contact;
import za.ac.cput.entity.contact.ContactDetails;
import za.ac.cput.service.IService;

public interface IContactDetailsService extends IService<ContactDetails, Long>  {
    boolean existsById(Long id);
}
