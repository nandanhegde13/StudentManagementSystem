public class Login {
    private String email;
    private String password;

    public Login(String email,String password){
        setEmail(email);
        setpassword(password);
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setpassword(String password){
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
