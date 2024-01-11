package com.api.idx.component.price.application;

import com.api.idx.component.price.port.PriceFindUseCase;
import com.api.idx.component.price.port.PriceRepository;
import com.api.idx.sharedkernel.exception.ClientCausedRuntimeException;
import com.api.idx.util.TestConstants;
import com.api.idx.util.TestMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

@ExtendWith(MockitoExtension.class)
public class PriceFindUseCaseImplTest {
    @Mock
    private PriceRepository priceRepository;

    private PriceFindUseCase priceFindUseCase;

    @BeforeEach
    public void setup() {
        PriceFindUseCaseImpl priceFindUseCaseImpl = new PriceFindUseCaseImpl();
        priceFindUseCaseImpl.setPriceRepository(this.priceRepository);

        this.priceFindUseCase = priceFindUseCaseImpl;
    }

    @ParameterizedTest(name = TestMessages.TEST_NAME)
    @MethodSource("findByBrandIdAndProductIdAndDateParameterValidationFailCases")
    public void findByBrandIdAndProductIdAndDateParameterValidationFailTest(String testName, Integer brandId, Integer productId, Instant date) {
        assertThatExceptionOfType(ClientCausedRuntimeException.class)
                .as(TestMessages.INVALID_PARAMS_EXPECTED)
                .isThrownBy(() -> this.priceFindUseCase.findByBrandIdAndProductIdAndDate(brandId, productId, date));
    }

    private static Stream<Arguments> findByBrandIdAndProductIdAndDateParameterValidationFailCases() {
        return Stream.of(
                Arguments.of("The parameter 'brandId' is null", null, TestConstants.INTEGER_ID, TestConstants.INSTANT_VALUE),
                Arguments.of("The parameter 'productId' is null", TestConstants.INTEGER_ID, null, TestConstants.INSTANT_VALUE),
                Arguments.of("The parameter 'date' is null.\"", TestConstants.INTEGER_ID, TestConstants.INTEGER_ID, null)
        );
    }

    @Test
    public void findByBrandIdAndProductIdAndDateParameterValidationSuccessTest() {
        assertThatNoException()
                .as(TestMessages.VALID_PARAMS_EXPECTED)
                .isThrownBy(() -> this.priceFindUseCase.findByBrandIdAndProductIdAndDate(TestConstants.INTEGER_ID, TestConstants.INTEGER_ID, TestConstants.INSTANT_VALUE));
    }
}
