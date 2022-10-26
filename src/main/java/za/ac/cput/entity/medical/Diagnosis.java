/*
Diagnosis.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 07 April 2022
 */

package za.ac.cput.entity.medical;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="diagnosis")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString


public class Diagnosis {

    private Long diagnosisId;
    private String diagnosisName;
    private String diagnosisType;
    private LocalDate diagnosisDate;

    private Diagnosis(Diagnosis.Builder builder) {
        this.diagnosisId = builder.diagnosisId;
        this.diagnosisName = builder.diagnosisName;
        this.diagnosisType = builder.diagnosisType;
        this.diagnosisDate = builder.diagnosisDate;

    }

    @Id
    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public String getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(String diagnosisType) {
        this.diagnosisType = diagnosisType;
    }

    public LocalDate getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDate(LocalDate diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisId=" + diagnosisId +
                ", diagnosisName=" + diagnosisName +
                ", diagnosisType=" + diagnosisType +
                ", date='" + diagnosisDate + '\'' +
                '}';
    }

    public static class Builder {
        private Long diagnosisId;
        private String diagnosisName;
        private String diagnosisType;
        private LocalDate diagnosisDate;


        public Diagnosis.Builder diagnosisId(Long diagnosisId) {
            this.diagnosisId = diagnosisId;
            return this;
        }

        public Diagnosis.Builder diagnosisName(String diagnosisName) {
            this.diagnosisName = diagnosisName;
            return this;
        }

        public Diagnosis.Builder diagnosisType(String diagnosisType) {
            this.diagnosisType = diagnosisType;
            return this;
        }

        public Diagnosis.Builder date(LocalDate diagnosisDate) {
            this.diagnosisDate = diagnosisDate;
            return this;
        }


        public Diagnosis.Builder copy(Diagnosis diagnosis) {
            this.diagnosisId = diagnosis.diagnosisId;
            this.diagnosisName = diagnosis.diagnosisName;
            this.diagnosisType = diagnosis.diagnosisType;
            this.diagnosisDate = diagnosis.diagnosisDate;

            return this;
        }

        public Diagnosis build() {
            return new Diagnosis(this);
        }
    }
}


