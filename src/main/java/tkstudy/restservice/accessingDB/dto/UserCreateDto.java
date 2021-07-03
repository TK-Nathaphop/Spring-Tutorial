package tkstudy.restservice.accessingDB.dto;

public class UserCreateDto {
    private String name;
    private String email;

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }
}
