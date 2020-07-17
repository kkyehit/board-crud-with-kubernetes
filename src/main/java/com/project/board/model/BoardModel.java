package com.project.board.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "boards_tb")
@ApiModel(value = "게시글 모델",description = "게시글 ID와 작성 시간, 제목, 내용, 글쓴이 정보를 포함합니다.")
public class BoardModel {
    @Id
    @ApiModelProperty(value = "게시글 ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int board_id;
    @Column
    @ApiModelProperty(value = "작성 시간")
    Timestamp createdAt;
    @Column
    @ApiModelProperty(value = "게시글 제목")
    String title;
    @Column
    @ApiModelProperty(value = "게시글 내용")
    String content;
    @Column
    @ApiModelProperty(value = "게시자")
    String author_name;
}
