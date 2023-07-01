package sg.iss.day23.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.iss.day23.model.Video;

@Repository
public class VideoRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private String findAllVideoSQL = "select * from video";

    private String insertVideoSQL = "insert into video (title, synopsis, available_count) values (?, ?, ?)";

    private String updateVideoSQL = "update video set title = ?, synopsis = ?, available_count = ? where id = ?";

    public List<Video> findAll() {
        return jdbcTemplate.query(findAllVideoSQL, 
            BeanPropertyRowMapper.newInstance(Video.class));
    }

    public int updateVideo(Video video) {
        Integer result = jdbcTemplate.update(updateVideoSQL, video.getTitle(), video.getSynopsis(), 
            video.getAvailableCount(), video.getId());
        return result;
    }

    public int insertVideo(Video video) {
        Integer result = jdbcTemplate.update(insertVideoSQL, 
        video.getTitle(), video.getSynopsis(), video.getAvailableCount());
        return result;
    }
}
