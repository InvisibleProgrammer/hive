package org.apache.iceberg.mr.hive.materializedview;

import org.apache.iceberg.Table;
import org.apache.iceberg.view.View;

public class MaterializedView {

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
