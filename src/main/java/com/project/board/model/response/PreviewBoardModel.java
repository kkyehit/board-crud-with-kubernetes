package com.project.board.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@ApiModel(value = "게시글 목록 모델",description = "게시글 ID와 제목, 글쓴이, 작성 시간을 반환합니다.")
public class PreviewBoardModel {
    @ApiModelProperty(value = "게시글 ID")
    int board_id;
    @ApiModelProperty(value = "게시글 제목")
    String title;
    @ApiModelProperty(value = "게시자")
    String author_name;
    @ApiModelProperty(value = "작성 시간")
    Timestamp createdAt;
}
