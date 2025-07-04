/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class AddForeignKeyRequest implements org.apache.thrift.TBase<AddForeignKeyRequest, AddForeignKeyRequest._Fields>, java.io.Serializable, Cloneable, Comparable<AddForeignKeyRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AddForeignKeyRequest");

  private static final org.apache.thrift.protocol.TField FOREIGN_KEY_COLS_FIELD_DESC = new org.apache.thrift.protocol.TField("foreignKeyCols", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new AddForeignKeyRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new AddForeignKeyRequestTupleSchemeFactory();

  private @org.apache.thrift.annotation.Nullable java.util.List<SQLForeignKey> foreignKeyCols; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FOREIGN_KEY_COLS((short)1, "foreignKeyCols");

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
        case 1: // FOREIGN_KEY_COLS
          return FOREIGN_KEY_COLS;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FOREIGN_KEY_COLS, new org.apache.thrift.meta_data.FieldMetaData("foreignKeyCols", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SQLForeignKey.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AddForeignKeyRequest.class, metaDataMap);
  }

  public AddForeignKeyRequest() {
  }

  public AddForeignKeyRequest(
    java.util.List<SQLForeignKey> foreignKeyCols)
  {
    this();
    this.foreignKeyCols = foreignKeyCols;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AddForeignKeyRequest(AddForeignKeyRequest other) {
    if (other.isSetForeignKeyCols()) {
      java.util.List<SQLForeignKey> __this__foreignKeyCols = new java.util.ArrayList<SQLForeignKey>(other.foreignKeyCols.size());
      for (SQLForeignKey other_element : other.foreignKeyCols) {
        __this__foreignKeyCols.add(new SQLForeignKey(other_element));
      }
      this.foreignKeyCols = __this__foreignKeyCols;
    }
  }

  public AddForeignKeyRequest deepCopy() {
    return new AddForeignKeyRequest(this);
  }

  @Override
  public void clear() {
    this.foreignKeyCols = null;
  }

  public int getForeignKeyColsSize() {
    return (this.foreignKeyCols == null) ? 0 : this.foreignKeyCols.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<SQLForeignKey> getForeignKeyColsIterator() {
    return (this.foreignKeyCols == null) ? null : this.foreignKeyCols.iterator();
  }

  public void addToForeignKeyCols(SQLForeignKey elem) {
    if (this.foreignKeyCols == null) {
      this.foreignKeyCols = new java.util.ArrayList<SQLForeignKey>();
    }
    this.foreignKeyCols.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<SQLForeignKey> getForeignKeyCols() {
    return this.foreignKeyCols;
  }

  public void setForeignKeyCols(@org.apache.thrift.annotation.Nullable java.util.List<SQLForeignKey> foreignKeyCols) {
    this.foreignKeyCols = foreignKeyCols;
  }

  public void unsetForeignKeyCols() {
    this.foreignKeyCols = null;
  }

  /** Returns true if field foreignKeyCols is set (has been assigned a value) and false otherwise */
  public boolean isSetForeignKeyCols() {
    return this.foreignKeyCols != null;
  }

  public void setForeignKeyColsIsSet(boolean value) {
    if (!value) {
      this.foreignKeyCols = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case FOREIGN_KEY_COLS:
      if (value == null) {
        unsetForeignKeyCols();
      } else {
        setForeignKeyCols((java.util.List<SQLForeignKey>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FOREIGN_KEY_COLS:
      return getForeignKeyCols();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case FOREIGN_KEY_COLS:
      return isSetForeignKeyCols();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof AddForeignKeyRequest)
      return this.equals((AddForeignKeyRequest)that);
    return false;
  }

  public boolean equals(AddForeignKeyRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_foreignKeyCols = true && this.isSetForeignKeyCols();
    boolean that_present_foreignKeyCols = true && that.isSetForeignKeyCols();
    if (this_present_foreignKeyCols || that_present_foreignKeyCols) {
      if (!(this_present_foreignKeyCols && that_present_foreignKeyCols))
        return false;
      if (!this.foreignKeyCols.equals(that.foreignKeyCols))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetForeignKeyCols()) ? 131071 : 524287);
    if (isSetForeignKeyCols())
      hashCode = hashCode * 8191 + foreignKeyCols.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(AddForeignKeyRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetForeignKeyCols(), other.isSetForeignKeyCols());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetForeignKeyCols()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.foreignKeyCols, other.foreignKeyCols);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("AddForeignKeyRequest(");
    boolean first = true;

    sb.append("foreignKeyCols:");
    if (this.foreignKeyCols == null) {
      sb.append("null");
    } else {
      sb.append(this.foreignKeyCols);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetForeignKeyCols()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'foreignKeyCols' is unset! Struct:" + toString());
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AddForeignKeyRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AddForeignKeyRequestStandardScheme getScheme() {
      return new AddForeignKeyRequestStandardScheme();
    }
  }

  private static class AddForeignKeyRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<AddForeignKeyRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AddForeignKeyRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FOREIGN_KEY_COLS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list546 = iprot.readListBegin();
                struct.foreignKeyCols = new java.util.ArrayList<SQLForeignKey>(_list546.size);
                @org.apache.thrift.annotation.Nullable SQLForeignKey _elem547;
                for (int _i548 = 0; _i548 < _list546.size; ++_i548)
                {
                  _elem547 = new SQLForeignKey();
                  _elem547.read(iprot);
                  struct.foreignKeyCols.add(_elem547);
                }
                iprot.readListEnd();
              }
              struct.setForeignKeyColsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AddForeignKeyRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.foreignKeyCols != null) {
        oprot.writeFieldBegin(FOREIGN_KEY_COLS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.foreignKeyCols.size()));
          for (SQLForeignKey _iter549 : struct.foreignKeyCols)
          {
            _iter549.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AddForeignKeyRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AddForeignKeyRequestTupleScheme getScheme() {
      return new AddForeignKeyRequestTupleScheme();
    }
  }

  private static class AddForeignKeyRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<AddForeignKeyRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AddForeignKeyRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.foreignKeyCols.size());
        for (SQLForeignKey _iter550 : struct.foreignKeyCols)
        {
          _iter550.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AddForeignKeyRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list551 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        struct.foreignKeyCols = new java.util.ArrayList<SQLForeignKey>(_list551.size);
        @org.apache.thrift.annotation.Nullable SQLForeignKey _elem552;
        for (int _i553 = 0; _i553 < _list551.size; ++_i553)
        {
          _elem552 = new SQLForeignKey();
          _elem552.read(iprot);
          struct.foreignKeyCols.add(_elem552);
        }
      }
      struct.setForeignKeyColsIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

