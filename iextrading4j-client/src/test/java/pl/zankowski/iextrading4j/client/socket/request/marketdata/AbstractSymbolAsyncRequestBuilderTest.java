package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractSymbolAsyncRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateAsyncRequestWithAllSymbols() {
        final SocketRequest<LastTrade> request = new LastAsyncRequestBuilder()
                .withAllSymbols()
                .build();

        assertThat(request.getParams()).contains("firehose");
    }

    @Test
    public void shouldSuccessfullyCreateAsyncRequestWithMultipleSymbols() {
        final String ibmSymbol = "ibm";
        final String aaplSymbol = "aapl";

        final SocketRequest<LastTrade> request = new LastAsyncRequestBuilder()
                .withSymbols(ibmSymbol, aaplSymbol)
                .build();

        assertThat(request.getParams().get(0)).containsSequence(ibmSymbol).containsSequence(aaplSymbol);
    }

}
