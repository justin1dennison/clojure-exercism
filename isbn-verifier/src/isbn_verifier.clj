(ns isbn-verifier
  (:require [clojure.string :as s]))


(def re-isbn-pattern #"[0-9]{9}[0-9X]{1}")

(defn- char->int [c]
  (if (= c \X)
    10
    (- (int c) 48)))


(defn- part-calculation [idx element]
  (* element (inc idx)))

(defn- mod-eleven [n]
  (mod n 11))

(defn isbn? [isbn]
  (let [cleaned (s/replace isbn #"-" "")
        match (re-find re-isbn-pattern cleaned)]
    (if (or (> (count cleaned) 10) (nil? match))
      false
      (zero? (->> match
                  (map char->int)
                  (reverse)
                  (map-indexed part-calculation)
                  (reduce +)
                  mod-eleven)))))

(isbn? "11111111111")




