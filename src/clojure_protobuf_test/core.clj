(ns clojure-protobuf-test.core
  (:gen-class))

(use 'flatland.protobuf.core)
(import ga4gh.Reads$ReadAlignment)
(import ga4gh.Reads$LinearAlignment)
(import ga4gh.Common$Position)
(import ga4gh.Common$Strand)
(import ga4gh.Reads$CigarUnit)

(defn -main
  ""
  [& args]
  (def ReadAlignment (protodef ga4gh.Reads$ReadAlignment))
  (def LinearAlignment (protodef ga4gh.Reads$LinearAlignment))
  (def Position (protodef ga4gh.Common$Position))
  (def CigarUnit (protodef ga4gh.Reads$CigarUnit))
  
  (def p0 (protobuf Position
                   :reference_name "hg38"
                   :position 0
                   :strand :POS_STRAND))

  (def p1 (protobuf Position
                   :reference_name "hg38"
                   :position 1
                   :strand :POS_STRAND))

  (def cu (protobuf CigarUnit
                    :operation :OPERATION_UNSPECIFIED
                    :operation_length 100))
  
  (def la (protobuf LinearAlignment
                    :position p0
                    :mapping_quality 0
                    :cigar_unit [cu cu cu]))
  
  (def r (protobuf ReadAlignment
                   :id "read alignment x"
                   :read_group_id "read group x"
                   :fragment_name "fragment x"
                   :improper_placement false
                   :duplicate_fragment false
                   :number_reads 1
                   :fragment_length 100
                   :read_number 0
                   :failed_vendor_quality_checks false
                   :alignment la
                   :secondary_alignment false
                   :supplementary_alignment false
                   :aligned_sequence "CGATGCATGACT"
                   :aligned_quality [30 30 30 30
                                     30 28 28 27
                                     26 22 20 18]
                   :next_mate_position p1
                   :info {:somedata [0 1 2]
                          :someotherdata ["foo" "bar"]}))
)
