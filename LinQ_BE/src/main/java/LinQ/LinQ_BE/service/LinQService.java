package LinQ.LinQ_BE.service;

import LinQ.LinQ_BE.dto.ResponseDto;
import LinQ.LinQ_BE.entity.BoardEntity;
import LinQ.LinQ_BE.entity.PopularSearchEntity;
import LinQ.LinQ_BE.repository.BoardRepository;
import LinQ.LinQ_BE.repository.PopularSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LinQService {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    PopularSearchRepository popularSearchRepository;

    public ResponseDto<List<BoardEntity>> getTop3() {
        List<BoardEntity> boardList = new ArrayList<>();
        Date date = Date.from(Instant.now().minus(7, ChronoUnit.DAYS));

        try {
            boardRepository.findTop3ByBoardWriteDateAfterOrderByBoardLikesCountDesc(date);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed("Database Error");
        }

        return ResponseDto.setSuccess("Success", boardList);
    }

    public ResponseDto<List<BoardEntity>> getList() {
        List<BoardEntity> boardList = new ArrayList<>();

        try {
            boardList = boardRepository.findByOrderByBoardWriteDateDesc();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed("Database Error");
        }

        return ResponseDto.setSuccess("Success", boardList);
    }

    public ResponseDto<List<PopularSearchEntity>> getPopularsearchList() {

        List<PopularSearchEntity> popularSearchList = new ArrayList<>();

        try {
            popularSearchList = popularSearchRepository.findTop10ByOrderByPopularSearchCountDesc();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed("Database Error");
        }

        return ResponseDto.setSuccess("Success", popularSearchList);
    }

    public ResponseDto<List<BoardEntity>> getSearchList(String boardTitle) {
        List<BoardEntity> boardList = new ArrayList<>();
        try {
            boardList = boardRepository.findByBoardTitleContains(boardTitle);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed("Database Error");
        }
        return ResponseDto.setSuccess("Success", boardList);
    }
}
