package com.project.board;

import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class BoardApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	void addBoard() throws Exception{
		int entityNum = 10;
		for(int i = 0 ; i < entityNum; i++) {
			mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/boards")    	//요청경로 설정
					.content("{\n" +                                            		//body 작성
							"  \"author_name\": \"string\",\n" +
							"  \"content\": \"string\",\n" +
							"  \"title\": \"string\"\n" +
							"}")
					.contentType(MediaType.APPLICATION_JSON)                    		//header 명시
					.accept(MediaType.APPLICATION_JSON))                        		//header 명시
					.andExpect(MockMvcResultMatchers.status().isOk())              		//예상되는 응답상태
					.andDo(MockMvcResultHandlers.print());                        	    //받은 내용 출력
		}
	}

	@Test
	@Order(2)
	void getList() throws Exception{
		getList(0);
		getList(1);
		getList(2);
	}
	void getList(int pageNum) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/boards?pageNum="+pageNum))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(3)
	void getBoard() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/boards/1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(4)
	void updateBoard() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/boards/")
					.content("{\n" +
							"  \"board_id\": \"1\",\n" +
							"  \"content\": \"changed\",\n" +
							"  \"title\": \"changed\"\n" +
							"}")
					.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(5)
	void getBoardAfterUpdated() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/boards/1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(6)
	void deleteBoard() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/boards")
					.content("{\"board_id\": \"2\"}")
					.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	@Test
	@Order(7)
	void getBoardAfterDelete() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/boards/1"))
				.andExpect(MockMvcResultMatchers.status().isNoContent())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(8)
	void deleteNoData() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/boards")
				.content("{\"board_id\": \"2\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNoContent())
				.andDo(MockMvcResultHandlers.print());
	}
}
