package lab.phb.webappangulara.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import lab.phb.webappangulara.entity.Mahasiswa;


@Repository
public interface MahasiswaRepo 
        extends JpaRepository<Mahasiswa, String> {

   Mahasiswa findOneByNim(String nim);
	
}