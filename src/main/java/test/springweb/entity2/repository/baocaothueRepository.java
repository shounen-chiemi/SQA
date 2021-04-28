package test.springweb.entity2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.springweb.entity2.*;

import java.util.List;

public interface baocaothueRepository extends JpaRepository<baocaothue,Integer> {
    @Query(value = "select * from baocaothue", nativeQuery = true)
    Page<baocaothue> getDsBaocaothue(Pageable pageable);

    @Query(value = "select baocaothue.* from baocaothue,thuetncn,chitietthuesuat where baocaothue.chitietthuesuatid = chitietthuesuat.id and chitietthuesuat.thuetncnid = thuetncn.id and thuetncn.id=?1", nativeQuery = true)
    Page<baocaothue> getDsBaocaothueTheoIdThueTNCN(Pageable pageable,int id);

    @Query(value = "select * from baocaothue,thuetncn,chitietthuesuat where baocaothue.chitietthuesuatid = chitietthuesuat.id and chitietthuesuat.thuetncnid = thuetncn.id and thuetncn.id=?1", nativeQuery = true)
    List<baocaothue> getDsBaocaothueTheoIdThueTNCN(int id);

    @Query(value = "select * from baocaothue", nativeQuery = true)
    List<baocaothue> getDsBaocaothue();

}
