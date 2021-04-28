package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.khoangiamtru;
import test.springweb.entity2.repository.khoangiamtruRepository;

import java.util.List;

@Service
public class khoangiamtruService {
    @Autowired
    khoangiamtruRepository kgtR;

    public List<khoangiamtru> getDskhoanggiamtru(int id)
    {
        List<khoangiamtru> ds = kgtR.getKhoangiamtruTheoID(id);
        return ds;
    }
}
