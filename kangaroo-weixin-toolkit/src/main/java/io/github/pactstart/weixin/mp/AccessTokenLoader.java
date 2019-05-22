package io.github.pactstart.weixin.mp;

import io.github.pactstart.weixin.mp.request.AccessTokenGetRequest;
import io.github.pactstart.weixin.mp.response.AccessTokenGetResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Properties;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class AccessTokenLoader {

    private static Properties properties = new Properties();

    static {
        try {
            Path path = FileSystems.getDefault().getPath("D:\\", "access_token.properties");
            if (Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                properties.load(Files.newInputStream(path, StandardOpenOption.READ));
                if (!properties.containsKey("access_token")) {
                    refreshAndStore(properties, path);
                } else {
                    if (properties.containsKey("create_at")) {
                        long createAt = Long.valueOf(properties.getProperty("create_at"));
                        if (System.currentTimeMillis() / 1000 - createAt > 7100) {
                            refreshAndStore(properties, path);
                        }
                    } else {
                        refreshAndStore(properties, path);
                    }
                }
            } else {
                Files.createFile(path);
                refreshAndStore(properties, path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAccessToken() {
        return properties.getProperty("access_token");
    }

    private static void refreshAndStore(Properties properties, Path path) throws IOException {
        AccessTokenGetRequest request = new AccessTokenGetRequest();
        request.setAppid("wxfb19cedd5016e4c9");
        request.setSecret("1462aaea13be4b625a07421ce5fe9167");
        AccessTokenGetResponse response = MpApiClient.getInstance().execute(request);
        String accessToken = response.getAccessToken();
        properties.put("access_token", accessToken);
        properties.put("create_at", "" + System.currentTimeMillis() / 1000);
        properties.store(Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.WRITE), null);
    }
}
