package ExceptionHandling;

public class User {
    private String username;
    private String password;
    private int orderCnt;

    User(String username, String pass, int orderCnt){
        this.username = username;
        this.password = pass;
        this.orderCnt = 5;
    }

    void setOrderCnt(String uname, String pass, int orderCnt){
        if(uname.equals(this.username) && pass.equals(this.password)){
            this.orderCnt = orderCnt;
        }
    }

    public int getOrderCnt(String uname, String pass) throws CredentialException{
        if(uname.equals(this.username) && pass.equals(this.password)){
            return orderCnt;
        }
        else {
            throw new CredentialException(String.format("Exception = Credentials not valid : {user=%s, pass=%s}",uname,pass));
        }
    }
}
