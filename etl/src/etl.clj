(ns etl)

(defn transform [source]
  (into
   (hash-map)
   (for [x (keys source)
         y (get source x)]
     [(clojure.string/lower-case y) x])))
