package dtos;

import entities.Guide;

import java.util.Objects;

public class GuideDTO {
    private String name;
    private String gender;
    private String ugay;


    public GuideDTO(Guide guide) {
        this.name = guide.getName();
        this.gender = guide.getGender();
        this.ugay = guide.getUgay();
    }

    public GuideDTO(String name, String gender, String ugay) {
        this.name = name;
        this.gender = gender;
        this.ugay = ugay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuideDTO guideDTO = (GuideDTO) o;
        return Objects.equals(name, guideDTO.name) && Objects.equals(gender, guideDTO.gender) && Objects.equals(ugay, guideDTO.ugay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, ugay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUgay() {
        return ugay;
    }

    public void setUgay(String ugay) {
        this.ugay = ugay;
    }
}
