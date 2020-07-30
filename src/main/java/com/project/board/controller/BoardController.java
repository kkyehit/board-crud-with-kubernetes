package com.project.board.controller;

import com.project.board.model.BoardModel;
import com.project.board.model.request.AddBoardModel;
import com.project.board.model.request.DeleteBoardModel;
import com.project.board.model.request.UpdateBoardModel;
import com.project.board.model.response.PreviewBoardModel;
import com.project.board.service.BoardService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class BoardController {

    @Autowired
    BoardService boardService;

    //게시판 작성
    @ApiOperation(value = "게시글 추가")
    @RequestMapping(value = "/boards", method = RequestMethod.POST)
    public void addBoard(
            @ApiParam(name = "게시글 추가 JSON", value = " 새로운 글을 추가합니다.", required = true)
            @RequestBody AddBoardModel addBoardModel){
        boardService.addBoard(addBoardModel);
        log.info("addBoard()");
    }

    //게시판 목록 요청
    @ApiOperation(value = "게시글 목록 요청")
    @RequestMapping(value = "/boards", method = RequestMethod.GET)
    @ApiImplicitParam(name = "pageNum", value = "페이지 단위로 게시글 목록을 반환합니다.", dataType = "Integer", required = true)
    public List<PreviewBoardModel> getBoardList(
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum){
        log.info("getBoardList()");
        return boardService.getBoards(pageNum);
    }

    //게시판 내용 요청
    @ApiOperation(value = "게시글 내용 요청")
    @RequestMapping(value = "/boards/{boardId}", method = RequestMethod.GET)
    @ApiImplicitParam(name = "boardId", value = "게시글 ID에 따른 게시글 정보를 반환합니다.", dataType = "Integer", required = true)
    public BoardModel getBoard(
            @PathVariable("boardId") int boardId) throws Exception {
        log.info("getBoard");
        return boardService.getBoard(boardId);
    }

    //게시판 수정
    @ApiOperation(value = "게시글 수정")
    @RequestMapping(value = "/boards", method = RequestMethod.PUT)
    public void updateBoard(
            @ApiParam(name = "게시글 수정 JSON", value = "게시글 ID에 해당하는 글의 내용을 수정합니다.", required = true)
            @RequestBody UpdateBoardModel updateBoardModel) throws Exception {
        boardService.updateBoard(updateBoardModel);
        log.info("updateBoard");
    }

    //게시판 삭제
    @ApiOperation(value = "게시글 삭제")
    @RequestMapping(value = "/boards", method = RequestMethod.DELETE)
    public void deleteBoard(
            @ApiParam(name = "게시글 삭제 JSON", value = "게시글 ID에 해당하는 글을 삭제합니다.", required = true)
            @RequestBody DeleteBoardModel deleteBoardModel) throws Exception {
        boardService.deleteBoard(deleteBoardModel);
        log.info("deleteBoard");
    }
/*
    //test method
    @ApiOperation(value = "테스트 입니다.")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "test";
    }
*/
/*
    //Global Exception
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exceptionHandler(Exception e, WebRequest request){
        log.info("BAD_REQUEST");
        return new ResponseEntity<Object>("",new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
*/
    //Global Exception
    @ExceptionHandler(value = {EntityNotFoundException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<Object> noContentExceptionHandler(Exception e, WebRequest request){
        log.info("NO_CONTENT");
        return new ResponseEntity<Object>("",new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}