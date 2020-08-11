package com.project.board.model.request;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteFileModel {
    private Integer boardId;
    private String originFileName;
    private Timestamp uploadTime;
}
