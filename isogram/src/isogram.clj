(ns isogram
  (:require [clojure.string :refer [lower-case]]))

(def allowed #{\  \-})

(defn isogram? [n]
  (let [word (lower-case n)
        clean (remove allowed word)]
    (=
     (count clean)
     (count (set clean)))))
