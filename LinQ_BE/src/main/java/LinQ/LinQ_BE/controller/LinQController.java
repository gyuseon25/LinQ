package LinQ.LinQ_BE.controller;

import LinQ.LinQ_BE.dto.ResponseDto;
import LinQ.LinQ_BE.entity.BoardEntity;
import LinQ.LinQ_BE.entity.PopularSearchEntity;
import LinQ.LinQ_BE.service.LinQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/LinQ")
public class LinQController {

    @Autowired
    LinQService linQService;

    @GetMapping("/top3")
    public ResponseDto<List<BoardEntity>> getTop3() {
        return linQService.getTop3();
    }

    @GetMapping("/list")
    public ResponseDto<List<BoardEntity>> getList() {
        return linQService.getList();
    }

    @GetMapping("/popularsearchList")
    public ResponseDto<List<PopularSearchEntity>> getPopularsearchList() {
        return linQService.getPopularsearchList();
    }

    @GetMapping("/search/{boardTitle}")
    public ResponseDto<List<BoardEntity>> getSearchList(@PathVariable("boardTitle") String title) {
        return null;
    }
}
