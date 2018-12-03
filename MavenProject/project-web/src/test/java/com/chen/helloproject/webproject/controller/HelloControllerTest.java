package com.chen.helloproject.webproject.controller;



import com.chen.helloproject.domainproject.domain.Industry;
import com.chen.helloproject.serviceproject.service.IndustryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;



import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class HelloControllerTest {


    @Autowired
    private HelloController controller;


    private MockMvc mockMvc;

    @Before
    public void setup(){
        // 初始化数据
        this.mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void industryTest() throws Exception {
        String url = "/industry?id=1";

        Industry industry = new Industry();

        industry.setIndustryid(1);
        industry.setIndustryname("IT");
        industry.setParentid(0);

        MvcResult result = this.mockMvc.perform(post(url)).andExpect(status().isOk()).andDo(print()).andReturn();

        ModelAndView modelAndView = result.getModelAndView();

        assertEquals("hello",modelAndView.getViewName());
        assertEquals(industry.getIndustryid(),modelAndView.getModel().get("industryid"));
        assertEquals(industry.getIndustryname(),modelAndView.getModel().get("industryname"));
        assertEquals(industry.getParentid(),modelAndView.getModel().get("parentid"));
    }


}