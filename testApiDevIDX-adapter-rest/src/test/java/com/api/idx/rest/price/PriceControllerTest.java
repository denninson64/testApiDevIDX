package com.api.idx.rest.price;

import com.api.idx.rest.constant.ApiParams;
import com.api.idx.rest.constant.ApiPaths;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    private static final String BRAND_ID = "1";

    private static final String PRODUCT_ID = "35455";

    private static final String DATE_1 = "2020-06-14T10:00:00Z";

    private static final String DATE_2 = "2020-06-14T16:00:00Z";

    private static final String DATE_3 = "2020-06-14T21:00:00Z";

    private static final String DATE_4 = "2020-06-15T10:00:00Z";

    private static final String DATE_5 = "2020-06-16T21:00:00Z";

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("findByBrandIdAndProductIdAndDateCases")
    public void findByBrandIdAndProductIdAndDateTest(String date, String expectedJsonName) throws Exception {
        String expectedJson = IOUtils.resourceToString(expectedJsonName, StandardCharsets.UTF_8);
        this.mockMvc.perform(get(ApiPaths.Price.BASE)
                        .param(ApiParams.Price.BRAND_ID, BRAND_ID)
                        .param(ApiParams.Price.PRODUCT_ID, PRODUCT_ID)
                        .param(ApiParams.Price.DATE, date))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    private static Stream<Arguments> findByBrandIdAndProductIdAndDateCases() {
        return Stream.of(
                Arguments.of(DATE_1, "/responseToTest1.json"),
                Arguments.of(DATE_2, "/responseToTest2.json"),
                Arguments.of(DATE_3, "/responseToTest3.json"),
                Arguments.of(DATE_4, "/responseToTest4.json"),
                Arguments.of(DATE_5, "/responseToTest5.json")
        );
    }
}
