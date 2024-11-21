package DAO;

import model.Posiljka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosiljkaDAO extends JpaRepository<Posiljka,Integer> {

}
