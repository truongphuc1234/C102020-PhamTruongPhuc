package spring.furama.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "education_degree")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private int educationDegreeId;

    @Column(name = "education_degree_name", unique = true,nullable = false)
    private String educationDegreeName;

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
