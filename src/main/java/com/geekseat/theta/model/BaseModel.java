package com.geekseat.theta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @CreatedBy
    private String createdBy;

    @JsonIgnore
    @LastModifiedBy
    private String updatedBy;

    @JsonIgnore
    @CreatedDate
    private LocalDateTime created;

    @JsonIgnore
    @LastModifiedDate
    private LocalDateTime updated;

    @JsonIgnore
    @Type(type = "text")
    protected String creator;

    @JsonIgnore
    @Type(type = "text")
    protected String editor;

    @JsonIgnore
    @Type(type = "text")
    protected String mapData;

    @Transient
    protected Map<String, Object> map = new HashMap<>();

    @Transient
    protected Map<String, Object> transitMap = new HashMap<>();

}
