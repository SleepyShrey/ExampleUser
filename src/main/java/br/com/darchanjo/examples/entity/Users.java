package br.com.darchanjo.examples.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private long userId;

    @Column(name = "User_Name")
    private String name;

    @Column(name = "User_Email")
    private String email;

    @Column(name = "User_Password")
    private String password;

    @ManyToMany(mappedBy = "user")
    private List<ProductEntity> productEntity;

    @CreationTimestamp
    private Date date;

}
