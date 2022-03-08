package hibernate_ManyToMany.entity;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String firstname;
    @Column(name = "age")
    private int age;



    @ManyToMany
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sections;

    public void addSection(Section section){
        if(section==null){
            sections= new ArrayList<>();
        }
            sections.add(section);
    }

    public Child() {
    }

    public Child(String firstname, int age) {
        this.firstname = firstname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                '}';
    }
}
