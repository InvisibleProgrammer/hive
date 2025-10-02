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

import org.apache.iceberg.Table;
import org.apache.iceberg.view.View;

public class MaterializedView {

  public static final String MATERIALIZED_VIEW_TABLE_SUFFIX = "_table";

  private Table table;
  private View view;

  public MaterializedView(Table table, View view) {
    this.table = table;
  }

  public Table getTable() {
    return table;
  }
  public View getView() {
    return view;
  }
}
