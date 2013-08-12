package org.stu.app;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.stu.util.DateProvider;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: stuartjackstevenson@gmail.com
 * Date: 12/08/13
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
@Component
public class IndexESDataServiceImpl implements IndexESDataService {

    @Autowired
    private DateProvider dateProvider;

    @Override
    public void indexData() {

        Client client = new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
        try {

        IndexResponse response = client.prepareIndex("twitter", "tweet")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("user", "kimchy")
                        .field("postDate", dateProvider.now())
                        .field("message", "trying out Elastic Search")
                        .endObject()
                )
                .execute()
                .actionGet();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
