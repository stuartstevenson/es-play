package org.stu.domain;

import com.spatial4j.core.shape.impl.PointImpl;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created with IntelliJ IDEA.
 * User: stuarts
 * Date: 15/08/13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */

@Document(indexName = "properties", type = "property")
public class Property {
	@Id
	private Long id;
	@Version
	private Long version;
	private String address;
	private String description;
	private Long price;
    private PointImpl location;

	public Property() {
	}

	public Property(Long id, String address, String description, Long price, PointImpl location) {
		this.id = id;
		this.address = address;
		this.description = description;
		this.price = price;
        this.location = location;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

    public PointImpl getLocation() {
        return location;
    }

    public void setLocation(PointImpl location) {
        this.location = location;
    }
}
