public class userProfile {
    private String userName; // user name

    private String info;  // not sure what info yet


    public userProfile(String userName, String info)
    {
        userName = userName;
        info= info;
    } // end constructor
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName() {return userName;}
    public void setInfo(String info){
        this.info = info;
    }
    public String getInfo(){return info;}




    public void addProfile(){}
    public int removeProfile(){
        return 0;
    }




}
