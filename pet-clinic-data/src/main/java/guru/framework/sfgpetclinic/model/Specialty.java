package guru.framework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity{

    @Column(name = "description")
    private String description;

    public String getDiscription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
