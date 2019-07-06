(ns etl)

(defn transform [source]
  (let [[k v] source]
    (merge (map #(hash-map % k) v))))

(defn transform [source]
  (into
   (hash-map)
   (for [x (keys source)
         y (get source x)]
     [(clojure.string/lower-case y) x])))
