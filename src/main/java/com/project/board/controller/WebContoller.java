package com.project.board.controller;

import com.project.board.model.request.AddBoardModel;
import com.project.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/web")
public class WebContoller {
    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index.html";
    }

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public String insertBoard(@ModelAttribute AddBoardModel addBoardModel){
        boardService.addBoard(addBoardModel);
        return "redirect:/web/";
    }
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String getBoardPage(Model model){
        model.addAttribute("addBoardModel", new AddBoardModel());
        return "boardInsertPage.html";
    }
    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.GET)
    public String getBoard(Model model, @PathVariable("boardId") Integer boardId){
        model.addAttribute("board", boardService.getBoard(boardId));
        return "boardPage.html";
    }
    @RequestMapping(value = "/boards", method = RequestMethod.GET)
    public String getBoardPages(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum){
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("boards", boardService.getBoards(pageNum));
        return "boardListPage.html";
    }
}
