package coding.adhoc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.IOException


class JsonParsingTest {

    data class Foo(
        val id: Int,
        val name: String,
    )

    @Test
    @Throws(IOException::class)
    fun whenSerializeAndDeserializeUsingJackson_thenCorrect() {
        val foo = Foo(1, "first")
        val mapper = jacksonObjectMapper()
        val json = mapper.writeValueAsString(foo)
        val result = mapper.readValue(json, Foo::class.java)
        assertThat(result).isEqualTo(foo)
    }


}