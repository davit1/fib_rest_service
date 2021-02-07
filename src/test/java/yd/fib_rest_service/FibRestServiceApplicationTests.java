package yd.fib_rest_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class FibRestServiceApplicationTests {

    @Autowired
    private MockMvc mvc;
    private Object String;

    @Test
    public void getFib10() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fibonacci/10")).andExpect(status().isOk())
                .andExpect(content().string(equalTo("55")));
    }

    @Test
    public void getFib13() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fibonacci/13")).andExpect(status().isOk())
                .andExpect(content().string(equalTo("233")));
    }

    @Test
    public void getFib58() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fibonacci/58")).andExpect(status().isOk())
                .andExpect(content().string(equalTo("591286729879")));
    }

    @Test
    public void getFib137() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fibonacci/137")).andExpect(status().isOk())
                .andExpect(content().string(equalTo("19134702400093278081449423917")));
    }

    @Test
    public void getNegativeFib() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fibonacci/-5")).andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("In the path fibonacci/{n}, n must be greater than zero.")));
    }

    @Test
    public void getFibOfNotNumber() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fibonacci/x")).andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("In the path fibonacci/{n}, n must be a number of type int/long between 0 and 9,223,372,036,854,775,807")));
    }

    @Test
    public void getFibOfNonWholeNumber() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fibonacci/1.5")).andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("In the path fibonacci/{n}, n must be a number of type int/long between 0 and 9,223,372,036,854,775,807")));
    }

}
