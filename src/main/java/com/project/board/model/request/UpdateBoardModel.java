package com.project.board.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@ApiModel(value = "게시글 수정 모델",description = "게시글 ID와 제목, 내용을 입력받아 수정합니다.")
public class UpdateBoardModel {
    @ApiModelProperty(value = "게시글 ID")
    int board_id;
    @ApiModelProperty(value = "게시글 제목")
    String title;
    @ApiModelProperty(value = "게시글 내용")
    String content;
    @ApiModelProperty(value = "게시자")
    String author_name;
}
