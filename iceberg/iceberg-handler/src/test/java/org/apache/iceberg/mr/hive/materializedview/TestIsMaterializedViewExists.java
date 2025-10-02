/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.iceberg.mr.hive.materializedview;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.iceberg.CatalogProperties;
import org.apache.iceberg.CatalogUtil;
import org.apache.iceberg.hadoop.HadoopCatalog;
import org.apache.iceberg.hive.CatalogUtils;
import org.apache.iceberg.mr.Catalogs;
import org.apache.iceberg.mr.InputFormatConfig;
import org.apache.iceberg.mr.TestCatalogs;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestIsMaterializedViewExists {
  private Configuration conf;

  @Rule
  public TemporaryFolder temp = new TemporaryFolder();

  @Before
  public void before() {
    conf = new Configuration();
  }

  /*
  public static boolean isViewExists(Configuration conf, String viewIdentifier,
                                     String catalogName) {
    Optional<Catalog> catalog = loadCatalog(conf, catalogName);
    if (catalog.isEmpty()) {
      throw new RuntimeException("Catalog " + catalogName + " not found");
    }
    ViewCatalog viewCatalog = (ViewCatalog) catalog.get();
    return viewCatalog.viewExists(TableIdentifier.parse(viewIdentifier));
  }
   */
  @Test
  public void testIsViewExists_CatalogNotFound_ThrowsException() {
    String viewIdentifier = "testView";
    String catalogName = "notExistingCatalog";

    Assertions.assertThatThrownBy(() -> Catalogs.isViewExists(conf, viewIdentifier, catalogName))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("Catalog " +  catalogName + " not found");
  }

  @Test
  public void testIsViewExits_ViewDoesntExist_returns_false() throws IOException {
    String viewIdentifier = "testView";
    String defaultCatalogName = "default";
    String warehouseLocation = temp.newFolder("hadoop", "warehouse").toString();


    conf.set(CatalogUtils.catalogPropertyConfigKey(defaultCatalogName, CatalogProperties.WAREHOUSE_LOCATION),
            warehouseLocation);
    conf.set(CatalogUtils.catalogPropertyConfigKey(defaultCatalogName, CatalogProperties.CATALOG_IMPL),
            TestCatalogs.CustomHadoopCatalog.class.getName());
    conf.set(InputFormatConfig.CATALOG_NAME, defaultCatalogName);
    conf.set(CatalogUtil.ICEBERG_CATALOG_TYPE, Catalogs.LOCATION);
    HadoopCatalog catalog = new TestCatalogs.CustomHadoopCatalog(conf, warehouseLocation);

    Assertions.assertThatThrownBy(() -> Catalogs.isViewExists(conf, viewIdentifier, defaultCatalogName))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("Catalog " +  defaultCatalogName + " not found");
  }

  @Test
  public void testIsViewExits_ViewExists_returns_true() {

  }
}
