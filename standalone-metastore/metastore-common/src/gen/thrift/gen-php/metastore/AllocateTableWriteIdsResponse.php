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

class AllocateTableWriteIdsResponse
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'txnToWriteIds',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\metastore\TxnToWriteId',
                ),
        ),
    );

    /**
     * @var \metastore\TxnToWriteId[]
     */
    public $txnToWriteIds = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['txnToWriteIds'])) {
                $this->txnToWriteIds = $vals['txnToWriteIds'];
            }
        }
    }

    public function getName()
    {
        return 'AllocateTableWriteIdsResponse';
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
                        $this->txnToWriteIds = array();
                        $_size779 = 0;
                        $_etype782 = 0;
                        $xfer += $input->readListBegin($_etype782, $_size779);
                        for ($_i783 = 0; $_i783 < $_size779; ++$_i783) {
                            $elem784 = null;
                            $elem784 = new \metastore\TxnToWriteId();
                            $xfer += $elem784->read($input);
                            $this->txnToWriteIds []= $elem784;
                        }
                        $xfer += $input->readListEnd();
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
        $xfer += $output->writeStructBegin('AllocateTableWriteIdsResponse');
        if ($this->txnToWriteIds !== null) {
            if (!is_array($this->txnToWriteIds)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('txnToWriteIds', TType::LST, 1);
            $output->writeListBegin(TType::STRUCT, count($this->txnToWriteIds));
            foreach ($this->txnToWriteIds as $iter785) {
                $xfer += $iter785->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
