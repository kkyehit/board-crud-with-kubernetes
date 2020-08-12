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
@ApiModel(value = "첨부파일 정보 모델",description = "첨부된 게시글의 ID와 원본 파일 이름, 작성 시간을 반환합니다.")
public class FileListModel {
    @ApiModelProperty(value = "게시글 ID")
    private Integer boardId;
    @ApiModelProperty(value = "원본 파일 이름")
    private String originFileName;
    @ApiModelProperty(value = "작성 시간")
    private Timestamp uploadTime;
}
