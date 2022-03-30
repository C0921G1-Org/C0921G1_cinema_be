package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.FilmType;
import C0921G1_sprint_1.repository.film_management.FilmTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Hung NM tạo để lấy list type film
@Service
public class FilmTypeServiceImpl implements FilmTypeService{
    @Autowired
    FilmTypeRepository filmTypeRepository;

    //HungNM lấy danh sách thể loại phim để đổ lên màn hình tìm kiếm tại trang chủ
    @Override
    public List<FilmType> getAll() {
        return filmTypeRepository.getAll();
    }
}
