package pl.zankowski.iextrading.rest.client.endpoint.stats;

import pl.zankowski.iextrading.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading.api.stats.HistoricalStats;
import pl.zankowski.iextrading.api.stats.IntradayStats;
import pl.zankowski.iextrading.api.stats.RecentStats;
import pl.zankowski.iextrading.api.stats.RecordsStats;
import pl.zankowski.iextrading.rest.client.IEXTradingClient;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import static pl.zankowski.iextrading.rest.client.util.PathUtil.appendPaths;


/**
 * @author Wojciech Zankowski
 */
public class StatsEndpointImpl implements StatsEndpoint {

    public static final String STATS_PATH = "stats";
    public static final String INTRADAY_PATH = "intraday";
    public static final String RECENT_PATH = "recent";
    public static final String RECORDS_PATH = "records";

    public static final String HISTORICAL_PATH = "historical";
    public static final String HISTORICAL_DATE_PARAM = "date";
    private static final DateTimeFormatter DATE_PARAM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");

    public static final String HISTORICAL_DAILY_PATH = "daily";
    public static final String HISTORICAL_DAILY_DATE_PARAM = "date";
    public static final String HISTORICAL_DAILY_LAST_PARAM = "last";
    private static final DateTimeFormatter DATE_PARAM_FORMATTER_2 = DateTimeFormatter.ofPattern("yyyyMMdd");

    private final IEXTradingClient iexTradingClient;

    public StatsEndpointImpl(IEXTradingClient iexTradingClient) {
        this.iexTradingClient = iexTradingClient;
    }

    @Override
    public IntradayStats requestIntradayStats() {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, INTRADAY_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(IntradayStats.class);
    }

    @Override
    public RecentStats[] requestRecentStat() {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, RECENT_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(RecentStats[].class);
    }

    @Override
    public RecordsStats requestRecordsStat() {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, RECORDS_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(RecordsStats.class);
    }

    @Override
    public HistoricalStats[] requestHistoricalStats() {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalStats[].class);
    }

    @Override
    public HistoricalStats[] requestHistoricalStats(YearMonth date) {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DATE_PARAM, DATE_PARAM_FORMATTER.format(date));
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats() {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(YearMonth date) {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_DATE_PARAM, DATE_PARAM_FORMATTER.format(date));
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(LocalDate date) {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_DATE_PARAM, DATE_PARAM_FORMATTER_2.format(date));
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(int last) {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_LAST_PARAM, last);
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

}