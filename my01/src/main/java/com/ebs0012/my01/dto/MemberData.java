package com.ebs0012.my01.dto;

import java.time.LocalDate;

public class MemberData {
    private String name;
    private LocalDate birthDate;

    public MemberData(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
