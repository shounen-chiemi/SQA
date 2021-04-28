package test.springweb.entity;

import javax.persistence.*;


public class thanhvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String taikhoan;
    @Column
    private String matkhau;
    @Column
    private String chucvu;

    public Long getId() {
        return id;
    }
}
