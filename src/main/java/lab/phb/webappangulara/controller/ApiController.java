package lab.phb.webappangulara.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import lab.phb.webappangulara.entity.Mahasiswa;
import lab.phb.webappangulara.repo.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ApiController {

	@Autowired
	private MahasiswaRepo mahasiswaRepo;
	
	@RequestMapping("/ambil-data")
	public Map<String, Object> getData() {
		Map<String, Object> result = new HashMap();
		result.put("nama", "tamami");
		
		return result;	
	}


	// -- untuk aplikasi mahasiswa
	@RequestMapping("/list-mahasiswa")
	public List<Mahasiswa> getListMhs() {
		return mahasiswaRepo.findAll();
	}

	@RequestMapping(value = "/tambah-data", 
		method = RequestMethod.POST)
	public void tambahData(@RequestBody Mahasiswa mhs) {
		//System.out.println("nim : " + mhs.getNim());
		//System.out.println("nama : " + mhs.getNama());
		//System.out.println("jurusan : " + mhs.getJurusan());
		mahasiswaRepo.save(mhs);
	}

	@RequestMapping("/ambil-data-mhs/{nim}")
	public Mahasiswa getDataMhs(@PathVariable("nim") String nim) {
		//System.out.println("nim : " + nim);
		return mahasiswaRepo.findOneByNim(nim);
	}

	@RequestMapping(value = "/hapus-data/{nim}",
			method = RequestMethod.DELETE)
	public void hapusData(@PathVariable("nim") String nim) {
		mahasiswaRepo.delete(nim);
	}

}