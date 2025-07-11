/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class GetDatabaseObjectsResponse implements org.apache.thrift.TBase<GetDatabaseObjectsResponse, GetDatabaseObjectsResponse._Fields>, java.io.Serializable, Cloneable, Comparable<GetDatabaseObjectsResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetDatabaseObjectsResponse");

  private static final org.apache.thrift.protocol.TField DATABASES_FIELD_DESC = new org.apache.thrift.protocol.TField("databases", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new GetDatabaseObjectsResponseStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new GetDatabaseObjectsResponseTupleSchemeFactory();

  private @org.apache.thrift.annotation.Nullable java.util.List<Database> databases; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DATABASES((short)1, "databases");

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
        case 1: // DATABASES
          return DATABASES;
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
    tmpMap.put(_Fields.DATABASES, new org.apache.thrift.meta_data.FieldMetaData("databases", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Database.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetDatabaseObjectsResponse.class, metaDataMap);
  }

  public GetDatabaseObjectsResponse() {
  }

  public GetDatabaseObjectsResponse(
    java.util.List<Database> databases)
  {
    this();
    this.databases = databases;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GetDatabaseObjectsResponse(GetDatabaseObjectsResponse other) {
    if (other.isSetDatabases()) {
      java.util.List<Database> __this__databases = new java.util.ArrayList<Database>(other.databases.size());
      for (Database other_element : other.databases) {
        __this__databases.add(new Database(other_element));
      }
      this.databases = __this__databases;
    }
  }

  public GetDatabaseObjectsResponse deepCopy() {
    return new GetDatabaseObjectsResponse(this);
  }

  @Override
  public void clear() {
    this.databases = null;
  }

  public int getDatabasesSize() {
    return (this.databases == null) ? 0 : this.databases.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<Database> getDatabasesIterator() {
    return (this.databases == null) ? null : this.databases.iterator();
  }

  public void addToDatabases(Database elem) {
    if (this.databases == null) {
      this.databases = new java.util.ArrayList<Database>();
    }
    this.databases.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<Database> getDatabases() {
    return this.databases;
  }

  public void setDatabases(@org.apache.thrift.annotation.Nullable java.util.List<Database> databases) {
    this.databases = databases;
  }

  public void unsetDatabases() {
    this.databases = null;
  }

  /** Returns true if field databases is set (has been assigned a value) and false otherwise */
  public boolean isSetDatabases() {
    return this.databases != null;
  }

  public void setDatabasesIsSet(boolean value) {
    if (!value) {
      this.databases = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DATABASES:
      if (value == null) {
        unsetDatabases();
      } else {
        setDatabases((java.util.List<Database>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DATABASES:
      return getDatabases();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case DATABASES:
      return isSetDatabases();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof GetDatabaseObjectsResponse)
      return this.equals((GetDatabaseObjectsResponse)that);
    return false;
  }

  public boolean equals(GetDatabaseObjectsResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_databases = true && this.isSetDatabases();
    boolean that_present_databases = true && that.isSetDatabases();
    if (this_present_databases || that_present_databases) {
      if (!(this_present_databases && that_present_databases))
        return false;
      if (!this.databases.equals(that.databases))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDatabases()) ? 131071 : 524287);
    if (isSetDatabases())
      hashCode = hashCode * 8191 + databases.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(GetDatabaseObjectsResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDatabases(), other.isSetDatabases());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDatabases()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.databases, other.databases);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("GetDatabaseObjectsResponse(");
    boolean first = true;

    sb.append("databases:");
    if (this.databases == null) {
      sb.append("null");
    } else {
      sb.append(this.databases);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetDatabases()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'databases' is unset! Struct:" + toString());
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

  private static class GetDatabaseObjectsResponseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public GetDatabaseObjectsResponseStandardScheme getScheme() {
      return new GetDatabaseObjectsResponseStandardScheme();
    }
  }

  private static class GetDatabaseObjectsResponseStandardScheme extends org.apache.thrift.scheme.StandardScheme<GetDatabaseObjectsResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GetDatabaseObjectsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DATABASES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list226 = iprot.readListBegin();
                struct.databases = new java.util.ArrayList<Database>(_list226.size);
                @org.apache.thrift.annotation.Nullable Database _elem227;
                for (int _i228 = 0; _i228 < _list226.size; ++_i228)
                {
                  _elem227 = new Database();
                  _elem227.read(iprot);
                  struct.databases.add(_elem227);
                }
                iprot.readListEnd();
              }
              struct.setDatabasesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GetDatabaseObjectsResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.databases != null) {
        oprot.writeFieldBegin(DATABASES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.databases.size()));
          for (Database _iter229 : struct.databases)
          {
            _iter229.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GetDatabaseObjectsResponseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public GetDatabaseObjectsResponseTupleScheme getScheme() {
      return new GetDatabaseObjectsResponseTupleScheme();
    }
  }

  private static class GetDatabaseObjectsResponseTupleScheme extends org.apache.thrift.scheme.TupleScheme<GetDatabaseObjectsResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GetDatabaseObjectsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.databases.size());
        for (Database _iter230 : struct.databases)
        {
          _iter230.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GetDatabaseObjectsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list231 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        struct.databases = new java.util.ArrayList<Database>(_list231.size);
        @org.apache.thrift.annotation.Nullable Database _elem232;
        for (int _i233 = 0; _i233 < _list231.size; ++_i233)
        {
          _elem232 = new Database();
          _elem232.read(iprot);
          struct.databases.add(_elem232);
        }
      }
      struct.setDatabasesIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

