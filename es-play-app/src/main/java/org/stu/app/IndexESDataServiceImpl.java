package org.stu.app;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;
import org.stu.domain.Property;
import org.stu.repositories.PropertyRepository;

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
	private PropertyRepository propertyRepository;
    @Autowired
    private Client client;

    @Override
    public void indexData() {

        try {


            String mapping = jsonBuilder().startObject().startObject("property").startObject("properties")
                    .startObject("point")
                        .field("type", "geo_point")
                        .field("lat_lon", true)
                    .endObject()
                    .endObject().endObject().endObject().string();

        client.admin().indices().preparePutMapping("property-index").setType("property").setSource(mapping).execute().actionGet().isAcknowledged();

        client.prepareIndex("property-index", "property", "69").setSource(jsonBuilder().startObject()
                .field("address", "New York")
                .field("description", "5 bedrooms")
                .startObject("point").field("lat", 40.7143528).field("lon", -74.0).endObject()
                .endObject()).execute().actionGet();


        } catch (Exception e) {
            // ignore
        }

    }


}
