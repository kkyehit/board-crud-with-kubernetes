package com.project.board.model.response;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "게시글 정보와 첨부파일 목록 모델",description = "게시글 ID와 제목, 글쓴이, 작성 시간및 첨부 파일 목록을 반환합니다.")
public class ResponseBoardModel {
    @ApiModelProperty(value = "파일 목록")
    List<FileListModel> fileList;
    @ApiModelProperty(value = "게시글 ID")
    int board_id;
    @ApiModelProperty(value = "작성 시간")
    Timestamp createdAt;
    @ApiModelProperty(value = "제목")
    String title;
    @ApiModelProperty(value = "내용")
    String content;
    @ApiModelProperty(value = "작성자")
    String author_name;
}
