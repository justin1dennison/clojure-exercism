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
  (->> rna
       (partition 3 3)
       (map #(clojure.string/join "" %))
       (map translate-codon)
       (take-while #(not= % "STOP"))
       (into [])))
