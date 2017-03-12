package pl.zankowski.iextrading.rest.client.endpoint.tops;

import pl.zankowski.iextrading.api.tops.LastTrade;
import pl.zankowski.iextrading.api.tops.TOPS;
import pl.zankowski.iextrading.rest.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface TOPSEndpoint extends Endpoint {

    TOPS[] requestTOPS(String... symbols);

    LastTrade[] requestLastTrades(String... symbols);

}