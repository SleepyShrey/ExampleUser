package br.com.darchanjo.examples.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UsersNoPassWordDTO {
    private String name;

    private String email;

    private List<ProductEntity> productEntity;
}
