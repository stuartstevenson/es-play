package org.stu.arch;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.testng.annotations.Test;

public class DefaultSiteMeshFilterIT{
    @Test
    public void testCustomConfiguration() {
        SiteMeshFilterBuilder siteMeshFilterBuilder = new SiteMeshFilterBuilder();
        new DefaultSiteMeshFilter().applyCustomConfiguration(siteMeshFilterBuilder);
    }
}
