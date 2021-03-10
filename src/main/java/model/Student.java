package model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String image;
    @Transient
    private MultipartFile avatar;
    @ManyToOne
    private Classess classess;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public Classess getClassess() {
        return classess;
    }

    public void setClassess(Classess classess) {
        this.classess = classess;
    }

    public Student(Long id, String name,String address, String image, MultipartFile avatar, Classess classess) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
        this.avatar = avatar;
        this.classess = classess;
    }
    public Student(String name,String address, MultipartFile avatar, Classess classess) {
        this.name = name;
        this.address = address;
        this.avatar = avatar;
        this.classess = classess;
    }
    public Student(String name,String address, String image, Classess classess) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.classess = classess;
    }
}
