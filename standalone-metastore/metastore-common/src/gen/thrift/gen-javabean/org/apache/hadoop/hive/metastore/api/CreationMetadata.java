/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class CreationMetadata implements org.apache.thrift.TBase<CreationMetadata, CreationMetadata._Fields>, java.io.Serializable, Cloneable, Comparable<CreationMetadata> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CreationMetadata");

  private static final org.apache.thrift.protocol.TField CAT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("catName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dbName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TBL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tblName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TABLES_USED_FIELD_DESC = new org.apache.thrift.protocol.TField("tablesUsed", org.apache.thrift.protocol.TType.SET, (short)4);
  private static final org.apache.thrift.protocol.TField VALID_TXN_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("validTxnList", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField MATERIALIZATION_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("materializationTime", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField SOURCE_TABLES_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceTables", org.apache.thrift.protocol.TType.LIST, (short)7);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CreationMetadataStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CreationMetadataTupleSchemeFactory();

  private @org.apache.thrift.annotation.Nullable java.lang.String catName; // required
  private @org.apache.thrift.annotation.Nullable java.lang.String dbName; // required
  private @org.apache.thrift.annotation.Nullable java.lang.String tblName; // required
  private @org.apache.thrift.annotation.Nullable java.util.Set<java.lang.String> tablesUsed; // required
  private @org.apache.thrift.annotation.Nullable java.lang.String validTxnList; // optional
  private long materializationTime; // optional
  private @org.apache.thrift.annotation.Nullable java.util.List<SourceTable> sourceTables; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CAT_NAME((short)1, "catName"),
    DB_NAME((short)2, "dbName"),
    TBL_NAME((short)3, "tblName"),
    TABLES_USED((short)4, "tablesUsed"),
    VALID_TXN_LIST((short)5, "validTxnList"),
    MATERIALIZATION_TIME((short)6, "materializationTime"),
    SOURCE_TABLES((short)7, "sourceTables");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CAT_NAME
          return CAT_NAME;
        case 2: // DB_NAME
          return DB_NAME;
        case 3: // TBL_NAME
          return TBL_NAME;
        case 4: // TABLES_USED
          return TABLES_USED;
        case 5: // VALID_TXN_LIST
          return VALID_TXN_LIST;
        case 6: // MATERIALIZATION_TIME
          return MATERIALIZATION_TIME;
        case 7: // SOURCE_TABLES
          return SOURCE_TABLES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __MATERIALIZATIONTIME_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.VALID_TXN_LIST,_Fields.MATERIALIZATION_TIME,_Fields.SOURCE_TABLES};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CAT_NAME, new org.apache.thrift.meta_data.FieldMetaData("catName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("dbName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TBL_NAME, new org.apache.thrift.meta_data.FieldMetaData("tblName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TABLES_USED, new org.apache.thrift.meta_data.FieldMetaData("tablesUsed", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.VALID_TXN_LIST, new org.apache.thrift.meta_data.FieldMetaData("validTxnList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MATERIALIZATION_TIME, new org.apache.thrift.meta_data.FieldMetaData("materializationTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.SOURCE_TABLES, new org.apache.thrift.meta_data.FieldMetaData("sourceTables", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "SourceTable"))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CreationMetadata.class, metaDataMap);
  }

  public CreationMetadata() {
  }

  public CreationMetadata(
    java.lang.String catName,
    java.lang.String dbName,
    java.lang.String tblName,
    java.util.Set<java.lang.String> tablesUsed)
  {
    this();
    this.catName = catName;
    this.dbName = dbName;
    this.tblName = tblName;
    this.tablesUsed = tablesUsed;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CreationMetadata(CreationMetadata other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetCatName()) {
      this.catName = other.catName;
    }
    if (other.isSetDbName()) {
      this.dbName = other.dbName;
    }
    if (other.isSetTblName()) {
      this.tblName = other.tblName;
    }
    if (other.isSetTablesUsed()) {
      java.util.Set<java.lang.String> __this__tablesUsed = new java.util.HashSet<java.lang.String>(other.tablesUsed);
      this.tablesUsed = __this__tablesUsed;
    }
    if (other.isSetValidTxnList()) {
      this.validTxnList = other.validTxnList;
    }
    this.materializationTime = other.materializationTime;
    if (other.isSetSourceTables()) {
      java.util.List<SourceTable> __this__sourceTables = new java.util.ArrayList<SourceTable>(other.sourceTables.size());
      for (SourceTable other_element : other.sourceTables) {
        __this__sourceTables.add(new SourceTable(other_element));
      }
      this.sourceTables = __this__sourceTables;
    }
  }

  public CreationMetadata deepCopy() {
    return new CreationMetadata(this);
  }

  @Override
  public void clear() {
    this.catName = null;
    this.dbName = null;
    this.tblName = null;
    this.tablesUsed = null;
    this.validTxnList = null;
    setMaterializationTimeIsSet(false);
    this.materializationTime = 0;
    this.sourceTables = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCatName() {
    return this.catName;
  }

  public void setCatName(@org.apache.thrift.annotation.Nullable java.lang.String catName) {
    this.catName = catName;
  }

  public void unsetCatName() {
    this.catName = null;
  }

  /** Returns true if field catName is set (has been assigned a value) and false otherwise */
  public boolean isSetCatName() {
    return this.catName != null;
  }

  public void setCatNameIsSet(boolean value) {
    if (!value) {
      this.catName = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getDbName() {
    return this.dbName;
  }

  public void setDbName(@org.apache.thrift.annotation.Nullable java.lang.String dbName) {
    this.dbName = dbName;
  }

  public void unsetDbName() {
    this.dbName = null;
  }

  /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
  public boolean isSetDbName() {
    return this.dbName != null;
  }

  public void setDbNameIsSet(boolean value) {
    if (!value) {
      this.dbName = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getTblName() {
    return this.tblName;
  }

  public void setTblName(@org.apache.thrift.annotation.Nullable java.lang.String tblName) {
    this.tblName = tblName;
  }

  public void unsetTblName() {
    this.tblName = null;
  }

  /** Returns true if field tblName is set (has been assigned a value) and false otherwise */
  public boolean isSetTblName() {
    return this.tblName != null;
  }

  public void setTblNameIsSet(boolean value) {
    if (!value) {
      this.tblName = null;
    }
  }

  public int getTablesUsedSize() {
    return (this.tablesUsed == null) ? 0 : this.tablesUsed.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.String> getTablesUsedIterator() {
    return (this.tablesUsed == null) ? null : this.tablesUsed.iterator();
  }

  public void addToTablesUsed(java.lang.String elem) {
    if (this.tablesUsed == null) {
      this.tablesUsed = new java.util.HashSet<java.lang.String>();
    }
    this.tablesUsed.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Set<java.lang.String> getTablesUsed() {
    return this.tablesUsed;
  }

  public void setTablesUsed(@org.apache.thrift.annotation.Nullable java.util.Set<java.lang.String> tablesUsed) {
    this.tablesUsed = tablesUsed;
  }

  public void unsetTablesUsed() {
    this.tablesUsed = null;
  }

  /** Returns true if field tablesUsed is set (has been assigned a value) and false otherwise */
  public boolean isSetTablesUsed() {
    return this.tablesUsed != null;
  }

  public void setTablesUsedIsSet(boolean value) {
    if (!value) {
      this.tablesUsed = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getValidTxnList() {
    return this.validTxnList;
  }

  public void setValidTxnList(@org.apache.thrift.annotation.Nullable java.lang.String validTxnList) {
    this.validTxnList = validTxnList;
  }

  public void unsetValidTxnList() {
    this.validTxnList = null;
  }

  /** Returns true if field validTxnList is set (has been assigned a value) and false otherwise */
  public boolean isSetValidTxnList() {
    return this.validTxnList != null;
  }

  public void setValidTxnListIsSet(boolean value) {
    if (!value) {
      this.validTxnList = null;
    }
  }

  public long getMaterializationTime() {
    return this.materializationTime;
  }

  public void setMaterializationTime(long materializationTime) {
    this.materializationTime = materializationTime;
    setMaterializationTimeIsSet(true);
  }

  public void unsetMaterializationTime() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MATERIALIZATIONTIME_ISSET_ID);
  }

  /** Returns true if field materializationTime is set (has been assigned a value) and false otherwise */
  public boolean isSetMaterializationTime() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MATERIALIZATIONTIME_ISSET_ID);
  }

  public void setMaterializationTimeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MATERIALIZATIONTIME_ISSET_ID, value);
  }

  public int getSourceTablesSize() {
    return (this.sourceTables == null) ? 0 : this.sourceTables.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<SourceTable> getSourceTablesIterator() {
    return (this.sourceTables == null) ? null : this.sourceTables.iterator();
  }

  public void addToSourceTables(SourceTable elem) {
    if (this.sourceTables == null) {
      this.sourceTables = new java.util.ArrayList<SourceTable>();
    }
    this.sourceTables.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<SourceTable> getSourceTables() {
    return this.sourceTables;
  }

  public void setSourceTables(@org.apache.thrift.annotation.Nullable java.util.List<SourceTable> sourceTables) {
    this.sourceTables = sourceTables;
  }

  public void unsetSourceTables() {
    this.sourceTables = null;
  }

  /** Returns true if field sourceTables is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceTables() {
    return this.sourceTables != null;
  }

  public void setSourceTablesIsSet(boolean value) {
    if (!value) {
      this.sourceTables = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case CAT_NAME:
      if (value == null) {
        unsetCatName();
      } else {
        setCatName((java.lang.String)value);
      }
      break;

    case DB_NAME:
      if (value == null) {
        unsetDbName();
      } else {
        setDbName((java.lang.String)value);
      }
      break;

    case TBL_NAME:
      if (value == null) {
        unsetTblName();
      } else {
        setTblName((java.lang.String)value);
      }
      break;

    case TABLES_USED:
      if (value == null) {
        unsetTablesUsed();
      } else {
        setTablesUsed((java.util.Set<java.lang.String>)value);
      }
      break;

    case VALID_TXN_LIST:
      if (value == null) {
        unsetValidTxnList();
      } else {
        setValidTxnList((java.lang.String)value);
      }
      break;

    case MATERIALIZATION_TIME:
      if (value == null) {
        unsetMaterializationTime();
      } else {
        setMaterializationTime((java.lang.Long)value);
      }
      break;

    case SOURCE_TABLES:
      if (value == null) {
        unsetSourceTables();
      } else {
        setSourceTables((java.util.List<SourceTable>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case CAT_NAME:
      return getCatName();

    case DB_NAME:
      return getDbName();

    case TBL_NAME:
      return getTblName();

    case TABLES_USED:
      return getTablesUsed();

    case VALID_TXN_LIST:
      return getValidTxnList();

    case MATERIALIZATION_TIME:
      return getMaterializationTime();

    case SOURCE_TABLES:
      return getSourceTables();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case CAT_NAME:
      return isSetCatName();
    case DB_NAME:
      return isSetDbName();
    case TBL_NAME:
      return isSetTblName();
    case TABLES_USED:
      return isSetTablesUsed();
    case VALID_TXN_LIST:
      return isSetValidTxnList();
    case MATERIALIZATION_TIME:
      return isSetMaterializationTime();
    case SOURCE_TABLES:
      return isSetSourceTables();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof CreationMetadata)
      return this.equals((CreationMetadata)that);
    return false;
  }

  public boolean equals(CreationMetadata that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_catName = true && this.isSetCatName();
    boolean that_present_catName = true && that.isSetCatName();
    if (this_present_catName || that_present_catName) {
      if (!(this_present_catName && that_present_catName))
        return false;
      if (!this.catName.equals(that.catName))
        return false;
    }

    boolean this_present_dbName = true && this.isSetDbName();
    boolean that_present_dbName = true && that.isSetDbName();
    if (this_present_dbName || that_present_dbName) {
      if (!(this_present_dbName && that_present_dbName))
        return false;
      if (!this.dbName.equals(that.dbName))
        return false;
    }

    boolean this_present_tblName = true && this.isSetTblName();
    boolean that_present_tblName = true && that.isSetTblName();
    if (this_present_tblName || that_present_tblName) {
      if (!(this_present_tblName && that_present_tblName))
        return false;
      if (!this.tblName.equals(that.tblName))
        return false;
    }

    boolean this_present_tablesUsed = true && this.isSetTablesUsed();
    boolean that_present_tablesUsed = true && that.isSetTablesUsed();
    if (this_present_tablesUsed || that_present_tablesUsed) {
      if (!(this_present_tablesUsed && that_present_tablesUsed))
        return false;
      if (!this.tablesUsed.equals(that.tablesUsed))
        return false;
    }

    boolean this_present_validTxnList = true && this.isSetValidTxnList();
    boolean that_present_validTxnList = true && that.isSetValidTxnList();
    if (this_present_validTxnList || that_present_validTxnList) {
      if (!(this_present_validTxnList && that_present_validTxnList))
        return false;
      if (!this.validTxnList.equals(that.validTxnList))
        return false;
    }

    boolean this_present_materializationTime = true && this.isSetMaterializationTime();
    boolean that_present_materializationTime = true && that.isSetMaterializationTime();
    if (this_present_materializationTime || that_present_materializationTime) {
      if (!(this_present_materializationTime && that_present_materializationTime))
        return false;
      if (this.materializationTime != that.materializationTime)
        return false;
    }

    boolean this_present_sourceTables = true && this.isSetSourceTables();
    boolean that_present_sourceTables = true && that.isSetSourceTables();
    if (this_present_sourceTables || that_present_sourceTables) {
      if (!(this_present_sourceTables && that_present_sourceTables))
        return false;
      if (!this.sourceTables.equals(that.sourceTables))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetCatName()) ? 131071 : 524287);
    if (isSetCatName())
      hashCode = hashCode * 8191 + catName.hashCode();

    hashCode = hashCode * 8191 + ((isSetDbName()) ? 131071 : 524287);
    if (isSetDbName())
      hashCode = hashCode * 8191 + dbName.hashCode();

    hashCode = hashCode * 8191 + ((isSetTblName()) ? 131071 : 524287);
    if (isSetTblName())
      hashCode = hashCode * 8191 + tblName.hashCode();

    hashCode = hashCode * 8191 + ((isSetTablesUsed()) ? 131071 : 524287);
    if (isSetTablesUsed())
      hashCode = hashCode * 8191 + tablesUsed.hashCode();

    hashCode = hashCode * 8191 + ((isSetValidTxnList()) ? 131071 : 524287);
    if (isSetValidTxnList())
      hashCode = hashCode * 8191 + validTxnList.hashCode();

    hashCode = hashCode * 8191 + ((isSetMaterializationTime()) ? 131071 : 524287);
    if (isSetMaterializationTime())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(materializationTime);

    hashCode = hashCode * 8191 + ((isSetSourceTables()) ? 131071 : 524287);
    if (isSetSourceTables())
      hashCode = hashCode * 8191 + sourceTables.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(CreationMetadata other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetCatName(), other.isSetCatName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCatName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.catName, other.catName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetDbName(), other.isSetDbName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTblName(), other.isSetTblName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTblName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tblName, other.tblName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTablesUsed(), other.isSetTablesUsed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTablesUsed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tablesUsed, other.tablesUsed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetValidTxnList(), other.isSetValidTxnList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValidTxnList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.validTxnList, other.validTxnList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetMaterializationTime(), other.isSetMaterializationTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaterializationTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.materializationTime, other.materializationTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetSourceTables(), other.isSetSourceTables());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceTables()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceTables, other.sourceTables);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("CreationMetadata(");
    boolean first = true;

    sb.append("catName:");
    if (this.catName == null) {
      sb.append("null");
    } else {
      sb.append(this.catName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dbName:");
    if (this.dbName == null) {
      sb.append("null");
    } else {
      sb.append(this.dbName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tblName:");
    if (this.tblName == null) {
      sb.append("null");
    } else {
      sb.append(this.tblName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tablesUsed:");
    if (this.tablesUsed == null) {
      sb.append("null");
    } else {
      sb.append(this.tablesUsed);
    }
    first = false;
    if (isSetValidTxnList()) {
      if (!first) sb.append(", ");
      sb.append("validTxnList:");
      if (this.validTxnList == null) {
        sb.append("null");
      } else {
        sb.append(this.validTxnList);
      }
      first = false;
    }
    if (isSetMaterializationTime()) {
      if (!first) sb.append(", ");
      sb.append("materializationTime:");
      sb.append(this.materializationTime);
      first = false;
    }
    if (isSetSourceTables()) {
      if (!first) sb.append(", ");
      sb.append("sourceTables:");
      if (this.sourceTables == null) {
        sb.append("null");
      } else {
        sb.append(this.sourceTables);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetCatName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'catName' is unset! Struct:" + toString());
    }

    if (!isSetDbName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dbName' is unset! Struct:" + toString());
    }

    if (!isSetTblName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tblName' is unset! Struct:" + toString());
    }

    if (!isSetTablesUsed()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tablesUsed' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CreationMetadataStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CreationMetadataStandardScheme getScheme() {
      return new CreationMetadataStandardScheme();
    }
  }

  private static class CreationMetadataStandardScheme extends org.apache.thrift.scheme.StandardScheme<CreationMetadata> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CreationMetadata struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CAT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.catName = iprot.readString();
              struct.setCatNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbName = iprot.readString();
              struct.setDbNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TBL_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tblName = iprot.readString();
              struct.setTblNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TABLES_USED
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set320 = iprot.readSetBegin();
                struct.tablesUsed = new java.util.HashSet<java.lang.String>(2*_set320.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _elem321;
                for (int _i322 = 0; _i322 < _set320.size; ++_i322)
                {
                  _elem321 = iprot.readString();
                  struct.tablesUsed.add(_elem321);
                }
                iprot.readSetEnd();
              }
              struct.setTablesUsedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // VALID_TXN_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.validTxnList = iprot.readString();
              struct.setValidTxnListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // MATERIALIZATION_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.materializationTime = iprot.readI64();
              struct.setMaterializationTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // SOURCE_TABLES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list323 = iprot.readListBegin();
                struct.sourceTables = new java.util.ArrayList<SourceTable>(_list323.size);
                @org.apache.thrift.annotation.Nullable SourceTable _elem324;
                for (int _i325 = 0; _i325 < _list323.size; ++_i325)
                {
                  _elem324 = new SourceTable();
                  _elem324.read(iprot);
                  struct.sourceTables.add(_elem324);
                }
                iprot.readListEnd();
              }
              struct.setSourceTablesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CreationMetadata struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.catName != null) {
        oprot.writeFieldBegin(CAT_NAME_FIELD_DESC);
        oprot.writeString(struct.catName);
        oprot.writeFieldEnd();
      }
      if (struct.dbName != null) {
        oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        oprot.writeString(struct.dbName);
        oprot.writeFieldEnd();
      }
      if (struct.tblName != null) {
        oprot.writeFieldBegin(TBL_NAME_FIELD_DESC);
        oprot.writeString(struct.tblName);
        oprot.writeFieldEnd();
      }
      if (struct.tablesUsed != null) {
        oprot.writeFieldBegin(TABLES_USED_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, struct.tablesUsed.size()));
          for (java.lang.String _iter326 : struct.tablesUsed)
          {
            oprot.writeString(_iter326);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.validTxnList != null) {
        if (struct.isSetValidTxnList()) {
          oprot.writeFieldBegin(VALID_TXN_LIST_FIELD_DESC);
          oprot.writeString(struct.validTxnList);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetMaterializationTime()) {
        oprot.writeFieldBegin(MATERIALIZATION_TIME_FIELD_DESC);
        oprot.writeI64(struct.materializationTime);
        oprot.writeFieldEnd();
      }
      if (struct.sourceTables != null) {
        if (struct.isSetSourceTables()) {
          oprot.writeFieldBegin(SOURCE_TABLES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.sourceTables.size()));
            for (SourceTable _iter327 : struct.sourceTables)
            {
              _iter327.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CreationMetadataTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CreationMetadataTupleScheme getScheme() {
      return new CreationMetadataTupleScheme();
    }
  }

  private static class CreationMetadataTupleScheme extends org.apache.thrift.scheme.TupleScheme<CreationMetadata> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CreationMetadata struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.catName);
      oprot.writeString(struct.dbName);
      oprot.writeString(struct.tblName);
      {
        oprot.writeI32(struct.tablesUsed.size());
        for (java.lang.String _iter328 : struct.tablesUsed)
        {
          oprot.writeString(_iter328);
        }
      }
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetValidTxnList()) {
        optionals.set(0);
      }
      if (struct.isSetMaterializationTime()) {
        optionals.set(1);
      }
      if (struct.isSetSourceTables()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetValidTxnList()) {
        oprot.writeString(struct.validTxnList);
      }
      if (struct.isSetMaterializationTime()) {
        oprot.writeI64(struct.materializationTime);
      }
      if (struct.isSetSourceTables()) {
        {
          oprot.writeI32(struct.sourceTables.size());
          for (SourceTable _iter329 : struct.sourceTables)
          {
            _iter329.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CreationMetadata struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.catName = iprot.readString();
      struct.setCatNameIsSet(true);
      struct.dbName = iprot.readString();
      struct.setDbNameIsSet(true);
      struct.tblName = iprot.readString();
      struct.setTblNameIsSet(true);
      {
        org.apache.thrift.protocol.TSet _set330 = iprot.readSetBegin(org.apache.thrift.protocol.TType.STRING);
        struct.tablesUsed = new java.util.HashSet<java.lang.String>(2*_set330.size);
        @org.apache.thrift.annotation.Nullable java.lang.String _elem331;
        for (int _i332 = 0; _i332 < _set330.size; ++_i332)
        {
          _elem331 = iprot.readString();
          struct.tablesUsed.add(_elem331);
        }
      }
      struct.setTablesUsedIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.validTxnList = iprot.readString();
        struct.setValidTxnListIsSet(true);
      }
      if (incoming.get(1)) {
        struct.materializationTime = iprot.readI64();
        struct.setMaterializationTimeIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list333 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.sourceTables = new java.util.ArrayList<SourceTable>(_list333.size);
          @org.apache.thrift.annotation.Nullable SourceTable _elem334;
          for (int _i335 = 0; _i335 < _list333.size; ++_i335)
          {
            _elem334 = new SourceTable();
            _elem334.read(iprot);
            struct.sourceTables.add(_elem334);
          }
        }
        struct.setSourceTablesIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

