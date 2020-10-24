package HomeWork23;

import lombok.*;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {

    private Integer studentId;
    private String fullName;
    private Integer admissionYear;
    private Integer groupId;

}
