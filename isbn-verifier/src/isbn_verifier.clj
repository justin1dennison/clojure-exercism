(ns isbn-verifier
  (:require [clojure.string :as s]))


(def pattern #"[0-9]{9}[0-9X]{1}")

(defn- char->int [c]
  (if (= c \X)
    10
    (- (int c) 48)))


(defn- part-calculation [idx element]
  (* element (inc idx)))

(defn isbn? [isbn]
  (let [cleaned (s/replace isbn #"-" "")
        match (re-find pattern cleaned)]
    (if (or (> (count cleaned) 10) (nil? match))
      false
      (zero? (->> match
                  (map char->int)
                  (reverse)
                  (map-indexed part-calculation)
                  (reduce +)
                  (#(mod % 11)))))))


