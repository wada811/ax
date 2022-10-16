import com.wada811.adx.${VARIABLE_NAME}.lint.${NAME}Detector
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class ${NAME}DetectorTest : DetectorTest(
    ${NAME}Detector.ISSUE,
    listOf(
        kotlinFile("src/main/java/${NAME}.kt")
    )
)
