package com.project.board.service;

import com.project.board.config.RestTemplateClient;
import com.project.board.model.response.FileListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    @Value("http://file-cluster-ip:8100/api/v1/files")
    private String apiServer;

    @Autowired
    private RestTemplateClient restTemplateClient;

    public List<FileListModel> getFileList(Integer boardId){
        try {
            return restTemplateClient.getForObject(apiServer + "/" + boardId, List.class);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
}
