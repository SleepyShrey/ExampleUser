package br.com.darchanjo.examples.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntityDTO {

    private String name;

    private String description;

    private int count;
}
