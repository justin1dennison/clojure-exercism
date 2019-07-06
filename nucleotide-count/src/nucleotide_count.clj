(ns nucleotide-count)

(defn nucleotide-counts [strand]
  (let [zero-map (hash-map \A 0, \G 0, \C 0, \T 0)]
    (if (= strand "")
      zero-map
      (apply merge-with +
             zero-map
             (map #(hash-map % 1) (seq strand))))))

(defn count [nucleotide strand]
  (let [counts (nucleotide-counts strand)
        possible #{\A \C \G \T}]
    (if (contains? possible nucleotide)
      (get counts nucleotide 0)
      (throw (Throwable. "Uh Oh")))))
