package com.project.board.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "게시글 삭제 모델",description = "게시글의 ID를 입력받아 해당 게시글을 삭제합니다.")
public class DeleteBoardModel {
    @ApiModelProperty(value = "게시글 ID")
    int board_id;
}
