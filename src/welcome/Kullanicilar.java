package welcome;


public class Kullanicilar {
    private int id;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String mail;

    public Kullanicilar(int id, String name, String surname, String country, String city, String mail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
