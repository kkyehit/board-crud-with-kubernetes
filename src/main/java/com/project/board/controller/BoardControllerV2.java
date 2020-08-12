package com.project.board.controller;

import com.project.board.model.BoardModel;
import com.project.board.model.request.AddBoardModel;
import com.project.board.model.request.DeleteBoardModel;
import com.project.board.model.request.UpdateBoardModel;
import com.project.board.model.response.PreviewBoardModel;
import com.project.board.model.response.ResponseBoardModel;
import com.project.board.service.BoardService;
import com.project.board.service.FileService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v2")
@Slf4j
public class BoardControllerV2 {

    @Autowired
    BoardService boardService;

    @Autowired
    FileService fileService;

    @Autowired
    BoardController boardController;
    
    //게시판 작성
    @ApiOperation(value = "게시글과 첨부 파일 추가")
    @RequestMapping(value = "/boards", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "첨부파일", required = false),
            @ApiImplicitParam(name = "author_name", required = true),
            @ApiImplicitParam(name = "title", required = true)
    })
    public void addBoardWithFile(
            AddBoardModel addBoardModel, @RequestParam("files") MultipartFile[] files){
        log.info("v2/addBoard");
        fileService.uploadFile(boardController.addBoard(addBoardModel), files);
    }

    //게시판 내용 요청
    @ApiOperation(value = "게시글 내용과 첨부파일 목록 요청")
    @RequestMapping(value = "/boards/{boardId}", method = RequestMethod.GET)
    @ApiImplicitParam(name = "boardId", value = "게시글 ID에 따른 게시글 정보와 첨부파일 목록을 반환합니다.", dataType = "Integer", required = true)
    public ResponseBoardModel getBoard(
            @PathVariable("boardId") int boardId) throws Exception {
        log.info("v2/getBoard");
        BoardModel boardModel = boardService.getBoard(boardId);
        return ResponseBoardModel.builder()
                .author_name(boardModel.getAuthor_name())
                .board_id(boardModel.getBoard_id())
                .content(boardModel.getContent())
                .title(boardModel.getTitle())
                .createdAt(boardModel.getCreatedAt())
                .fileList(fileService.getFileList(boardId))
                .build();
    }

    //게시판 삭제
    @ApiOperation(value = "게시글과 첨부파일 삭제")
    @RequestMapping(value = "/boards", method = RequestMethod.GET)
    public void deleteBoard(@ApiParam(name = "게시글 삭제 JSON", value = "게시글 ID에 해당하는 글과 첨부파일을 삭제합니다.", required = true)
                                @RequestBody DeleteBoardModel deleteBoardModel) throws Exception {
        log.info("v2/deleteBoard");
        boardService.deleteBoard(deleteBoardModel);
        fileService.deleteFile(deleteBoardModel.getBoard_id());
    }

    //Global Exception
    @ExceptionHandler(value = {EntityNotFoundException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<Object> noContentExceptionHandler(Exception e, WebRequest request){
        log.info("v2/NO_CONTENT");
        return new ResponseEntity<Object>("",new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}