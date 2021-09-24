package com.geekseat.theta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseModel {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 256)
    private String email;

    @NotNull
    @NotEmpty
    @JsonIgnore
    private String password;

    @NotNull
    private Boolean active = true;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @JsonIgnore
    @Type(type = "text")
    protected String attachmentListData;

    @Transient
    protected List<String> attachmentList = new ArrayList<>();

}
