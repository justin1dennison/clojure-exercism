(ns flatten-array)

(def clojure-flatten flatten)

(defn flatten [arr]
  (filter
   (complement nil?)
   (clojure-flatten arr)))
