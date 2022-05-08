public class Registration {
    private String name;
    private String email;
    private String phone;
    private String password;

    public Registration(String name, String email, String phone,String password){
        setName(name);
        setEmail(email);
        setPhone(phone);
        setPassword(password);

    }

    private void setName(String name){
        this.name = name;
    }

    private void setEmail(String email){
        this.email = email;
    }
    private void setPhone(String phone){
        this.phone = phone;
    }
    private void setPassword(String password){
        this.password = password;
    }


    String getName(){
        return this.name;
    }

    String getEmail(){
        return this.email;
    }

    String getPhone(){
        return this.phone;
    }

    String getPassword(){
        return this.password;
    }
}
