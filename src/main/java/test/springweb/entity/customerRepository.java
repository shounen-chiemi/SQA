package test.springweb.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<customer, Integer> {
    @Query("select u from customer u where u.name = ?1")
    public customer getcustomerBy(String name);
    @Query("select u from customer u where u.id = ?1")
    public customer getcustomerById(int id);


}
