package com.project.board.controller;

import com.project.board.model.BoardModel;
import com.project.board.model.request.AddBoardModel;
import com.project.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping(value = "/web")
public class WebController {
    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        //log.debug("called index");
        System.out.println("called index return String");
        return "index";
    }

   @RequestMapping(value = "/boards", method = RequestMethod.GET)
    public ModelAndView board(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {
       //log.debug("called index");
       System.out.println("GET /web/boards");
       //model and view
       ModelAndView model = new ModelAndView("boardListPage");
       model.addObject("boards",boardService.getBoards(pageNum));
       return model;
   }
   @RequestMapping(value = "/new/boards", method = RequestMethod.GET)
    public ModelAndView newBoard() {
        //log.debug("called index");
        System.out.println("GET /web/new/boards");
        //model and view
        ModelAndView model = new ModelAndView("boardInsertPage");
        return model;
    }
    @RequestMapping(value = "/boards", method = RequestMethod.POST)
    public ModelAndView insertBoard(AddBoardModel addboardModel) {
        //log.debug("called index");
        System.out.println("POST /web/boards");
        boardService.addBoard(addboardModel);
        return board(0);
    }
    @RequestMapping(value = "/boards/{boardId}", method = RequestMethod.GET)
    public ModelAndView getBoard(@PathVariable("boardId") Integer boardId) {
        //log.debug("called index");
        System.out.println("GET /web/boards/"+boardId);
        ModelAndView model = new ModelAndView("boardContentsPage");
        model.addObject("board",boardService.getBoard(boardId));
        return model;
    }
}
