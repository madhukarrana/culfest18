package jamshedpur.nit.culfest.com.culfest17.Widget;

/**
 * Created by skshubhamiitkmr on 31-12-2017.
 */

public class SingleItemModel {


    private String name;
    private int a;
    private String description;
    private String email;
    private String phone;
    private String post;

    public SingleItemModel() {
    }

    public SingleItemModel(String name, int a,String email,String phone,String post) {
        this.name = name;
        this.a=a;
        this.email=email;
        this.phone=phone;
        this.post=post;
    }


    public int getImages() {
        return a;
    }

    public void setImages(int a) {
        this.a= a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}