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

class ReplicationMetricList
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'replicationMetricList',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\metastore\ReplicationMetrics',
                ),
        ),
    );

    /**
     * @var \metastore\ReplicationMetrics[]
     */
    public $replicationMetricList = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['replicationMetricList'])) {
                $this->replicationMetricList = $vals['replicationMetricList'];
            }
        }
    }

    public function getName()
    {
        return 'ReplicationMetricList';
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
                        $this->replicationMetricList = array();
                        $_size1395 = 0;
                        $_etype1398 = 0;
                        $xfer += $input->readListBegin($_etype1398, $_size1395);
                        for ($_i1399 = 0; $_i1399 < $_size1395; ++$_i1399) {
                            $elem1400 = null;
                            $elem1400 = new \metastore\ReplicationMetrics();
                            $xfer += $elem1400->read($input);
                            $this->replicationMetricList []= $elem1400;
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
        $xfer += $output->writeStructBegin('ReplicationMetricList');
        if ($this->replicationMetricList !== null) {
            if (!is_array($this->replicationMetricList)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('replicationMetricList', TType::LST, 1);
            $output->writeListBegin(TType::STRUCT, count($this->replicationMetricList));
            foreach ($this->replicationMetricList as $iter1401) {
                $xfer += $iter1401->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
