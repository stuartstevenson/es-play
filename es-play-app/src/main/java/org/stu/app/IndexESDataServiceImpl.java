package org.stu.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.stu.domain.Post;
import org.stu.domain.Property;
import org.stu.repositories.PostRepository;
import org.stu.repositories.PropertyRepository;
import org.stu.util.DateProvider;

import java.util.ArrayList;
import java.util.List;

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
	private PostRepository postRepository;
	@Autowired
	private DateProvider dateProvider;

    @Override
    public void indexData() {


		propertyRepository.save(new Property(1L,
				"27 The Horseshoe, York, YO24 1LY",
				"A lovely 4 bedroom property on the desirable Horseshoe in Dringhouses. Large Garden (10000 acres) and off road parking",
				1000000L
		));
		propertyRepository.save(new Property(2l,
				"39 Abbey Road, Waltham Cross",
				"2 BEDROOM BUNGALOW TO RENT. NO PARKING. NO PETS.",
				1000L
		));
		propertyRepository.save(new Property(3L,
				"17 Twelve Acres, Welwyn Garden City, Hertfordshire",
				"Omg what an awesome house, it's like the muther-chuffing queen lives here. Large garden (1/2 acre), off-road parking, decking and swimming pool. Close to local stations and good transport links.",
				500000L
		));
		propertyRepository.save(new Property(6L,
				"Denham Farm, Tavistock",
				"100 acres of farmland with outbuildings and victorian barns",
				800000L
		));
		propertyRepository.save(new Property(5L,
				"11 St Clements Grove, york",
				"Victorian town house, 4 bedroom with attic rooms.",
				300000L
		));

    }


}
