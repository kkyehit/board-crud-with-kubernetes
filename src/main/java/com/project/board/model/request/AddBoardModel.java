package com.project.board.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "게시글 추가 모델",description = "제목, 내용, 글쓴이를 입력합니다.")
public class AddBoardModel {
    @ApiModelProperty(value = "게시글 제목")
    String title;
    @ApiModelProperty(value = "게시글 내용")
    String content;
    @ApiModelProperty(value = "게시자")
    String author_name;
}
