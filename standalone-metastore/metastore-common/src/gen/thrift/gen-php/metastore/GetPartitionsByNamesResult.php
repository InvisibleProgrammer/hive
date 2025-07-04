<?php
namespace metastore;

/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;

class GetPartitionsByNamesResult
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'partitions',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\metastore\Partition',
                ),
        ),
        2 => array(
            'var' => 'dictionary',
            'isRequired' => false,
            'type' => TType::STRUCT,
            'class' => '\metastore\ObjectDictionary',
        ),
    );

    /**
     * @var \metastore\Partition[]
     */
    public $partitions = null;
    /**
     * @var \metastore\ObjectDictionary
     */
    public $dictionary = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['partitions'])) {
                $this->partitions = $vals['partitions'];
            }
            if (isset($vals['dictionary'])) {
                $this->dictionary = $vals['dictionary'];
            }
        }
    }

    public function getName()
    {
        return 'GetPartitionsByNamesResult';
    }


    public function read($input)
    {
        $xfer = 0;
        $fname = null;
        $ftype = 0;
        $fid = 0;
        $xfer += $input->readStructBegin($fname);
        while (true) {
            $xfer += $input->readFieldBegin($fname, $ftype, $fid);
            if ($ftype == TType::STOP) {
                break;
            }
            switch ($fid) {
                case 1:
                    if ($ftype == TType::LST) {
                        $this->partitions = array();
                        $_size674 = 0;
                        $_etype677 = 0;
                        $xfer += $input->readListBegin($_etype677, $_size674);
                        for ($_i678 = 0; $_i678 < $_size674; ++$_i678) {
                            $elem679 = null;
                            $elem679 = new \metastore\Partition();
                            $xfer += $elem679->read($input);
                            $this->partitions []= $elem679;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::STRUCT) {
                        $this->dictionary = new \metastore\ObjectDictionary();
                        $xfer += $this->dictionary->read($input);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                default:
                    $xfer += $input->skip($ftype);
                    break;
            }
            $xfer += $input->readFieldEnd();
        }
        $xfer += $input->readStructEnd();
        return $xfer;
    }

    public function write($output)
    {
        $xfer = 0;
        $xfer += $output->writeStructBegin('GetPartitionsByNamesResult');
        if ($this->partitions !== null) {
            if (!is_array($this->partitions)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('partitions', TType::LST, 1);
            $output->writeListBegin(TType::STRUCT, count($this->partitions));
            foreach ($this->partitions as $iter680) {
                $xfer += $iter680->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->dictionary !== null) {
            if (!is_object($this->dictionary)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('dictionary', TType::STRUCT, 2);
            $xfer += $this->dictionary->write($output);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
