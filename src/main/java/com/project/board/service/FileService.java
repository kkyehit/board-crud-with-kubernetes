package com.project.board.service;

import com.project.board.config.RestTemplateClient;
import com.project.board.model.response.FileListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    @Value("http://file-cluster-ip:8100/api/v1/files")
    private String apiServer;

    @Autowired
    private RestTemplateClient restTemplateClient;

    public void uploadFile(Integer boardId, MultipartFile[] files){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        for(MultipartFile file: files) {
            body.add("files", file);
        }

        HttpEntity<MultiValueMap<String, Object> > requestEntity = new HttpEntity<>(body, headers);

        try {
            restTemplateClient.postForEntity(apiServer+"?boardId="+boardId, requestEntity, String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<FileListModel> getFileList(Integer boardId){
        try {
            return restTemplateClient.getForObject(apiServer + "/" + boardId, List.class);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
}
