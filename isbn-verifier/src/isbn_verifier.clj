(ns isbn-verifier
  (:require [clojure.string :as s]))

(def re-isbn-pattern #"[0-9]{9}[0-9X]{1}")

(defn- char->int [c]
  (if (= c \X)
    10
    (- (int c) 48)))

(defn- mod-eleven [n]
  (mod n 11))

(defn isbn? [isbn]
  (let [cleaned (s/replace isbn #"-" "")
        match (re-find re-isbn-pattern cleaned)
        calculation #(* %1 (inc %2))]
    (if (or (> (count cleaned) 10) (nil? match))
      false
      (->> match
           (map char->int)
           (reverse)
           (reduce (fn [[sum idx] element]
                     [(+ sum (calculation element idx))
                      (inc idx)]) [0 0])
           first
           mod-eleven
           zero?))))


