package com.hieupm.code_bhyt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doi_tuong_bhyt")
public class DoiTuongBHYT {
    @Id
    private String code;
    @Column
    private String name;
    @Column
    private String content;

    @OneToMany(mappedBy = "doiTuongBHYT")
    private Set<User> cac_doi_tuong = new HashSet<>();
}
