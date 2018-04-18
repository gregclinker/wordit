package com.greg.wordit;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void match1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/crepitus").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().string(
				equalTo("[{\"text\":\"crepitus\",\"matches\":[\"cuprites\",\"pictures\",\"piecrust\"]}]")));
	}

	@Test
	public void match2() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/crepitus,paste,kinship,enlist,boaster,fresher,sinks,knits,sort")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(
						"[{\"text\":\"crepitus\",\"matches\":[\"cuprites\",\"pictures\",\"piecrust\"]},{\"text\":\"paste\",\"matches\":[\"pates\",\"peats\",\"septa\",\"spate\",\"tapes\",\"tepas\"]},{\"text\":\"kinship\",\"matches\":[\"pinkish\"]},{\"text\":\"enlist\",\"matches\":[\"elints\",\"inlets\",\"listen\",\"silent\",\"tinsel\"]},{\"text\":\"boaster\",\"matches\":[\"boaters\",\"borates\",\"rebatos\",\"sorbate\"]},{\"text\":\"fresher\",\"matches\":[\"refresh\"]},{\"text\":\"sinks\",\"matches\":[\"skins\"]},{\"text\":\"knits\",\"matches\":[\"skint\",\"stink\",\"tinks\"]},{\"text\":\"sort\",\"matches\":[\"orts\",\"rots\",\"stor\",\"tors\"]}]")));
	}

	@Test
	public void match3() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sdfwehrtgegfg").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"text\":\"sdfwehrtgegfg\",\"matches\":[]}]")));
	}
}
