(ns protein-translation)

(defn translate-codon [codon]
     (case codon 
       "AUG" "Methionine"
       "UUU" "Phenylalanine"
       "UUC" "Phenylalanine"
       "UUA" "Leucine"
       "UUG" "Leucine"
       "UCU" "Serine"
       "UCC" "Serine"
       "UCA" "Serine"
       "UCG" "Serine"
       "UAU" "Tyrosine"
       "UAC" "Tyrosine"
       "UGU" "Cysteine"
       "UGC" "Cysteine"
       "UGG" "Tryptophan"
       "STOP"))

(defn translate-rna [rna]
  (let [chunks (map #(clojure.string/join "" %) (partition 3 3 rna))]
    (into [] (take-while 
               #(not= % "STOP") 
               (map translate-codon chunks)))))
