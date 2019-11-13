package guru.framework.sfgpetclinic.model;

public class Specialty extends BaseEntity{

    private String description;

    public String getDiscription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
