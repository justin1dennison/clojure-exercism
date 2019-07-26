(ns pangram
  (:require [clojure.string :refer [lower-case]]))

(def removals (set ",.|\\_1234567890 \""))

(defn pangram? [s]
  (->> s
       (lower-case)
       (remove removals)
       (frequencies)
       (vals)
       count
       (= 26)))


