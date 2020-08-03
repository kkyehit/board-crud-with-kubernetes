package com.project.board.service;

import com.project.board.model.BoardModel;
import com.project.board.model.request.AddBoardModel;
import com.project.board.model.request.DeleteBoardModel;
import com.project.board.model.request.UpdateBoardModel;
import com.project.board.model.response.PreviewBoardModel;
import com.project.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private static int PAGE_SIZE = 5;

    @Autowired
    private BoardRepository boardRepository;

    public void addBoard(AddBoardModel addBoardModel){
        BoardModel boardModel = BoardModel.builder()
                .title(addBoardModel.getTitle())
                .content(addBoardModel.getContent())
                .author_name(addBoardModel.getAuthor_name())
                .createdAt(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("+9"))))
                .build();
        boardRepository.save(boardModel);
    }

    public BoardModel getBoard(int boardId) throws EntityNotFoundException {
        Optional<BoardModel> opt = boardRepository.findById(boardId);
        return opt.orElseThrow(()-> new EntityNotFoundException());
    }

    public List<PreviewBoardModel> getBoards(int pageNum){
        List<PreviewBoardModel> previewList = new ArrayList<>();
        List<BoardModel> boardList = new ArrayList<>();

        Page<BoardModel> boardPage = boardRepository
                .findAll(PageRequest.of(pageNum, PAGE_SIZE, Sort.by("createdAt").descending()));
        if(boardPage != null && boardPage.hasContent()){
            boardList = boardPage.getContent();
        }

        for(BoardModel boardModel: boardList){
            PreviewBoardModel previewBoardModel = PreviewBoardModel.builder()
                    .board_id(boardModel.getBoard_id())
                    .title(boardModel.getTitle())
                    .author_name(boardModel.getAuthor_name())
                    .createdAt(boardModel.getCreatedAt())
                    .build();
            previewList.add(previewBoardModel);
        }

        return previewList;
    }

    public void updateBoard(UpdateBoardModel updateBoardModel) throws EntityNotFoundException {
        BoardModel boardModel
                = boardRepository.findById(updateBoardModel.getBoard_id()).orElseThrow(()->new EntityNotFoundException());
        boardModel.setAuthor_name(updateBoardModel.getAuthor_name());
        boardModel.setContent(updateBoardModel.getContent());
        boardModel.setTitle(updateBoardModel.getTitle());
        boardModel.setCreatedAt(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("+9"))));
        boardRepository.save(boardModel);
    }

    public void deleteBoard(DeleteBoardModel deleteBoardModel) throws EmptyResultDataAccessException {
        boardRepository.deleteById(deleteBoardModel.getBoard_id());
    }
}
