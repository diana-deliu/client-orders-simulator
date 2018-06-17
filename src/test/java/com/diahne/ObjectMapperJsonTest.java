package com.diahne;

import com.diahne.controller.StoreController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectMapperJsonTest {

    @Test
    public void testReadJsonWithObjectMapper() throws Exception {
        StoreController stc = new StoreController();
        //stc.readJsonWithObjectMapper();
    }
}
