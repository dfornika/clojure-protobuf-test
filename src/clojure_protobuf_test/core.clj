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
  (def Strand (protodef ga4gh.Common$Strand))
  (def CigarUnit (protodef ga4gh.Reads$CigarUnit))
    
  (def positive_strand (protobuf Strand "POS_STRAND"))
  
  (def p (protobuf Position
                   :reference_name "hg38"
                   :position 0
                   :strand positive_strand))
  
  (def la (protobuf LinearAlignment
                    :position p
                    :mapping_quality 0
                    :c))
  
  (def r (protobuf ReadAlignment
                   :id 
                   :read_group_id
                   :fragment_name
                   :improper_placement false
                   :duplicate_fragment false
                   :number_reads
                   :fragment_length
                   :read_number
                   :failed_vendor_quality_checks false
                   :alignment
                   :secondary_alignment false
                   :supplementary_alignment false
                   :aligned_sequence
                   :aligned_quality
                   :next_mate_position
                   :info))
)
