package entity;


public class PersonName {

    private String namePerson;
    private Long id;
    private AdersPerson adersPerson;

    public AdersPerson getAdersPerson() {
        return adersPerson;
    }

    public void setAdersPerson(AdersPerson adersPerson) {
        this.adersPerson = adersPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    @Override
    public String toString() {
        return "namePerson:  " + namePerson + " adress " + adersPerson.getCity();
    }
}
