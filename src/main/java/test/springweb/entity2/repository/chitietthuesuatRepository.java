package test.springweb.entity2.repository;
import org.springframework.data.jpa.repository.Query;
import test.springweb.entity2.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface chitietthuesuatRepository extends JpaRepository<chitietthuesuat,Integer> {
//    @Query("select * from chitietthuesuat where chitietthuesuat .thuetncnid = ?1")
//    public ArrayList<chitietthuesuat> getDsthuesuattheoId(int id);
    @Query(value = "select * from chitietthuesuat u where u.ThueTNCNID = ?1", nativeQuery = true)
    public ArrayList<chitietthuesuat> getDschitietthuesuatTheoIDThueTNCN(int id);
}
