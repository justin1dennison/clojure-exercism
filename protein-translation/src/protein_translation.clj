(ns protein-translation)

(defn translate-codon [codon]
     (case codon 
       ("AUG") "Methionine"
       ("UUU" "UUC") "Phenylalanine"
       ("UUA" "UUG") "Leucine"
       ("UCU" "UCC" "UCA" "UCG") "Serine"
       ("UAU" "UAC") "Tyrosine"
       ("UGU" "UGC") "Cysteine"
       ("UGG") "Tryptophan"
       "STOP"))

(defn translate-rna [rna]
  (let [chunks (map #(clojure.string/join "" %) (partition 3 3 rna))]
    (into [] (take-while 
               #(not= % "STOP") 
               (map translate-codon chunks)))))
