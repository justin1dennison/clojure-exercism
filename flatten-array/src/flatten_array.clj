(ns flatten-array)


(defn flatten [arr]
  (filter
   (complement nil?)
   (clojure.core/flatten arr)))
