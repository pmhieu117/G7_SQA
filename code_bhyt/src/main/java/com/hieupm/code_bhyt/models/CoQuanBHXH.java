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
@Table(name = "co_quan_bhxh")
public class CoQuanBHXH {
    @Id
    private String code;
    @Column(name = "dia_phuong")
    private String name;

    @OneToMany(mappedBy = "fkCtCoQuanBHXH")
    private Set<ChiTietCoQuanBHXH> chiTietCoQuanBHXHS = new HashSet<>();

    @OneToMany(mappedBy = "coQuanBHXH")
    private Set<User> userSet;
}
