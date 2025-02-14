package br.com.darchanjo.examples.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UnderLegalHold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long underLegalHoldId;

    @OneToOne
    private Users user;

    private boolean underLegal;
}
