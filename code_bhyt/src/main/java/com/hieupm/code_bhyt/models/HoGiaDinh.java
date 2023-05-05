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
@Table(name = "ho_gia_dinh")
public class HoGiaDinh {
    @Id
    private String code;
    @Column
    private String dia_chi;

    @OneToOne
    @JoinColumn(name = "id_chu_ho", referencedColumnName = "id")
    private User chuHo;

    @OneToMany(mappedBy ="hoGiaDinh")
    private Set<User> thanh_vien = new HashSet<>();
}
