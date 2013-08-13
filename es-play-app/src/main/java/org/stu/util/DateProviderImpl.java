package org.stu.util;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Tamsin
 * Date: 12/08/13
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DateProviderImpl implements DateProvider {
    @Override
    public Date now() {
        return new Date();
    }
}
