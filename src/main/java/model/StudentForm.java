package model;

import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
    private Long id;
    private String name;
    private String address;
    private MultipartFile image;
    private Classess classess;

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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Classess getClassess() {
        return classess;
    }

    public void setClassess(Classess classess) {
        this.classess = classess;
    }

    public StudentForm() {
    }

    public StudentForm(String name, String address, MultipartFile image, Classess classess) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.classess = classess;
    }
}
