(ns isbn-verifier
  (:require [clojure.string :as s]))

(def re-isbn-pattern #"[0-9]{9}[0-9X]{1}")

(defn- char->int [c]
  (if (= c \X)
    10
    (- (int c) 48)))

(defn- mod-eleven [n]
  (mod n 11))

(defn- calculation [idx element]
  (* element (inc idx)))

(defn isbn? [isbn]
  (let [cleaned (s/replace isbn #"-" "")
        match (re-find re-isbn-pattern cleaned)]
    (and
     (= (count cleaned) 10)
     (not (nil? match))
     (->> match
          (map char->int)
          (reverse)
          (map-indexed calculation)
          (reduce +)
          mod-eleven
          zero?))))


