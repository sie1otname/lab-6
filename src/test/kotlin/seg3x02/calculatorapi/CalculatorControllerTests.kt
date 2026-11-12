package seg3x02.calculatorapi

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTests(@Autowired val mockMvc: MockMvc) {

    @Test
    fun add() {
        mockMvc.perform(get("/calculator/add/5/3")).andExpect(status().isOk).andExpect(content().string("8.0"))
    }

    @Test
    fun subtract() {
        mockMvc.perform(get("/calculator/subtract/5/3")).andExpect(status().isOk).andExpect(content().string("2.0"))
    }

    @Test
    fun multiply() {
        mockMvc.perform(get("/calculator/multiply/2.5/4")).andExpect(status().isOk).andExpect(content().string("10.0"))
    }

    @Test
    fun divide() {
        mockMvc.perform(get("/calculator/divide/7/2")).andExpect(status().isOk).andExpect(content().string("3.5"))
    }

    @Test
    fun divideByZeroReturns400() {
        mockMvc.perform(get("/calculator/divide/7/0")).andExpect(status().isBadRequest)
    }

    @Test
    fun invalidNumberReturns400() {
        mockMvc.perform(get("/calculator/add/abc/3")).andExpect(status().isBadRequest)
    }

    @Test
    fun openApiDocumentationIsGenerated() {
        mockMvc.perform(get("/v3/api-docs")).andExpect(status().isOk)
            .andExpect(jsonPath("$.paths['/calculator/divide/{nombre1}/{nombre2}']").exists())
    }
}
