package com.users.users.users.domain.model;

public class UserModel {

    private String identityDocument;
    private String name;
    private String email;

    public UserModel() {
    }

    public UserModel(String identityDocument, String name, String email) {
        this.identityDocument = identityDocument;
        this.name = name;
        this.email = email;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
