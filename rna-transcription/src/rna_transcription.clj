(ns rna-transcription)

(defn transcribe [n]
  (let [lookup {\G \C \C \G \T \A \A \U}]
    (assert (lookup n))
    (lookup n)))

(defn to-rna [dna]
  (->> dna
       (map transcribe)
       (apply str)))




