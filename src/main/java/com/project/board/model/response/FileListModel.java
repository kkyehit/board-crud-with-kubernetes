package com.project.board.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class FileListModel {
    private Integer boardId;
    private String originFileName;
    private Timestamp uploadTime;
}
