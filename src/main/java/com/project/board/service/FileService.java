package com.project.board.service;

import com.project.board.config.RestTemplateClient;
import com.project.board.model.response.FileListModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FileService {
    @Value("http://dev.file.com/api/v1/files")
    private String apiServer;

    @Autowired
    private RestTemplateClient restTemplateClient;

    public void uploadFile(Integer boardId, MultipartFile[] files) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();


        try {
            for(MultipartFile file:files) {
                log.info("file name : "+file.getOriginalFilename());
                body.add("files", new ByteArrayResource(file.getBytes()){
                    @Override
                    public String getFilename() {
                        return file.getOriginalFilename();
                    }
                });
            }

            HttpEntity<MultiValueMap<String, Object> > requestEntity = new HttpEntity<>(body, headers);

            log.info("uploadFile : "+boardId);
            restTemplateClient.postForLocation(apiServer+"?boardId="+boardId, requestEntity);
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
