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
@Table(name="chi_tiet_co_quan_bhxh")
public class ChiTietCoQuanBHXH {
    @Id
    private String code;
    @Column(name = "quan_huyen")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_dia_phuong")
    private CoQuanBHXH fkCtCoQuanBHXH;

    @OneToMany(mappedBy = "chiTietCoQuanBHXH")
    private Set<User> users = new HashSet<>();


}
