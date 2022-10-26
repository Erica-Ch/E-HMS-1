/*
CustomerDetails.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 06 April 2022
Modified: September 2022
 */

package za.ac.cput.entity.contact;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name ="contactdetails")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class ContactDetails {

    private Long contactId;
    private String phoneNumber;

    public ContactDetails(Builder builder) {
        this.contactId = builder.contactId;
        this.phoneNumber = builder.phoneNumber;

    }

    @Id
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "ContactDetails{" +
                "contactId=" + contactId +
                ", phoneNumber=" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder {
        private Long contactId;
        private String phoneNumber;


        public ContactDetails.Builder contactId(Long contactId) {
            this.contactId = contactId;
            return this;
        }

        public ContactDetails.Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }


        public Builder copy(ContactDetails contact) {
            this.contactId = contact.contactId;
            this.phoneNumber = contact.phoneNumber;

            return this;
        }

        public ContactDetails build() {
            return new ContactDetails(this);
        }
    }
}
