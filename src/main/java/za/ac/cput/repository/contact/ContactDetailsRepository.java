/*
ContactDetailsRepository.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date:September 2022
 */

package za.ac.cput.repository.contact;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.contact.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails,Long>
{

}
