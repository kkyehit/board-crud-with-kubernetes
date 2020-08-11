package com.project.board.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
public class ResponseBoardModel {
    List<FileListModel> fileList;
    int board_id;
    Timestamp createdAt;
    String title;
    String content;
    String author_name;
}
