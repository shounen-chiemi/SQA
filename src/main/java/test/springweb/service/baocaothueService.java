package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.springweb.dto.baocaothueDTO;
import test.springweb.entity2.baocaothue;
import test.springweb.entity2.chitietthuesuat;
import test.springweb.entity2.khoangiamtru;
import test.springweb.entity2.repository.baocaothueRepository;
import test.springweb.entity2.repository.chitietthuesuatRepository;
import test.springweb.entity2.repository.thuetncnRepository;
import test.springweb.entity2.thuetncn;

import java.util.ArrayList;
import java.util.List;
@Service
public class baocaothueService {
   @Autowired
   baocaothueRepository bctR;
   @Autowired
   khoangiamtruService kgS;
   @Autowired
   thuetncnRepository thueR;
   @Autowired
   chitietthuesuatRepository chitietR;

    public Page<baocaothue> getDs(Pageable pageable)
    {
        Page<baocaothue> page = bctR.getDsBaocaothue(pageable);
        return page;
    }

    public List<baocaothueDTO> getdsbaocaothueTheoID(Pageable pageable,int idThueTNCN)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothueTheoIdThueTNCN(pageable,idThueTNCN);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
//            float thue = i.getTnct();
//            i.setList_khoangiamtru(kgS.getDskhoanggiamtru(i.getId()));
//            for(khoangiamtru j : i.getList_khoangiamtru())
//            {
//                float mucgiamtru = j.getMucgiamtru();
//                if(j.getTenmucgiamtru().equals("giảm trừ với mỗi người phụ thuộc"))
//                {
//                    mucgiamtru = (float)i.getSonguoiphuthuoc()*mucgiamtru;
//                }
//                thue = (float)(thue - mucgiamtru);
//            }
//            thue = (float)(thue*(i.getChitietthuesuat().getThuesuat()/100));
//            if(thue<0) thue=0;
            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);
            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }


    public List<baocaothueDTO> getdsbaocaothue(Pageable pageable)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothue(pageable);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
//            float thue = i.getTnct();
//            i.setList_khoangiamtru(kgS.getDskhoanggiamtru(i.getId()));
//            for(khoangiamtru j : i.getList_khoangiamtru())
//            {
//                float mucgiamtru = j.getMucgiamtru();
//                if(j.getTenmucgiamtru().equals("giảm trừ với mỗi người phụ thuộc"))
//                {
//                    mucgiamtru = (float)i.getSonguoiphuthuoc()*mucgiamtru;
//                }
//                thue = (float)(thue - mucgiamtru);
//            }
//            thue = (float)(thue*(i.getChitietthuesuat().getThuesuat()/100));
//            if(thue<0) thue=0;
            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);
            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }

    public List<baocaothueDTO> getdsbaocaothue(Pageable pageable,int IDThueTNCN)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothue(pageable);
        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            if(i.getChitietthuesuat().getThuetncn().getId()==IDThueTNCN)
            {
                baocaothueDTO baocaothueDTO = new baocaothueDTO();
                baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
                baocaothueDTO.setLoaithue(i.getLoaithue());
                baocaothueDTO.setId(i.getId());
                baocaothueDTO.setNgaynop(i.getNgaynop());
                baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
                baocaothueDTO.setTnct(i.getTnct());
                baocaothueDTO.setTinhtrang(i.getTinhtrang());
                baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
                baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
                int thue = tinhTiennop(i);
                baocaothueDTO.setTongtien((int) thue);
                dsbc.add(baocaothueDTO);
            }
        }
        return dsbc;
    }

    public int tinhTiennop(baocaothue b)
    {
        int tong = 0;
        float thue = b.getTnct();
        b.setList_khoangiamtru(kgS.getDskhoanggiamtru(b.getId()));
        for(khoangiamtru j : b.getList_khoangiamtru())
        {
            float mucgiamtru = j.getMucgiamtru();
            if(j.getTenmucgiamtru().equals("giảm trừ với mỗi người phụ thuộc"))
            {
                mucgiamtru = (float)b.getSonguoiphuthuoc()*mucgiamtru;
            }
            thue = (float)(thue - mucgiamtru);
        }
        thue = (float)(thue*(b.getChitietthuesuat().getThuesuat()/100));
        if(thue<0) thue=0;
        tong = (int)thue;
        return tong;
    }

    public List<baocaothue> getDsBaocaothueTheoIDThueTNCN(int idThueTNCN)
    {
        List<baocaothue> ds = null;
        thuetncn thuetncn = thueR.getthuetncnTheoID(idThueTNCN);
        List<chitietthuesuat> dschitiet = chitietR.getDschitietthuesuatTheoIDThueTNCN(idThueTNCN);




        return ds;
    }

}
